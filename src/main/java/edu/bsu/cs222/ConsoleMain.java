package edu.bsu.cs222;

import java.io.IOException;
import java.net.URLConnection;
import java.util.Scanner;
public class ConsoleMain {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        Errors errorChecker = new Errors();


        DataGetter dataGetter = new DataGetter();

        System.out.println("Enter a wiki page title: ");
        String userInput = scan.nextLine().toLowerCase();
        errorChecker.checkEmptyInput(userInput);

        URLConnection connection = WikiURL.wikiURLConnection(userInput);

        String jsonData = dataGetter.wikiDataGetter(connection);
        errorChecker.checkMissingArticle(jsonData);

        RevisionGetter revisionsPrinter = new RevisionGetter(jsonData);
        revisionsPrinter.createAndFormatArray();
        revisionsPrinter.checkRedirects();
        revisionsPrinter.printRevisions();

    }
}
