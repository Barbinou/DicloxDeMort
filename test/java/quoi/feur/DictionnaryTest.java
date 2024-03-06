package quoi.feur;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class DictionnaryTest {
    private static Dictionnary dictionnary;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        dictionnary = new Dictionnary();
    }

    @Test
    void testInstantiate() {
        assertNotNull(dictionnary);
    }
}