package quoi.feur;

import lombok.Getter;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class Dictionnary {
    private final String name;
    private final Map<String, List<String>> words = new HashMap<>();

    public Dictionnary(String name) {
        this.name = name;
    }

    public Dictionnary(File file) {
        FileParser fileParser = new FileParser(file);
        name = fileParser.getName();
        Map<String, List<String>> translations = fileParser.parse();
        translations.forEach((k, v) -> v.forEach(t -> addTranslation(k, t)));
    }

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
