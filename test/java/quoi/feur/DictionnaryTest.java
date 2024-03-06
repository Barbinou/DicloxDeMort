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
        assertEquals(2, dictionnary.getWords().size());
        // Vérifie que deux entrées existent maintenant, une pour chaque langue
        assertTrue(dictionnary.getAllTranslations("bonjour").contains("hello"));
        assertTrue(dictionnary.getAllTranslations("hello").contains("bonjour"));
    }

    @Test
    void testAddTranslationMultiple() {
        dictionnary.addTranslation("bonjour", "hello");
        dictionnary.addTranslation("bonjour", "hi");
        // Après deux traductions, nous attendons trois entrées: "bonjour", "hello" et "hi"
        // "hello" et "hi" pointent vers "bonjour" et vice versa.
        assertEquals(3, dictionnary.getWords().size());
        assertEquals(2, dictionnary.getAllTranslations("bonjour").size());
        assertTrue(dictionnary.getAllTranslations("bonjour").contains("hello"));
        assertTrue(dictionnary.getAllTranslations("bonjour").contains("hi"));
        assertTrue(dictionnary.getAllTranslations("hello").contains("bonjour"));
        assertTrue(dictionnary.getAllTranslations("hi").contains("bonjour"));
    }

    @Test
    void testGetOneTranslation() {
        dictionnary.addTranslation("bonjour", "hello");
        assertNotNull(dictionnary.getOneTranslation("bonjour"));
    }

    @Test
    void testGetAllTranslations() {
        dictionnary.addTranslation("bonjour", "hello");
        dictionnary.addTranslation("bonjour", "hi");
        assertNotNull(dictionnary.getAllTranslations("bonjour"));
        assertEquals(2, dictionnary.getAllTranslations("bonjour").size());
    }

    @Test
    void testBidirectionalTranslation() {
        dictionnary.addTranslation("bonjour", "hello");
        // Vérification de la traduction français vers anglais
        assertTrue(dictionnary.getAllTranslations("bonjour").contains("hello"));
        assertTrue(dictionnary.getAllTranslations("hello").contains("bonjour"));
    }
}