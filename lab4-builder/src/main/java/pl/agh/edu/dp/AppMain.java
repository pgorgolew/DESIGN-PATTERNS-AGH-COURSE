package pl.agh.edu.dp;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class AppMain {

    public static String getJsonContent(String filename) throws IOException {
        String content = Files.readString(Paths.get(filename));
        try {
            JSONObject jsonObject = new JSONObject(content);
        } catch (JSONException e){
            e.printStackTrace();
            throw new RuntimeException("YOUR JSON IS INVALID!");
        }
        return content;
    }

    public static void main(String[] args) throws IOException {
        String lines = getJsonContent("example.json");
        Manager manager = new Manager(lines);
        manager.createJson();

    }
}
