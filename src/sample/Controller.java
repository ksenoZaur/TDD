package sample;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.*;

import static sample.Main.primaryStage;

public class Controller {

    public ComboBox comboBoxPattern;

    public static Controller self;

    public TextArea codeViewer;
    public String stockText;

    public Button generateCode;
    public ComboBox comboBoxLanguages;
    public JFXButton save;
    public JFXButton showImage;

    Generator generator;

    final FileChooser fileChooser;

    public Controller(){

        self = this;
        this.generator = new Generator();
        this.fileChooser = new FileChooser();

    }

    public ComboBox getComboBoxLanguages() {
        return comboBoxLanguages;
    }

    @FXML
    public void initialize() {

        ArrayList<String> patternsList = this.generator.getPatterns();

        int key = 0;
        for ( String capture: patternsList ) {
            ObservableList a = comboBoxPattern.getItems();
            a.add(key, capture);
            key++;
        }

        ArrayList<String> languagesList = this.generator.getLanguages();

        key = 0;
        for ( String capture: languagesList) {
            ObservableList a = comboBoxLanguages.getItems();
            a.add(key, capture);
            key++;
        }

    }

    public void setText(String code) {

        this.codeViewer.setText("");

        this.stockText = code;
        code = code.replaceAll(";", "; \n ");
        code = code.replaceAll("\\{", " { \n ");
        code = code.replaceAll("\\}", " } ");

        String[] words = code.split(" ");
        int depth = 0;

        String prev = "";
        for( String word: words ){

            if( word.equals("") ){
                continue;
            }

            if( word.equals("}")){
                depth--;
            }

            if( prev.equals("}") && !word.equals(";") ){

                this.codeViewer.appendText("\n");

            }

            String str2 = new String(new char[depth]).replace("\0", "     ");

            if( prev.equals("\n")){
                this.codeViewer.appendText(str2);
            }

            this.codeViewer.appendText(" " + word);

            if(word.equals("{")){
                depth++;
            }

            prev = word;
        }

    }

    public String getTextFromTextArea() {
        return this.stockText;
    }

    public Button getGenerateCode() {
        return generateCode;
    }

    public void generateButtonAction(ActionEvent actionEvent) {
        //TODO
        String code = this.generator.generate(this.comboBoxPattern.getSelectionModel().getSelectedIndex(),
                this.comboBoxLanguages.getSelectionModel().getSelectedIndex());
        this.setText( code );

    }

    public ComboBox getComboBoxPattern() {
        return comboBoxPattern;
    }


    public void createWindow(ActionEvent actionEvent) {

        if( this.comboBoxPattern.getSelectionModel().isEmpty() ){

            return;

        }

        Image img = null;
        try {

            img = new Image(new File("src/sample/img/" +
                    this.comboBoxPattern.getSelectionModel().getSelectedIndex() + ".png").toURI().toURL().toString() );

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        ImageView imageView = new ImageView( img );

        AnchorPane secondaryLayout = new AnchorPane();
        secondaryLayout.getChildren().add(imageView);

        Scene secondScene = new Scene(secondaryLayout, img.getWidth(), img.getHeight());

        // New window (Stage)
        Stage newWindow = new Stage();
        newWindow.setResizable( false );
        newWindow.setTitle("Show image");
        newWindow.setScene(secondScene);

        newWindow.initModality(Modality.WINDOW_MODAL);
        // Specifies the owner Window (parent) for new window
        newWindow.initOwner(primaryStage);

        // Set position of second window, related to primary window.
        newWindow.setX(primaryStage.getX() + 200);
        newWindow.setY(primaryStage.getY() + 100);

        newWindow.show();
    }

    public void saveText(ActionEvent actionEvent) {

        this.fileChooser.setInitialFileName((String)this.comboBoxPattern.getSelectionModel().getSelectedItem() +
                (String)this.comboBoxLanguages.getSelectionModel().getSelectedItem());

        this.fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("TXT", "*.txt"));

        File file = this.fileChooser.showSaveDialog( primaryStage );

        if (file != null) {
            System.out.println(file.toString());

            try(FileWriter writer = new FileWriter(file, false))
            {

                writer.write( this.stockText );
                writer.flush();

            } catch(IOException ex){

                System.out.println(ex.getMessage());
            }
        }

    }

    public void comboBoxChange(ActionEvent actionEvent) {

        if ( !this.comboBoxPattern.getSelectionModel().isEmpty() &&
                !this.comboBoxPattern.getSelectionModel().isEmpty() ) {

            this.save.setDisable( false );
            this.showImage.setDisable( false );
            this.generateCode.setDisable( false );

        }

    }
}

