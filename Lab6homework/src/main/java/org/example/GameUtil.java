package org.example;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;


public class GameUtil {

    public static void save(Game game, String path) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.writeValue(new File(path), game);
    }

    public static Game load(String path) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Game game = mapper.readValue(new File(path), Game.class);
        return game;
    }
}
