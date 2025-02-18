package edu.bsu.cs222;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URLConnection;
import java.util.ArrayList;



public class JavaFXGUI extends Application  {
    TextArea output = new TextArea();


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        VBox parent = new VBox();
        parent.getChildren().add(new Label("Wiki Revisions Getter"));

        HBox wikiPageInput = new HBox(new Label("Enter a Wiki page: "));
        TextField userInput = new TextField();
        wikiPageInput.getChildren().add(userInput);
        parent.getChildren().add(wikiPageInput);
        output.setEditable(false);
        output.setWrapText(true);
        output.setMaxHeight(300);
        output.setMaxWidth(500);


        Button submit = new Button("Submit");
        submit.setOnAction(actionEvent -> {
            String wikiPageInput1 = userInput.getText();
            try {
                wikiConnection(wikiPageInput1);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        parent.getChildren().add(submit);
        parent.getChildren().add(output);

        primaryStage.setScene(new Scene(parent));
        primaryStage.show();
    }

    public void wikiConnection(String userInput) throws IOException {
        DataGetter dataGetter = new DataGetter();
        Errors errorChecker = new Errors();

        if (!errorChecker.checkEmptyInputGUI(userInput).isEmpty()){
            output.setText(errorChecker.checkEmptyInputGUI(userInput));
        }

        URLConnection connection = WikiURL.wikiURLConnection(userInput);
        String jsonData = dataGetter.wikiDataGetter(connection);
        if (!errorChecker.checkMissingArticleGUI(jsonData).isEmpty()) {
            output.setText(errorChecker.checkMissingArticleGUI(jsonData));
        }

        RevisionGetter revisionsPrinter = new RevisionGetter(jsonData);
        revisionsPrinter.createAndFormatArray();
        if (!revisionsPrinter.checkRedirectsGUI().isEmpty()){
            output.setText(revisionsPrinter.checkRedirectsGUI());
        }
        revisionsPrinter.checkRedirectsGUI();
        ArrayList<String> arrayList = revisionsPrinter.printRevisionsGUI();

        output.appendText(arrayList + "\n");

    }

}
