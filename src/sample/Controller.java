package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

import java.util.*;

public class Controller {

    public ComboBox comboBoxPattern;

    public static Controller self;

    public TextArea codeViewer;
    public String stockText;

    public Button generateCode;
    public ComboBox comboBoxLanguages;

    Generator generator;

    public Controller(){

        self = this;
        this.generator = new Generator();

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

        this.stockText = code;
        code = code.replaceAll(";", ";\n");
        code = code.replaceAll("\\{", "\n { \n");
        code = code.replaceAll("\\}", " } \n\n");

        String[] words = code.split(" ");

        for( String word: words ){

            this.codeViewer.appendText(word);

        }

    }

    public String getTextFromTextArea() {
        return this.stockText;
    }

    public Button getGenerateCode() {
        return generateCode;
    }

    public void generateButtonAction(ActionEvent actionEvent) {
        //TODO Добавить функционал в метод

        String code = this.generator.generate(0,0);
        this.setText( code );

    }

    public ComboBox getComboBoxPattern() {
        return comboBoxPattern;
    }


}
