package persistence;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    public ArrayList buildUserInput() {
        ArrayList<String> in = new ArrayList<>();
        String json = null;
        try {
            json = readFile("./data/data2.json");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        JSONObject o = new JSONObject(json);
        JSONArray a = new JSONArray(o.getJSONArray("UI"));
        for (Object j : a) {

            in.add(j.toString());
        }
        return in;
    }

    public ArrayList buildUserOutput() {
        ArrayList<String> out = new ArrayList<>();
        String json = null;
        try {
            json = readFile("./data/data2.json");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        JSONObject o = new JSONObject(json);
        JSONArray a = new JSONArray(o.getJSONArray("OUT"));
        for (Object j : a) {

            out.add(j.toString());
        }
        return out;
    }
}
