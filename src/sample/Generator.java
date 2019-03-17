package sample;

import java.util.HashMap;
import java.util.Map;

public class Generator {

    public Map<Integer, String> getPatterns() {
        //TODO Добавить поддержку других паттернов
        return  Map.of(0, "Adapter");
    }

    public Map<Integer, String> getLanguages() {
        //TODO Добавить поддержку других языков
        return  Map.of(0, "Java");
    }

    public String generate(int pattern, int language) {
        //TODO Генерировать код для других паттернов и языков
        return "\uFEFF// Файл Chief.javapublic interface Chief {public Object makeBreakfast();public Object makeDinner();public Object makeSupper();}// Файл Plumber.javapublic class Plumber {public Object getPipe(){return new Object();}public Object getKey(){return new Object();}public Object getScrewDriver(){return new Object();}}// Файл ChiefAdapter.javapublic class ChiefAdapter implements Chief{private Plumber plumber = new Plumber();@Overridepublic Object makeBreakfast() {return plumber.getKey();}@Overridepublic Object makeDinner() {return plumber.getScrewDriver();}@Overridepublic Object makeSupper() {return plumber.getPipe();}}// Файл Client.javapublic class Client {public static void main (String [] args){Chief chief = new ChiefAdapter();Object key = chief.makeDinner();}}";
    }

}
