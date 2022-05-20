package br.com.amz.playground.mess;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class RestWithoutFrameworkJava {

    /**
     * This code should make a simple GET request, but using only Java native resources.
     * No frameworks, no external libraries.
     **/
    public static void main(String[] args) throws IOException {
        final var bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final var bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        final var threshold = Integer.parseInt(bufferedReader.readLine().trim());

        final List<String> result = getUsernames(threshold);

        bufferedWriter.write(String.join("\n", result) + "\n");

        bufferedReader.close();
        bufferedWriter.close();
    }

    public static List<String> getUsernames(int threshold) throws IOException {
        final var apiResponse = makeRequest(threshold);
        final List<String> list = new ArrayList<>();

        list.add(apiResponse);

        return list;
    }

    private static String makeRequest(int page) throws IOException {
        final var host = "https://jsonmock.hackerrank.com/api/article_users?page=";
        final var api = host.concat(String.valueOf(page));
        final var connection = (HttpURLConnection) new URL(api).openConnection();

        connection.setRequestProperty("accept", "application/json");

        final var responseStream = connection.getInputStream();
        final var response = String.valueOf(responseStream.read());

        responseStream.close();

        return response;
    }
}
