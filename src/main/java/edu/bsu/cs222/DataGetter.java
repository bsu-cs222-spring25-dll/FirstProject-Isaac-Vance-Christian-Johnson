package edu.bsu.cs222;

import java.io.IOException;
import java.net.URLConnection;

import static java.nio.charset.Charset.defaultCharset;

public class DataGetter {
   public String WikiDataGetter(URLConnection wikiConnection) throws IOException {
       return new String (wikiConnection.getInputStream().readAllBytes());
   }
}
