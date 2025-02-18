package edu.bsu.cs222;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URLConnection;
import java.util.ArrayList;



public class JavaFXGUI extends Application  {
    TextField output = new TextField();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox parent = new VBox();
        parent.getChildren().add(new Label("Wiki Revisions Getter"));

        HBox wikiPageInput = new HBox(new Label("Enter a Wiki page: "));
        TextField userInput = new TextField();
        wikiPageInput.getChildren().add(userInput);
        parent.getChildren().add(wikiPageInput);
        output.setEditable(false);


        Button submit = new Button("Submit");
        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String wikiPageInput = userInput.getText();
                try {
                    wikiConnection(wikiPageInput);
//                    String revisions = wikiConnection(wikiPageInput);
//                    output.setText(revisions);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        parent.getChildren().add(submit);
        parent.getChildren().add(output);

        primaryStage.setScene(new Scene(parent));
        primaryStage.show();
    }

    public String wikiConnection(String userInput) throws IOException {
        DataGetter dataGetter = new DataGetter();
        Errors errorChecker = new Errors();

        URLConnection connection = WikiURL.wikiURLConnection(userInput);
        String jsonData = dataGetter.wikiDataGetter(connection);
        errorChecker.checkMissingArticle(jsonData);

        RevisionGetter revisionsPrinter = new RevisionGetter(jsonData);
        revisionsPrinter.createAndFormatArray();
        ArrayList<String> arrayList = revisionsPrinter.printRevisionsGUI();

        output.setText(String.valueOf(arrayList));

        String revisions = revisionsPrinter.printRevisions();
        return revisions;

    }

}
