package utility;

import org.junit.jupiter.api.Test;
import utility.DateUtils;


import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class DateUtilsTest {

    @Test
    void isDateOfBirthInFuture_positive() {
        LocalDate futureDate = LocalDate.of(3000, 1, 1);
        assertTrue(DateUtils.isDateOfBirthInFuture(futureDate));
    }

    @Test
    void isDateOfBirthInFuture_negative() {
        LocalDate pastDate = LocalDate.EPOCH;
        assertFalse(DateUtils.isDateOfBirthInFuture(pastDate));
    }

    @Test
    void isDateOfBirthInFuture_border() {
        LocalDate now = LocalDate.now();
        LocalDate yesterday = LocalDate.now().minusDays(1);
        LocalDate tomorrow = LocalDate.now().plusDays(1);
        assertFalse(DateUtils.isDateOfBirthInFuture(now));
        assertFalse(DateUtils.isDateOfBirthInFuture(yesterday));
        assertTrue(DateUtils.isDateOfBirthInFuture(tomorrow));
    }

    @Test
    void isNumeric_positive() {
        String str = "12345";
        assertTrue(DateUtils.isNumeric(str));
    }

    @Test
    void isNumeric_negative() {
        String str = "12a45";
        assertFalse(DateUtils.isNumeric(str));
    }

    @Test
    void isNumeric_border() {
        String str = "0.5";
        assertTrue(DateUtils.isNumeric(str));
    }

    @Test
    void isDay_positive() {
        assertTrue(DateUtils.isDay(3));
        assertTrue(DateUtils.isDay(15));
    }

    @Test
    void isDay_negative() {
        assertFalse(DateUtils.isDay(-5));
        assertFalse(DateUtils.isDay(100));
    }

    @Test
    void isDay_border() {
        assertTrue(DateUtils.isDay(31));
        assertTrue(DateUtils.isDay(1));
        assertFalse(DateUtils.isDay(0));
        assertFalse(DateUtils.isDay(-1));
        assertFalse(DateUtils.isDay(32));
    }

    @Test
    void isDay_stringInsteadOfNumber_throwsException() {
        assertThrows(NumberFormatException.class, () -> DateUtils.isDay(Integer.parseInt("str")));
    }

    @Test
    void isMonth_positive() {
        assertTrue(DateUtils.isMonth(3));
        assertTrue(DateUtils.isMonth(10));
    }

    @Test
    void isMonth_negative() {
        assertFalse(DateUtils.isMonth(-5));
        assertFalse(DateUtils.isMonth(100));
    }

    @Test
    void isMonth_border() {
        assertTrue(DateUtils.isMonth(12));
        assertTrue(DateUtils.isMonth(1));
        assertFalse(DateUtils.isMonth(0));
        assertFalse(DateUtils.isMonth(-1));
        assertFalse(DateUtils.isMonth(13));
    }

    @Test
    void isMonth_stringInsteadOfNumber_throwsException() {
        assertThrows(NumberFormatException.class, () -> DateUtils.isMonth(Integer.parseInt("str")));
    }

    @Test
    public void isFourDigit_positive() {
        assertTrue(DateUtils.isFourDigit("2022"));
    }

    @Test
    public void isFourDigit_negative() {
        assertFalse(DateUtils.isFourDigit("123"));
    }

    @Test
    public void isFourDigit_border() {
        assertFalse(DateUtils.isFourDigit("200"));
        assertFalse(DateUtils.isFourDigit("20005"));
        assertTrue(DateUtils.isFourDigit("2000"));
    }

    @Test
    void isCurrentYear_positive() {
        int currentYear = LocalDate.now().getYear();
        assertTrue(DateUtils.isCurrentYear(currentYear));
    }

    @Test
    void isCurrentYear_negative() {
        int futureYear = LocalDate.now().getYear() + 1;
        assertFalse(DateUtils.isCurrentYear(futureYear));
    }

    @Test
    void isCurrentYear_border() {
        int borderYear = 1999;
        assertTrue(DateUtils.isCurrentYear(borderYear));
    }

    @Test
    void isCurrentYear_stringInsteadOfNumber_throwsException() {
        assertThrows(NumberFormatException.class, () -> DateUtils.isCurrentYear(Integer.parseInt("str")));
    }

    @Test
    void isOverHundredYearsOld_positive() {
        int year = 1900;
        assertTrue(DateUtils.isOverHundredYearsOld(year));
    }

    @Test
    void isOverHundredYearsOld_negative() {
        int year = 2022;
        assertFalse(DateUtils.isOverHundredYearsOld(year));
    }

    @Test
    void isOverHundredYearsOld_border() {
        int year = LocalDate.now().getYear() - 100;
        assertTrue(DateUtils.isOverHundredYearsOld(year));
    }

    @Test
    public void addZeroIfNumberIsOnlyOneDigit_positive() {
        String result = DateUtils.addZeroIfNumberIsOnlyOneDigit("9");
        assertEquals("09", result);
    }

    @Test
    public void addZeroIfNumberIsOnlyOneDigit_negative() {
        String result = DateUtils.addZeroIfNumberIsOnlyOneDigit("12");
        assertNotEquals("012", result);
    }

    @Test
    public void addZeroIfNumberIsOnlyOneDigit_border() {
        String result = DateUtils.addZeroIfNumberIsOnlyOneDigit("0");
        assertEquals("00", result);
    }

}