package edu.bsu.cs222;

import org.json.JSONObject;
public class RevisionGetter() {
    public String revisionParse(String jsonData){
        JSONObject object = new JSONObject(json);
        JSONObject revisions = object.getJSONObject("revisions");
        return revisions;
    }
}
