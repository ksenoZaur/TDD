package sample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Generator {

    public ArrayList<String> getPatterns() {
        //TODO Добавить поддержку других паттернов
        return  new ArrayList<String>() {{ add("Adapter"); }};
    }

    public ArrayList<String> getLanguages() {
        //TODO Добавить поддержку других языков
        return  new ArrayList<String>() {{ add("Java"); add("C#"); }};
    }

    public String generate(int pattern, int language) {
        //TODO Генерировать код для других паттернов и языков
        return "\uFEFFpublic interface Chief {public Object makeBreakfast();public Object makeDinner();public Object makeSupper();}public class Plumber {public Object getPipe(){return new Object();}public Object getKey(){return new Object();}public Object getScrewDriver(){return new Object();}}public class ChiefAdapter implements Chief{private Plumber plumber = new Plumber();@Overridepublic Object makeBreakfast() {return plumber.getKey();}@Overridepublic Object makeDinner() {return plumber.getScrewDriver();}@Overridepublic Object makeSupper() {return plumber.getPipe();}}public class Client {public static void main (String [] args){Chief chief = new ChiefAdapter();Object key = chief.makeDinner();}}";
    }

}
