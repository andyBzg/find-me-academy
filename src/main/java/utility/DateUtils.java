package utility;

import java.time.LocalDate;

public class DateUtils {

    private static final int AGE_LOWER_LIMIT = 100;
    private static final String REGEX_FOR_NUMBERS = "[0-9.]+";

    private DateUtils() {

    }

    public static boolean isDateOfBirthInFuture(LocalDate date) {
        LocalDate localDateNow = LocalDate.now();
        return date.isAfter(localDateNow);
    }

    public static boolean isNumeric(String str) {
        return (str != null) && (str.matches(REGEX_FOR_NUMBERS));
    }

    public static boolean isDay(int dayOfMonth) {
        return dayOfMonth <= 31 && dayOfMonth > 0;
    }

    public static boolean isMonth(int month) {
        return month <= 12 && month > 0;
    }

    public static boolean isFourDigit(String year) {
        return year.length() == 4;
    }

    public static boolean isCurrentYear(int year) {
        return year <= LocalDate.now().getYear();
    }

    public static boolean isOverHundredYearsOld(int year) {
        return year <= LocalDate.now().getYear() - AGE_LOWER_LIMIT;
    }

    public static String addZeroIfNumberIsOnlyOneDigit(String number) {
        return number.length() == 1 ? "0" + number : number;
    }
}
