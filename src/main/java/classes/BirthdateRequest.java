package classes;

import enums.PartOfDate;
import lombok.extern.log4j.Log4j2;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

@Log4j2
public class BirthdateRequest {

    private final Scanner scanner;
    private final MessagePrinter message;


    public BirthdateRequest() {
        scanner = new Scanner(System.in);
        message = new MessagePrinter();
    }


    public LocalDate getUserBirthdate() {
        message.printBirthdateRequestMessage();

        try {
            String day = getDay();
            String month = getMonth();
            String year = getYear();

            String date = String.format("%s-%s-%s", year, month, day);
            LocalDate dateOfBirth = LocalDate.parse(date);

            if (isDateOfBirthInFuture(dateOfBirth)) {
                message.printErrorIfBirthdateInFuture();
                return getUserBirthdate();
            }
            else {
                return dateOfBirth;
            }
        }
        catch (InputMismatchException e) {
            log.error("getUserBirthdate: " + e.getMessage());
            throw new NoSuchElementException(e);
        }
    }

    private String getDay() {
        message.printInputRequest(PartOfDate.DAY.toString());
        String day = scanner.nextLine();
        while (!isNumeric(day) || !isDay(Integer.parseInt(day))) {
            message.printInputErrorMessage(day);
            day = scanner.nextLine();
        }
        day = addZeroIfNumberIsOnlyOneDigit(day);
        return day;
    }

    private String getMonth() {
        message.printInputRequest(PartOfDate.MONTH.toString());
        String month = scanner.nextLine();
        while (!isNumeric(month) || !isMonth(Integer.parseInt(month))) {
            message.printInputErrorMessage(month);
            month = scanner.nextLine();
        }
        month = addZeroIfNumberIsOnlyOneDigit(month);
        return month;
    }

    private String getYear() {
        message.printInputRequest(PartOfDate.YEAR.toString());
        String year = scanner.nextLine();
        while (!isNumeric(year) || !isOverHundredYearsOld(Integer.parseInt(year))) {
            message.printInputErrorMessage(year);
            year = scanner.nextLine();
        }
        return year;
    }

    private boolean isDateOfBirthInFuture(LocalDate date) {
        LocalDate localDateNow = LocalDate.now();
        return date.isAfter(localDateNow);
    }

    private boolean isNumeric(String str) {
        return (str != null) && (str.matches("[0-9.]+"));
    }

    private boolean isDay(int dayOfMonth) {
        return dayOfMonth <= 31 && dayOfMonth > 0;
    }

    private boolean isMonth(int month) {
        return month <= 12 && month > 0;
    }

    private boolean isOverHundredYearsOld(int year) {
        return year > LocalDate.now().getYear() - 100;
    }

    private String addZeroIfNumberIsOnlyOneDigit(String number) {
        if (number.length() == 1) {
            return "0" + number;
        }
        else {
            return number;
        }
    }
}

