package edu.bsu.cs222;

import net.minidev.json.JSONArray;

public class UnknownUser {

    public JSONArray formatUnknownUsers(JSONArray names) {
        for (int i = 0; i < names.size(); i++) {
            if (!names.get(i).toString().matches(".*[A-Z].*") || names.get(i).toString().contains(":")) {
                names.set(i, "Anonymous User");
            }
        }
        return names;
    }

}
