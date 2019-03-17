package sample;

import java.util.HashMap;
import java.util.Map;

public class Generator {
    public Map<Integer, String> getPatterns() {
        //TODO Добавить поддержку дрягих паттернов
        return  Map.of(0, "Adapter");
    }

    public Map<Integer, String> getLanguages() {
        //TODO Добавить поддержку других языков
        return  Map.of(0, "Java");
    }

    public void generate(int pattern, int language) {
        //TODO Генерировать код
    }
}
