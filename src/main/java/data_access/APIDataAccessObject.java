package data_access;

import entities.Entrant;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import use_case.main.MainDataAccessInterface;
import use_case.select_phase.SelectPhaseDataAccessInterface;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class APIDataAccessObject implements SelectPhaseDataAccessInterface, MainDataAccessInterface {

    private static final String TOKEN = "token";
    private static final String API_URL = "https://api.start.gg/gql/alpha";

    public String testKey(){
        return System.getenv(TOKEN);
    }
    public void getEvent() {
        String q = "query getEventId($slug: String) {event(slug: $slug) {id name}}";

        String json = "{ \"query\": \"" + q + "\", \"variables\": { \"slug\": \"tournament/ultimate-tmu-ep-4/event/ultimate-singles\"}}";
        OkHttpClient client = new OkHttpClient();
        MediaType mediaType = MediaType.parse("application/json");

        RequestBody body = RequestBody.create(json, mediaType);
        Request request = new Request.Builder()
                .url(API_URL)
                .addHeader("Authorization", "Bearer " + System.getenv(TOKEN))
                .post(body)
                .build();
        try {
            Response response = client.newCall(request).execute();
            String jsonResponse = response.body().string();
            System.out.println(jsonResponse);
        }
        catch (IOException | JSONException event) {
            throw new RuntimeException(event);
        }


    }

    @Override
    public Entrant[] getEntrantsInEvent(String EventID) {
        return new Entrant[0];
    }

    @Override
    public String[] getPhaseIDs(String eventID) {
        return new String[0];
    }

    @Override
    public List<String> getSeedinginPhase(String phaseID) {
        return new ArrayList<>();
    }
}
