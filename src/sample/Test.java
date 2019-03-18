package sample;

import javafx.event.ActionEvent;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

import javafx.stage.Stage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TestGeneratorAndController {

    @Test
    private String readFromFile( String path ){
        String text = null;

        try {

            text = new String(Files.readAllBytes(Paths.get(path)), StandardCharsets.UTF_8);
            text = text.replaceAll("\\n", "");
            text = text.replaceAll("\\r", "");
            text = text.replaceAll("\\t", "");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return text;
    }

    @Test
    public void testCreateObject(){

        Generator object = new Generator();

    }

    @Test
    public void testMethodgetPatterns(){

        Generator object = new Generator();

        Map<Integer, String> patterns = object.getPatterns();

    }

    @Test
    public void testMethodgetPatterns2() throws Exception{

        Generator object = new Generator();

        Map<Integer, String> patterns = object.getPatterns();

        if( !patterns.get(0).equals("Adapter") ){

            throw new Exception("Ошибка!");
        }

    }

    @Test
    public void testMethodGetLang(){

        Generator object = new Generator();

        Map<Integer, String> languages = object.getLanguages();

    }

    @Test
    public void testMethodGetLang2() throws Exception{

        Generator object = new Generator();

        Map<Integer, String> languages = object.getLanguages();

        if( !languages.get(0).equals("Java") ){

            throw new Exception("Ошибка!");
        }

    }

    @Test
    public void testMethodGenerate() {

        Generator object = new Generator();

        object.generate(0, 0);

        String code = object.generate(0,0);

        String expected = this.readFromFile("src/sample/input/00.txt").trim();

        Assertions.assertEquals(expected, code);

    }

    @Test
    public void testControllerFieldSelf() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                Main.main(null);
            }
        }).start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Generator generator = new Generator();

        String code = generator.generate(0, 0);

        Controller.self.setText( code );

        String result = Controller.self.getTextFromTextArea();

        Assertions.assertEquals(code, result);

    }

    @Test
    public void testController(){

        Controller.self.getGenerateCode().getOnAction().handle( new ActionEvent() );
        Controller.self.getComboBoxPattern().getSelectionModel().select("Adapter");

    }

    @Test
    public void testController2(){

        new Thread(new Runnable() {
            @Override
            public void run() {
                Main.main(null);
            }
        }).start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Controller.self.getComboBoxPattern().getSelectionModel().select("Adapter");
        Controller.self.getGenerateCode().getOnAction().handle( new ActionEvent() );
        String expected = this.readFromFile("src/sample/input/00.txt").trim();
        String actual = Controller.self.getTextFromTextArea();
        Assertions.assertEquals(expected, actual);

    }

}
