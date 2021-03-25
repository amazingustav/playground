package br.com.amz.playground.mess;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class RestWithoutFrameworkJava {

    /**
     * This code should make a simple GET request, but using only Java native resources.
     * No frameworks, no libraries.
     **/
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int threshold = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> result = getUsernames(threshold);

        bufferedWriter.write(String.join("\n", result) + "\n");

        bufferedReader.close();
        bufferedWriter.close();
    }

    public static List<String> getUsernames(int threshold) throws IOException {
        String apiResponse = makeRequest(1);
        List<String> list = new ArrayList<>();

        list.add(apiResponse);

        return list;
    }

    private static String makeRequest(int page) throws IOException {
        String host = "https://jsonmock.hackerrank.com/api/article_users?page=";
        String api = host.concat(String.valueOf(page));

        URL url = new URL(api);

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestProperty("accept", "application/json");

        InputStream responseStream = connection.getInputStream();

        String response = new String(responseStream.readAllBytes());

        responseStream.close();

        return response;
    }
}
