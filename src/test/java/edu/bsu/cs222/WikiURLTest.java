package edu.bsu.cs222;

import org.json.JSONObject;
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
    @Test
    public void DataGetterTest() throws IOException {
        WikiURL wikiurl = new WikiURL();
        DataGetter dataTest = new DataGetter();
        JSONObject expectedData = new JSONObject("{\"continue\":{\"rvcontinue\":\"20241218165643|1263787082\",\"continue\":\"||\"},\"quer\n" +
                "y\":{\"redirects\":[{\"from\":\"Zappa\",\"to\":\"Frank\n" +
                "Zappa\"}],\"pages\":{\"10672\":{\"pageid\":10672,\"ns\":0,\"title\":\"Frank\n" +
                "Zappa\",\"revisions\":[{\"user\":\"2001:D08:1282:EE00:BD:EADB:7D8D:AA31\",\"anon\":\"\"\n" +
                ",\"timestamp\":\"2024-12-\n" +
                "28T11:10:29Z\"},{\"user\":\"Matthiaspaul\",\"timestamp\":\"2024-12-\n" +
                "23T00:43:51Z\"},{\"user\":\"2A00:23C5:E212:D01:3471:AEDE:EE06:8A0\",\"anon\":\"\",\"ti\n" +
                "mestamp\":\"2024-12-\n" +
                "18T16:58:59Z\"},{\"user\":\"2A00:23C5:E212:D01:3471:AEDE:EE06:8A0\",\"anon\":\"\",\"ti\n" +
                "mestamp\":\"2024-12-18T16:57:10Z\"}]}}}}");
        JSONObject data = dataTest.WikiDataGetter(wikiurl.WikiURLConnection("zappa"));
        Assertions.assertEquals(expectedData,data);

    }
}
