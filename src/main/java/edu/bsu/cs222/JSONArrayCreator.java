package edu.bsu.cs222;

import net.minidev.json.JSONArray;
import com.jayway.jsonpath.JsonPath;


public class JSONArrayCreator {
    String jsonString;

    public JSONArrayCreator(String jsonString) {
        this.jsonString = jsonString;
    }

    public JSONArray createArray (String jsonPath) {
        return JsonPath.read(jsonString, jsonPath);
    }
}
