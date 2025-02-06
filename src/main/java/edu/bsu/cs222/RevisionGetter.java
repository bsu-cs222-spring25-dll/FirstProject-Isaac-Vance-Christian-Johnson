package edu.bsu.cs222;

import org.json.JSONArray;
import org.json.JSONObject;
public class RevisionGetter {
    public String revisionParse(String jsonData){
        JSONArray revisionArray = new JSONArray();

        return revisionArray.toString();

    }
    public String ArrayMaker(JSONObject jsonData){
        return  (jsonData.getJSONObject("$..revisions").toString());


    }
}
