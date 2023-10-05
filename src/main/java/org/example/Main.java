package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;


public class Main {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {

        String uri = "https://jsonplaceholder.typicode.com/users";
        int id = 1;
        String name = "Moriah.Stanton";

        UsersOperation operation = new UsersOperation();

        File users = new File("users.json");
        String user = "{\n" +
                "  \"name\": \"Michael\",\n" +
                "  \"username\": \"Smirnoff\",\n" +
                "  \"email\": \"andrewhu08@test.com\",\n" +
                "  \"address\": {\n" +
                "    \"street\": \"Kulas Light\",\n" +
                "    \"suite\": \"Apt. 556\",\n" +
                "    \"city\": \"Gwenborough\",\n" +
                "    \"zipcode\": \"92998-3874\",\n" +
                "    \"geo\": {\n" +
                "      \"lat\": \"-37.3159\",\n" +
                "      \"lng\": \"81.1496\"\n" +
                "    }\n" +
                "  },\n" +
                "  \"phone\": \"+380636669990\",\n" +
                "  \"website\": \"rap.ua\",\n" +
                "  \"company\": {\n" +
                "    \"name\": \"Triple-A\",\n" +
                "    \"catchPhrase\": \"Rapper\",\n" +
                "    \"bs\": \"writing rap compositions\"\n" +
                "  }\n" +
                "}";
        try (FileWriter writer = new FileWriter(users, true))
        {
            writer.write(user + "\n");
            writer.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(operation.post(users));
        System.out.println(operation.put(users));
        operation.delete(id);
        System.out.println(operation.get());
        System.out.println(operation.getUser(id));
        System.out.println(operation.getUserForUsername(name));


    }
}