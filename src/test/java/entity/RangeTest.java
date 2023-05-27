package entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RangeTest {

    Range range;
    String ageRange;

    @BeforeEach
    void init() {
        ageRange = "21-45";
        range = new Range(ageRange);
    }

    @Test
    void parseString_stringContainsOnlyOneNumber_throwsException() {
        String string = "12-notNumber";

        assertThrows(NumberFormatException.class, () -> range.parseString(string));
    }

    @Test
    void parseString_emptyString_throwsException() {
        assertThrows(NumberFormatException.class, () -> range.parseString(""));
    }

    @Test
    void parseString_withNull_throwsException() {
        assertThrows(NullPointerException.class, () -> range.parseString(null));
    }

    @Test
    void isAgeInRange_positive() {
        assertTrue(range.isAgeInRange(25));
    }

    @Test
    void isAgeInRange_negative() {
        assertFalse(range.isAgeInRange(50));
    }

    @Test
    void isAgeInRange_border() {
        assertTrue(range.isAgeInRange(21));
        assertTrue(range.isAgeInRange(45));
        assertFalse(range.isAgeInRange(20));
        assertFalse(range.isAgeInRange(46));
    }
}