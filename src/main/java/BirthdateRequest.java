import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class BirthdateRequest {

    private String day;
    private String month;
    private String year;


    public LocalDate getUserBirthdate() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter your date of birth ");
        try {
            System.out.print("Day: "); // не больше 31
            day = scanner.nextLine();
            while (!isNumeric(day) || !isDay(Integer.parseInt(day))) {
                //todo сделать универсальный метод который выводит соответсвующий текст в зависисмости от переданных данных
                System.out.printf("You entered %s. Wrong day of the month entered. \nPlease enter correct day: ", day);
                day = scanner.nextLine();
            }

            System.out.print("Month: "); // не больше 12
            month = scanner.nextLine();
            while (!isNumeric(month) || !isMonth(Integer.parseInt(month))) {
                System.out.printf("You entered %s. Wrong month entered \nPlease enter correct month: ", month);
                month = scanner.nextLine();
            }

            System.out.print("Year: "); // не больше текущего года и не старше 100 лет
            year = scanner.nextLine();
            while (!isNumeric(year) || !isYearOfBirth(Integer.parseInt(year))) {
                System.out.printf("You entered %s. Wrong year entered. \nPlease enter correct year: ", year);
                year = scanner.nextLine();
            }

            return LocalDate.parse(String.format("%s-%s-%s", year, month, day));

        } catch (InputMismatchException e) {
            throw new NoSuchElementException(e);
        }

    }

    private static boolean isNumeric(String str) {
        return str != null && str.matches("[0-9.]+");
    }

    private static boolean isDay(int dayOfMonth) {
        return dayOfMonth <= 31 && dayOfMonth > 0;
    }

    private static boolean isMonth(int month) {
        return month <= 12 && month > 0;
    }

    private static boolean isYearOfBirth(int year) {
        return year <= LocalDate.now().getYear() && year > LocalDate.now().getYear() - 100;
    }
}

