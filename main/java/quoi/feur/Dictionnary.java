package quoi.feur;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Dictionnary {
    private final String name;
    private final List<String> words = new ArrayList<>();
}
