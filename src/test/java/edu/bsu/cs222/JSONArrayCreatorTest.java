package edu.bsu.cs222;

import net.minidev.json.JSONArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.net.URLConnection;
import java.nio.charset.Charset;

public class JSONArrayCreatorTest {

    @Test
    public void TestJSONArrayCreator() throws IOException {
        JSONArrayCreator arrayCreatorTest = new JSONArrayCreator(makeJSONStringForTesting());
        JSONArray testArray = arrayCreatorTest.createArray("$..revisions..timestamp");
        Assertions.assertEquals(15, testArray.size());
    }
    private String makeJSONStringForTesting() throws IOException {
        URLConnection connection = WikiURL.wikiURLConnection("Frank Zappa");
        return new String(connection.getInputStream().readAllBytes(), Charset.defaultCharset());
    }
}
