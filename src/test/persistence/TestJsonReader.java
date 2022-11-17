package persistence;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestJsonReader {
    JsonReader reader;
    JsonWriter writer;

    @BeforeEach
    void setup() {
        reader = new JsonReader("./data/datatest.json");
        writer = new JsonWriter("./data/datatest.json");
    }

    @Test
    void testReader() {
        ArrayList<String> in =new ArrayList<>();
        ArrayList<String> out =new ArrayList<>();

        in.add("ayush");
        in.add("ubc");
        in.add("compsci");
        out.add("tejas");
        out.add("asu");
        out.add("compsci");
        writer.write(in,out);
        ArrayList<String> finalin=reader.buildUserInput();
        ArrayList<String> finalout=reader.buildUserOutput();
        assertEquals("ayush",finalin.get(0));
        assertEquals("ubc",finalin.get(1));
        assertEquals("compsci",finalin.get(2));
        assertEquals("tejas",finalout.get(0));
        assertEquals("asu",finalout.get(1));
        assertEquals("compsci",finalout.get(2));


    }
}
