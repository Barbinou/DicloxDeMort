package quoi.feur;

import lombok.Data;

import java.util.*;

@Data
public class Dictionnary {
    private final String name;
    private final Map<String, List<String>> words = new HashMap<>();

    private void addWord(String key, String value) {
        // Si la clé n'existe pas, créez une nouvelle liste
        words.computeIfAbsent(key, k -> new ArrayList<>()).add(value);
    }

    public void addTranslation(String fr, String en) {
        addWord(fr, en);
        addWord(en, fr);
    }

    public List<String> getAllTranslations(String fr) {
        return words.getOrDefault(fr, null);
    }

    public String getOneTranslation(String fr) {
        return words.containsKey(fr) ? words.get(fr).get(0) : null;
    }
}
