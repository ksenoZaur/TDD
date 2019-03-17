package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

public class Controller {

    public ComboBox comboBoxPattern;

    public static Controller self;
    public TextArea codeViewer;

    public Controller(){

        self = this;

        Test test = new Test();

        try {

            test.testMethodgetPatterns2();
            test.testMethodGetLang2();
            test.testMethodGenerate();

        } catch ( Exception ex ){

            ex.printStackTrace();

        }

    }

    @FXML
    public void initialize() {
        ObservableList<String> langs = FXCollections.observableArrayList("Адаптер",
                "Декоратор", "Заместитель");
        comboBoxPattern.setItems(langs);
    }

    public void setText(String code) {

    }

    public String getTextFromTextArea() {
        return null;
    }
}
