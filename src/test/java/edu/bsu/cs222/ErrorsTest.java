package edu.bsu.cs222;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class ErrorsTest {

    @Test
    public void checkEmptyInputTest() {
        String input = "";
        Errors errorChecker = new Errors();
        errorChecker.checkEmptyInput(input);
        Assertions.assertEquals("", input);
    }

    @Test
    public void checkMissingArticleTest() {
        String testJSON = "sample.json";
        Errors errorChecker = new Errors();
        errorChecker.checkMissingArticle(testJSON);
        Assertions.assertNotNull(testJSON);
    }

    @Test
    public void checkConnectionStatusTest() throws MalformedURLException {
        String urlString = "https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles=Frank Zappa&rvprop=timestamp|user&rvlimit=15&redirects";
        URL urlActual = new URL(urlString);
        Errors errorChecker = new Errors();
        errorChecker.checkConnectionStatus(urlActual);
        Assertions.assertNotNull(urlActual);
    }
}
