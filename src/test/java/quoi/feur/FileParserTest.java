package quoi.feur;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class FileParserTest {
    private static FileParser fileParser;

    @BeforeEach
    void setUp() {
        fileParser = new FileParser(new File("dico.txt"));
    }

    @Test
    void testInstantiate() {
        assertNotNull(fileParser);
    }

    @Test
    void testParseCount() {
        Map<String, List<String>> translations = fileParser.parse();
        assert translations.size() == 5;
    }

    @Test
    void testParseMultipleWordTranslation() {
        Map<String, List<String>> translations = fileParser.parse();
        assert translations.get("bonjour").size() == 2;
    }
}
