package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

public class Controller {

    public ComboBox comboBoxPattern;

    public Controller(){

        Test test = new Test();
        test.testMethodgetPatterns2();
        test.testMethodGetLang2();

    }

    @FXML
    public void initialize() {
        ObservableList<String> langs = FXCollections.observableArrayList("Адаптер",
                "Декоратор", "Заместитель");
        comboBoxPattern.setItems(langs);
    }

}
