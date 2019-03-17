package sample;

import javafx.event.ActionEvent;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
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
    public String testMethodGenerate() throws Exception{

        Generator object = new Generator();

        object.generate(0, 0);

        String code = object.generate(0,0);

        String expected = this.readFromFile("src/sample/input/00.txt").trim();

        if( !code.equals( expected ) ){
            throw new Exception("Ошибка!");
        }

        return code;

    }

    @Test
    public void testControllerFieldSelf() throws Exception{

        String code = this.testMethodGenerate();

        Controller.self.setText( code );

        String result = Controller.self.getTextFromTextArea();

        if( !result.equals( code ) ){
            throw new Exception("Ошибка!");
        }

    }

    @Test
    public void testController(){

        Controller.self.getGenerateCode().getOnAction().handle( new ActionEvent() );
        Controller.self.getComboBoxPattern().getSelectionModel().select("Adapter");
    }

    @Test
    public void testController2(){

        Controller.self.getComboBoxPattern().getSelectionModel().select("Adapter");
        Controller.self.getGenerateCode().getOnAction().handle( new ActionEvent() );
        String expected = this.readFromFile("src/sample/input/00.txt").trim();
        String actual = Controller.self.getTextFromTextArea();
        Assertions.assertEquals(expected, actual);

    }

}
