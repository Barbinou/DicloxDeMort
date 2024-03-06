package quoi.feur;

import lombok.Getter;
import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileParser {
    private final BufferedReader reader;
    @Getter private final String name;

    @SneakyThrows
    public FileParser(File file) {
        this.reader = new BufferedReader(new FileReader(file));
        name = reader.readLine();
    }

    @SneakyThrows
    public FileParser(BufferedReader reader) {
        this.reader = reader;
        name = reader.readLine();
    }

    @SneakyThrows
    public Map<String, List<String>> parse() {
        Map<String, List<String>> translations = new HashMap<>();

        String line;
        while ((line = reader.readLine()) != null) {
            String[] words = line.split(";");
            if (words.length < 2) {
                throw new IllegalArgumentException("Invalid file format");
            }
            String key = words[0];
            for (int i = 1; i < words.length; i++) {
                if (translations.containsKey(key)) {
                    translations.get(key).add(words[i]);
                } else {
                    List<String> list = new ArrayList<>();
                    list.add(words[i]);
                    translations.put(key, list);
                }
            }
        }
        return translations;
    }
}
