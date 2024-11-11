package app;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class GraphQLRequest {
    public static void main(String[] args) {
        try {
            // Define the GraphQL endpoint
            URL url = new URL("https://api.start.gg/gql/alpha");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Set up the connection properties
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Authorization", "Bearer f40579d780f236716f71e26206c6aad3"); // Add your token here
            connection.setDoOutput(true);

            // Define the GraphQL query
            String query = "{ \"query\": \"query { user(id: \\\"123\\\") { fullName, nickname } }\" }";
            byte[] input = query.getBytes(StandardCharsets.UTF_8);

            // Write the query to the output stream
            try (OutputStream outputStream = connection.getOutputStream()) {
                outputStream.write(input, 0, input.length);
            }

            // Read the response
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                try (java.io.BufferedReader in = new java.io.BufferedReader(
                        new java.io.InputStreamReader(connection.getInputStream()))) {
                    String responseLine;
                    StringBuilder content = new StringBuilder();
                    while ((responseLine = in.readLine()) != null) {
                        content.append(responseLine);
                    }
                    System.out.println("Response: " + content.toString());
                }
            } else {
                System.out.println("Request failed. Response Code: " + responseCode);
            }

            connection.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


