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
    void testAddTranslationSimple() {
        dictionnary.addTranslation("bonjour", "hello");
        assert dictionnary.getWords().size() == 1;
    }

    @Test
    void testAddTranslationMultiple() {
        dictionnary.addTranslation("bonjour", "hello");
        dictionnary.addTranslation("bonjour", "hi");
        assert dictionnary.getWords().size() == 1;
        assert dictionnary.getWords().get("bonjour").size() == 2;
    }

    @Test
    void testGetOneTranslation() {
        dictionnary.addTranslation("bonjour", "hello");
        assertEquals("hello", dictionnary.getOneTranslation("bonjour"));
    }

    @Test
    void testGetAllTranslations() {
        dictionnary.addTranslation("bonjour", "hello");
        dictionnary.addTranslation("bonjour", "hi");
        assertEquals(2, dictionnary.getAllTranslations("bonjour").size());
    }
}