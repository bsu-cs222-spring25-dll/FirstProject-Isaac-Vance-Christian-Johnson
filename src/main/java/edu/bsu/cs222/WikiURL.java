package edu.bsu.cs222;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class WikiURL {
    public URLConnection WikiURLConnection(String userInput) throws IOException {
        String stringURL = "https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles="+userInput+"&rvprop=timestamp|user&rvlimit=4&redirects";
        URL url = new URL(stringURL);
        URLConnection wikiConnection = url.openConnection();
        wikiConnection.connect();
        return wikiConnection;
    }
}
