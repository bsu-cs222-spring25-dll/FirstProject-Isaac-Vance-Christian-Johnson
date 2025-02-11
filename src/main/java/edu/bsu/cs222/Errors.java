package edu.bsu.cs222;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;
import java.net.URL;

public class Errors {

    public void checkEmptyInput(String input){
        if(input.isEmpty()){
            System.err.print("You did not provide an article.\n");
        }
    }

    public void checkConnectionStatus(URL url) {
        try {
            url.openConnection().connect();
        }
        catch (Exception NetworkError) {
            System.err.print("There was a network error; could not connect to the article.\n");
        }
    }

    public void checkMissingArticle(String jsonString){
        JSONArray checkForMissing = JsonPath.read(jsonString, "$..missing");
        if(!checkForMissing.isEmpty()){
            System.err.print("The article you tried to search for does not exist.\n");
        }
    }
}
