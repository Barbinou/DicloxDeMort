package quoi.feur;

import lombok.SneakyThrows;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FileParserTestMockito {
    @Mock
    private BufferedReader bufferedReader;
    private static FileParser fileParser;
    private final File emptyFile = new File("emptyFile.txt");

    @BeforeEach
    @SneakyThrows
    @SuppressWarnings("ResultOfMethodCallIgnored")
    void setUp() {
        emptyFile.createNewFile();
        bufferedReader = new BufferedReader(new FileReader(emptyFile));
        bufferedReader = mock(BufferedReader.class);
        when(bufferedReader.readLine()).thenReturn(
                "Dico de zinzin",
                "bonjour;hello;hi",
                "limoges;limoges",
                "est;is",
                "en;in",
                "colombie;colombia",
                null
        );
        fileParser = new FileParser(bufferedReader);
    }

    @AfterEach
    void cleanUp() {
        if (emptyFile.exists())
            //noinspection ResultOfMethodCallIgnored
            emptyFile.delete();
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
