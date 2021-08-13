package com.example.demo.TypeEffects;

import java.io.FileWriter;
import java.io.IOException;

import com.example.demo.RequestMode;
import com.example.demo.Pokedex.Pokedex;
import com.example.demo.Searches.PokemonSearch.NameHolder;

import org.json.simple.JSONObject;

public class TypeStore {
    final static private String TYPE_FILE_PATH = "./pokeBattleSim/src/main/java/com/example/demo/TypeEffects/TypeTable.json";
    final static private String CLASSICAL_TYPES_PATH = "https://pokeapi.co/api/v2/type?limit=16";

    public static void updateTypes() {
        JSONObject test = new JSONObject();
        test.put("value", 15);
        try {
            FileWriter file = new FileWriter(TYPE_FILE_PATH);
            file.write(test.toJSONString());
            file.close();
        } catch (IOException e) {
            System.out.println("___WRITING TYPE TABLE FAILED___" + e.getClass());
        }

    };

    private static NameHolder[] getTypes() {
        try {
            NameHolder[] types = Pokedex.getPokeData(Pokedex.API_PATH + Pokedex.CLASSICAL_TYPES_PATH,
                    NameHolder[].class, RequestMode.JAVA_11);
            return types;
        } catch (IOException | InterruptedException e) {
            System.out.println("___FAILING TYPE LOADING___" + e.getClass());
        }

        return new NameHolder[0];
    }
}

class TypeTable {
    private NameHolder[] types;

    TypeTable(NameHolder[] types) {
        this.types = types;
    }
}