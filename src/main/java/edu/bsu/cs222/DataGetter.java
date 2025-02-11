package edu.bsu.cs222;



import java.io.IOException;
import java.net.URLConnection;



public class DataGetter {
   public String wikiDataGetter(URLConnection wikiConnection) throws IOException {
       return new String(wikiConnection.getInputStream().readAllBytes());
   }
}
