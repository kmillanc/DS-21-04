package e1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilitiesTest {

    @Test
    void isValidMix() {
        assertTrue(e1.StringUtilities.isValidMix("Bye", "World", "ByeWorld"));
        assertTrue(e1.StringUtilities.isValidMix("Bye", "World", "WorldBye"));
        assertTrue(e1.StringUtilities.isValidMix("Bye", "World", "BWyoerld"));
        assertTrue(e1.StringUtilities.isValidMix("Bye", "World", "ByWorled"));

        assertFalse(e1.StringUtilities.isValidMix("Bye", "World", "eyBdlroW"));
        assertFalse(e1.StringUtilities.isValidMix("Bye", "World", "ByeWorlds"));
        assertFalse(e1.StringUtilities.isValidMix("Bye", "World", "ByeWordl"));
        assertFalse(e1.StringUtilities.isValidMix("Bye", "World", "HelloWorld"));
        assertFalse(e1.StringUtilities.isValidMix("Bye", "World", "ByWorl"));
        assertFalse(e1.StringUtilities.isValidMix("Bye", "World", "BByyeeWWoorrlldd"));
    }

    @Test
    void generateRandomValidMix() {
        assertTrue(e1.StringUtilities.isValidMix("Bye", "World", e1.StringUtilities.generateRandomValidMix("Bye", "World")));
        assertTrue(e1.StringUtilities.isValidMix("Bye", "World", e1.StringUtilities.generateRandomValidMix("Bye", "World")));
        assertTrue(e1.StringUtilities.isValidMix("Bye", "World", e1.StringUtilities.generateRandomValidMix("Bye", "World")));
        assertTrue(e1.StringUtilities.isValidMix("Bye", "World", e1.StringUtilities.generateRandomValidMix("Bye", "World")));
        assertTrue(e1.StringUtilities.isValidMix("Bye", "World", e1.StringUtilities.generateRandomValidMix("Bye", "World")));

        // Given a more or less long String, the result should be normally not equal
        assertNotEquals(e1.StringUtilities.generateRandomValidMix("Bye", "World"), e1.StringUtilities.generateRandomValidMix("Bye", "World"));
    }
}