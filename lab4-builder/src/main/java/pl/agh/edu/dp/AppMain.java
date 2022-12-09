package pl.agh.edu.dp;

import org.json.JSONException;
import org.json.JSONObject;
import pl.agh.edu.dp.objects.JsonObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class AppMain {

    public static String getJsonContent(String filename) throws IOException {
        String content = Files.readString(Paths.get(filename));
        try {
            new JSONObject(content);
        } catch (JSONException e){
            e.printStackTrace();
            throw new RuntimeException("YOUR JSON IS INVALID!");
        }
        return content;
    }

    public static void main(String[] args) throws IOException {
        String lines = getJsonContent("example.json");
        Manager manager = new Manager(lines);
        JsonObject json = manager.createJson();
        System.out.println("Just a print to make a breakpoint here");

    }
}
