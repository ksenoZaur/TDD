package sample;

import java.util.Map;

public class Test {

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

    public void testMethodGenerate() {

        Generator object = new Generator();

        object.generate(0, 0);

        String code = object.generate(0,0);

    }

}
