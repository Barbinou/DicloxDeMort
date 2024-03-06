package quoi.feur;

import lombok.Data;

import java.util.*;

@Data
public class Dictionnary {
    private final String name;
    private final Map<String, List<String>> words = new HashMap<>();

    public String getOneTranslation(String fr) {
        return words.get(fr).get(0);
    }

    public List<String> getAllTranslations(String fr) {
        return words.get(fr);
    }

    public void addTranslation(String fr, String en) {
        if (words.containsKey(fr)) {
            words.get(fr).add(en);
        }
        else {
            List<String> translations = new ArrayList<>();
            translations.add(en);
            words.put(fr, translations);
        }
    }
}
