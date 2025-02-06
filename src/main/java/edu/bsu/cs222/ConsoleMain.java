package edu.bsu.cs222;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URLConnection;
import java.util.Scanner;
public class ConsoleMain {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        WikiURL urlConnector = new WikiURL();
        RevisionGetter parser = new RevisionGetter();

        System.out.println("Enter a wiki page title: ");
        String userInput = scan.nextLine();

        URLConnection connection = urlConnector.WikiURLConnection(userInput);
        JSONObject jsonData = new DataGetter().WikiDataGetter(connection);

        RevisionGetter revisions = new RevisionGetter();
        System.out.println(revisions.ArrayMaker(jsonData));

    }
}
