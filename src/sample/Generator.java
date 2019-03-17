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
        return "\uFEFFpublic interface Class1{public Object method1();}public class Class2{public Object method1(){return new Object();}}public class Class3 implements Class1{private Class2 object1 = new Class2();@Overridepublic Object method1() {return object1.method1();}}public class Main{public static void main (String [] args){Class1 object1 = new Class3();Object object2 = object1.method1();}}";
    }

}
