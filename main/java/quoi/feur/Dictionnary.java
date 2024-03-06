package quoi.feur;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Dictionnary {
    private final String name;
    private final Map<String, String> words = new HashMap<>();

    public String getTranslation(String fr) {
        return words.get(fr);
    }

    public void addTranslation(String fr, String en) {
        words.put(fr, en);
    }
}
