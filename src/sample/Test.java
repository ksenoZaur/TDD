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

    public void testMethodgetPatterns2(){

        Generator object = new Generator();

        Map<Integer, String> patterns = object.getPatterns();

        patterns.get(0).equals("Adapter");

    }

}
