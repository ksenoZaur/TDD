package sample;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class Test {

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

    public void testCreateObject(){

        Generator object = new Generator();

    }

    public void testMethodgetPatterns(){

        Generator object = new Generator();

        Map<Integer, String> patterns = object.getPatterns();

    }

    public void testMethodgetPatterns2() throws Exception{

        Generator object = new Generator();

        Map<Integer, String> patterns = object.getPatterns();

        if( !patterns.get(0).equals("Adapter") ){

            throw new Exception("Ошибка!");
        }

    }

    public void testMethodGetLang(){

        Generator object = new Generator();

        Map<Integer, String> languages = object.getLanguages();

    }

    public void testMethodGetLang2() throws Exception{

        Generator object = new Generator();

        Map<Integer, String> languages = object.getLanguages();

        if( !languages.get(0).equals("Java") ){

            throw new Exception("Ошибка!");
        }

    }

    public void testMethodGenerate() throws Exception{

        Generator object = new Generator();

        object.generate(0, 0);

        String code = object.generate(0,0);

        String expected = this.readFromFile("src/sample/input/00.txt").trim();

        if( !code.equals( expected ) ){
            throw new Exception("Ошибка!");
        }

    }

    public void testControllerFieldSelf(){

        Controller.self;

    }

}
