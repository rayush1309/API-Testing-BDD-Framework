package JiraAPI;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

    public class ExtractHeaders {

        public static void main(String[] args) {
            String apiUrl = "https://example.com"; // Replace with your API URL

            try {
                URL url = new URL(apiUrl);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("POST");

                int responseCode = connection.getResponseCode();
                if (responseCode == HttpURLConnection.HTTP_OK ){
                    Map<String, java.util.List<String>> headers = connection.getHeaderFields();
                    System.out.println("Headers from the API:");
                    for (Map.Entry<String, java.util.List<String>> entry : headers.entrySet()) {
                        System.out.println(entry.getKey() + ": " + entry.getValue());
                    }
                } else {
                    System.out.println("Failed to retrieve headers. Response code: " + responseCode);
                }
            } catch (IOException e) {
                System.out.println("Error accessing the API: " + e.getMessage());
            }
        }
    }



