package edu.bsu.cs222;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.net.URLConnection;

public class DataGetterTest {

    @Test
    public void jsonToStringNotEmpty() throws IOException {
        DataGetter testString = new DataGetter();
        URLConnection connection = WikiURL.wikiURLConnection("Frank Zappa");
        String resultTest = testString.wikiDataGetter(connection);
        Assertions.assertNotEquals(resultTest, "");
    }
}
