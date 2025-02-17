package edu.bsu.cs222;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.Charset;

public class WikiURL {
    static Errors errors = new Errors();

    public static URLConnection wikiURLConnection(String userInput) throws IOException {
        String encodedUrlString = "https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles=" +
                URLEncoder.encode(userInput, Charset.defaultCharset()) +
                "&rvprop=timestamp|user&rvlimit=20&redirects";
        URL url = new URL(encodedUrlString);
        URLConnection wikiConnection = url.openConnection();
        errors.checkConnectionStatus(url);
        wikiConnection.connect();



        URLConnection connection = url.openConnection();
        connection.setRequestProperty("User-Agent",
                "CS222FirstProject/0.1 (5419cjohnson@gmail.com)");
        connection.connect();
        return connection;
    }
}
