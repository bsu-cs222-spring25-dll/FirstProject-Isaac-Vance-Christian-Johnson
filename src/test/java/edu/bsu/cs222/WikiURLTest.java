package edu.bsu.cs222;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

import java.nio.charset.Charset;
import java.util.Objects;

public class WikiURLTest {
    @Test
    public void getsFrankZappaURL() {
        String frankURL;
        try {
            frankURL = String.valueOf(WikiURL.wikiURLConnection("Frank Zappa"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Assertions.assertNotNull(frankURL);
    }

    @Test
    public void testAccessToJsonFile() throws IOException {
        String jsonData = readSampleFileAsString();
        Assertions.assertNotNull(jsonData);
    }

    private String readSampleFileAsString() throws NullPointerException, IOException {
        try (InputStream sampleFile = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("sample.json")) {
            return new String(Objects.requireNonNull(sampleFile).readAllBytes(), Charset.defaultCharset());
        }
    }
}
