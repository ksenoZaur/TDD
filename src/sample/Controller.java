package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

public class Controller {

    public ComboBox comboBoxPattern;

    public static Controller self;

    public TextArea codeViewer;

    public Button generateCode;

    Generator generator;

    public Controller(){

        self = this;
        this.generator = new Generator();

    }

    @FXML
    public void initialize() {

        Test test = new Test();

        try {

            test.testMethodgetPatterns2();
            test.testMethodGetLang2();
            test.testMethodGenerate();
            test.testControllerFieldSelf();
            test.testController();

        } catch ( Exception ex ){

            ex.printStackTrace();

        }

        ObservableList<String> langs = FXCollections.observableArrayList("Адаптер",
                "Декоратор", "Заместитель");
        comboBoxPattern.setItems(langs);

    }

    public void setText(String code) {

        this.codeViewer.setText( code );

    }

    public String getTextFromTextArea() {
        return this.codeViewer.getText();
    }

    public Button getGenerateCode() {
        return generateCode;
    }
}
