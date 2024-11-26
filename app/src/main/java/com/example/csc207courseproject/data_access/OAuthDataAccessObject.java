package com.example.csc207courseproject.data_access;

import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import com.example.csc207courseproject.BuildConfig;
import fi.iki.elonen.NanoHTTPD;
import okhttp3.*;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;
import com.example.csc207courseproject.use_case.login.LoginDataAccessInterface;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class OAuthDataAccessObject implements LoginDataAccessInterface {

    private final String CLIENT_ID = BuildConfig.CLIENT_ID;
    private final String CLIENT_SECRET = BuildConfig.CLIENT_SECRET;
    private final String REDIRECT_URI = "http://localhost:8080/callback";
    private final String SCOPES = "user.identity%20user.email%20tournament.manager%20tournament.reporter";
    private final String TOKEN_REQUEST_URL = "https://api.start.gg/oauth/access_token";
    private final String API_URL = "https://api.start.gg/gql/alpha";
    private String AUTH_CODE;
    private String ACCESS_TOKEN;
    private OAuthServer oAuthServer;

    private static CountDownLatch latch = new CountDownLatch(1);

    @Override
    public String login(AppCompatActivity activity) {
        // Get authorization code
        try {
            getAuthCode(activity);
        } catch (URISyntaxException | IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (AUTH_CODE == null) {
            throw new RuntimeException("Auth code is null");
        }

        // Get access token
        try {
            getToken();
        } catch (InterruptedException | RuntimeException e) {
            throw new RuntimeException(e);
        }
        return ACCESS_TOKEN;
    }

     class OAuthServer extends NanoHTTPD {

        /**
         * Starts a localhost server at port 8080.
         */
        public OAuthServer() throws IOException {
            super(8080);                   // set port to 8080
            start();                            // start server
        }

        /**
         * Handles incoming HTTP requests.
         * @param session contains information about the current request
         */
        public Response serve(IHTTPSession session) {
            Map<String, List<String>> params = session.getParameters();
            if (params.containsKey("code")) {
                String authCode = params.get("code").get(0);
                AUTH_CODE = authCode;
                latch.countDown();
                return newFixedLengthResponse("Authorization code received! You may close this window now.");             // message to send back to the user, who made the request
            }
            return null;
        }
    }

    private void getAuthCode(AppCompatActivity activity) throws URISyntaxException, IOException, InterruptedException {

        oAuthServer = new OAuthServer();

        String authURL = "https://start.gg/oauth/authorize" +
                "?response_type=code" +
                "&client_id=" + CLIENT_ID
                + "&scope=" + SCOPES
                + "&redirect_uri=" + REDIRECT_URI;

        // Create an Intent to open the URL in the browser
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(authURL));
        activity.startActivity(browserIntent);              // Launch the browser

        latch.await(5, TimeUnit.MINUTES);           // wait for the server to get the auth code (max 5 minutes)
        Log.d("auth_code", AUTH_CODE);
    }

    private void getToken() throws InterruptedException {
        latch = new CountDownLatch(1);
        String jsonBody = "{"
                + "\"grant_type\": \"authorization_code\","
                + "\"code\": \"" + AUTH_CODE + "\","
                + "\"client_id\": \"" + CLIENT_ID + "\","
                + "\"client_secret\": \"" + CLIENT_SECRET + "\","
                + "\"redirect_uri\": \"" + REDIRECT_URI + "\","
                + "\"scope\": \"" + SCOPES + "\""
                + "}";

        Log.d("jsonBody", jsonBody);

        OkHttpClient client = new OkHttpClient();
        Log.d("client", client.toString());

        // Create the request body
        RequestBody body = RequestBody.create(jsonBody, MediaType.get("application/json"));

        // Build the request
        Request request = new Request.Builder()
                .url(TOKEN_REQUEST_URL)
                .post(body)
                .build();

        // Cannot run network operation on main thread.
        // Run the network call on another thread and pass in a callback function.
        client.newCall(request).enqueue(new Callback() {
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                Log.d("onFailure", e.getMessage());
                latch.countDown();
                throw new RuntimeException(e.getMessage());
            }
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                if (response.isSuccessful()) {
                    String responseBody = response.body().string();
                    Log.d("responseBody", responseBody);
                    JSONObject jsonResponse = null;
                    try {
                        jsonResponse = new JSONObject(responseBody);
                    } catch (JSONException e) {
                        latch.countDown();
                        throw new RuntimeException(e);
                    }
                    try {
                        ACCESS_TOKEN = jsonResponse.getString("access_token");
                        Log.d("ACCESS_TOKEN", ACCESS_TOKEN);
                        latch.countDown();
                    } catch (JSONException e) {
                        latch.countDown();
                        throw new RuntimeException(e);
                    }
                }
                else {
                    latch.countDown();
                    throw new RuntimeException(response.message());
                }
            }
        });

        latch.await();
    }

    public void stopServer() {
        oAuthServer.stop();
    }

    @Override
    public List getTournaments() {
        String q = "query getCurrentUser($page: Int!, $perPage: Int!) { currentUser { name " +
                "tournaments(query: { page: $page, perPage: $perPage }) { nodes { id name } } } }";

        String json = "{ \"query\": \"" + q + "\", \"variables\": { \"page\": 1, \"perPage\": 10 } }";

        OkHttpClient client = new OkHttpClient();
        MediaType mediaType = MediaType.parse("application/json");

        RequestBody body = RequestBody.create(json, mediaType);
        Request request = new Request.Builder()
                .url(API_URL)
                .header("Authorization", "Bearer " + ACCESS_TOKEN)
                .post(body)
                .build();

        try {
            Response response = client.newCall(request).execute();
            final JSONObject jsonResponse = new JSONObject(response.body().string());
            final JSONObject currUser = jsonResponse.getJSONObject("data")
                    .getJSONObject("currentUser");
            System.out.println(currUser.getString("name"));
            return new ArrayList();
            // currUser.getJSONObject("tournaments").getJSONArray("nodes"));
        }
        catch (IOException | JSONException event) {
            throw new RuntimeException(event);
        }
    }
}