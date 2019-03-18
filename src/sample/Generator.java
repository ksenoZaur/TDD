package sample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Generator {

    public ArrayList<String> getPatterns() {
        //TODO Добавить поддержку других паттернов
        return  new ArrayList<>() {{ add("Adapter"); }};
    }

    public ArrayList<String> getLanguages() {
        //TODO Добавить поддержку других языков
        return  new ArrayList<>() {{ add("Java"); add("C#"); add("JavaScript");}};
    }

    public String generate(int pattern, int language) {
        //TODO Генерировать код для других паттернов и языков
        switch ( language ) {
            case 0: return "public interface Chief {public Object makeBreakfast();public Object makeDinner();public Object makeSupper();}public class Plumber {public Object getPipe(){return new Object();}public Object getKey(){return new Object();}public Object getScrewDriver(){return new Object();}}public class ChiefAdapter implements Chief{private Plumber plumber = new Plumber();@Overridepublic Object makeBreakfast() {return plumber.getKey();}@Overridepublic Object makeDinner() {return plumber.getScrewDriver();}@Overridepublic Object makeSupper() {return plumber.getPipe();}}public class Client {public static void main (String [] args){Chief chief = new ChiefAdapter();Object key = chief.makeDinner();}}";
            case 1: return "\uFEFFusing System;  namespace Adapter {    class MainApp  {    static void Main()    {      Target target = new Adapter();      target.Request();      Console.Read();    }  }   class Target  {    public virtual void Request()    {      Console.WriteLine(\"Called Target Request()\");    }  }   class Adapter : Target  {    private Adaptee adaptee = new Adaptee();     public override void Request()    {      adaptee.SpecificRequest();    }  }   class Adaptee  {    public void SpecificRequest()    {      Console.WriteLine(\"Called SpecificRequest()\");    }  } }";
            default: return "\uFEFFfunction Search (text, word) {var text = text;var word = word;this.searchWordInText = function () {return text;};this.getWord = function () {return word;};};function SearchAdapter (adaptee) {this.searchWordInText = function () {return 'Эти слова ' + adaptee.getWord();+ ' найдены в тексте ' + adaptee.searchWordInText();};};var search = new Search(\"текст\", \"слова\");var searchAdapter = new SearchAdapter(search);searchAdapter.searchWordInText();";
        }
    }

}
