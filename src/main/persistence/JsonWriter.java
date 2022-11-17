package persistence;

import model.SuperCipher;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class JsonWriter {
    private static final int TAB = 4;
    private PrintWriter writer;
    private String destination;

    // EFFECTS: constructs writer to write to destination file
    public JsonWriter(String destination) {
        this.destination = destination;
    }

    // MODIFIES: this
    // EFFECTS: opens writer; throws FileNotFoundException if destination file cannot
    // be opened for writing
    public void open() throws FileNotFoundException {
        writer = new PrintWriter(new File(destination));
    }

    public void write(ArrayList<String> in, ArrayList<String> out) {
        JSONObject obj = new JSONObject();
        obj.put("UI", in);
        obj.put("OUT", out);
        PrintWriter print;
        try {
            print = new PrintWriter("./data/data2.json");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        print.print(obj.toString(4));
        print.close();

    }
}
