package quoi.feur;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class DictionnaryTest {
    private static Dictionnary dictionnary;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        dictionnary = new Dictionnary("sha256");
    }

    @Test
    void testInstantiate() {
        assertNotNull(dictionnary);
    }

    @Test
    void testGetName() {
        assertEquals("sha256", dictionnary.getName());
    }

    @Test
    void testVerifyEmptyMot() {
        assertTrue(dictionnary.getWords().isEmpty());
    }

    @Test
    void testAddTranslation() {
        dictionnary.addTranslation("bonjour", "hello");
        assert dictionnary.getWords().size() == 1;
    }

    @Test
    void testGetTranslation() {
        dictionnary.addTranslation("bonjour", "hello");
        assertEquals("hello", dictionnary.getTranslation("bonjour"));
    }
}