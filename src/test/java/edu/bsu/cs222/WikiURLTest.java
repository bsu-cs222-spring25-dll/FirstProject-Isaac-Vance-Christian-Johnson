package edu.bsu.cs222;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URLConnection;

public class WikiURLTest {
    @Test
    public void wikiURLConnection() throws IOException {
        WikiURL wiki = new WikiURL();
        URLConnection wikiTest = wiki.WikiURLConnection("Zappa");
        Assertions.assertNotNull(wikiTest);
    }
}
