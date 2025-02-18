package edu.bsu.cs222;

import net.minidev.json.JSONArray;

import java.util.ArrayList;

public class RevisionGetter {
    private final String jsonString;

    public  RevisionGetter(String jsonString) {
        this.jsonString = jsonString;
    }

    JSONArray names, timestamps;

    public void createAndFormatArray() {
        JSONArrayCreator createdArray = new JSONArrayCreator(jsonString);
        UnknownUser formatter = new UnknownUser();

        names = formatter.formatUnknownUsers(createdArray.createArray("$..revisions..user"));
        timestamps = createdArray.createArray("$..revisions..timestamp");
    }

    public String printRevisions() {
        String result = null;
        for (int i = 0; i < names.size(); i++) {
            result = System.out.printf("Timestamp: %s User: %s\n", timestamps.get(i).toString(), names.get(i).toString()).toString();
        }
        return result;
    }

    public ArrayList<String> printRevisionsGUI() {
        String result;
        ArrayList<String> arrayList = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < names.size(); i++) {
            stringBuilder.append("Timestamp: ").append(timestamps.get(i).toString()).append("User: ").append(names.get(i).toString()).append("\n");
            arrayList.add(stringBuilder.toString());
        }
        return arrayList;
    }

    public void checkRedirects() {
        if (jsonString.contains("redirects")) {
            System.out.printf("Redirected to %s\n\n", new JSONArrayCreator(jsonString).createArray("$..redirects..to").get(0).toString());
        }
    }
}
