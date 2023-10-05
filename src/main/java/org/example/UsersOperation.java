package org.example;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class UsersOperation {

    private String uri = "https://jsonplaceholder.typicode.com/users";

    private HttpResponse<String> getResponse(HttpRequest httpRequest) throws IOException, InterruptedException {

        HttpClient httpClient = HttpClient.newHttpClient();
        HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.statusCode());
        return response;
    }

    public String get() throws IOException, InterruptedException, URISyntaxException {
        HttpRequest httpRequest = HttpRequest.newBuilder(new URI(uri))
                .GET()
                .version(HttpClient.Version.HTTP_1_1)
                .build();
        return getResponse(httpRequest).body();
    }

    public String post(File file) throws IOException, InterruptedException, URISyntaxException {
        HttpRequest httpRequest = HttpRequest.newBuilder(new URI (uri))
                .POST(HttpRequest.BodyPublishers.ofFile(file.toPath()))
                .build();
        return getResponse(httpRequest).body();
    }

    public String put(File file) throws IOException, InterruptedException, URISyntaxException {
        HttpRequest httpRequest = HttpRequest.newBuilder(new URI (uri))
                .PUT(HttpRequest.BodyPublishers.ofFile(file.toPath()))
                .build();
        return getResponse(httpRequest).body();
    }

    public void delete(int id) throws IOException, InterruptedException, URISyntaxException {
        HttpRequest httpRequest = HttpRequest.newBuilder(new URI (uri + "/" + id))
                .DELETE()
                .build();
        getResponse(httpRequest);
    }

    public String getUser(int id) throws IOException, InterruptedException, URISyntaxException {
        HttpRequest httpRequest = HttpRequest.newBuilder(new URI(uri + "/" + id))
                .GET()
                .version(HttpClient.Version.HTTP_1_1)
                .build();
        return getResponse(httpRequest).body();
    }

    public String getUserForUsername(String name) throws IOException, InterruptedException, URISyntaxException {
        HttpRequest httpRequest = HttpRequest.newBuilder(new URI(uri + "?username=" + name))
                .GET()
                .version(HttpClient.Version.HTTP_1_1)
                .build();
        return getResponse(httpRequest).body();
    }
}
