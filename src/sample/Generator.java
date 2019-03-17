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
        //TODO Генерировать код
        return "";
    }

}
