package edu.bsu.cs222;

import org.json.JSONObject;

import java.io.IOException;
import java.net.URLConnection;

import static java.nio.charset.Charset.defaultCharset;

public class DataGetter {
   public JSONObject WikiDataGetter(URLConnection wikiConnection) throws IOException {
       return new JSONObject(wikiConnection.getInputStream().readAllBytes());
   }
}
