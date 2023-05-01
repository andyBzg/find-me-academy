package classes;

import enums.Command;
import enums.PartOfDate;

import java.util.Scanner;

public class BirthdateReader {

    private final Scanner scanner;
    private final MessagePrinter message;


    public BirthdateReader() {
        scanner = new Scanner(System.in);
        message = new MessagePrinter();
    }


    public String readDay() {
        message.printInputRequest(PartOfDate.DAY.toString());
        String day = scanner.nextLine();
        listenForCommand(day);
        while (!checkDay(day)) {
            message.printInputErrorMessage(day);
            day = scanner.nextLine();
            listenForCommand(day);
        }
        return DateUtils.addZeroIfNumberIsOnlyOneDigit(day);
    }

    public String readMonth() {
        message.printInputRequest(PartOfDate.MONTH.toString());
        String month = scanner.nextLine();
        listenForCommand(month);
        while (!checkMonth(month)) {
            message.printInputErrorMessage(month);
            month = scanner.nextLine();
            listenForCommand(month);
        }
        return DateUtils.addZeroIfNumberIsOnlyOneDigit(month);
    }

    public String readYear() {
        message.printInputRequest(PartOfDate.YEAR.toString());
        String year = scanner.nextLine();
        listenForCommand(year);
        while (!checkYear(year)) {
            message.printInputErrorMessage(year);
            year = scanner.nextLine();
            listenForCommand(year);
        }
        return year;
    }

    private boolean checkDay(String day) {
        return DateUtils.isNumeric(day) && DateUtils.isDay(Integer.parseInt(day));
    }

    private boolean checkMonth(String month) {
        return DateUtils.isNumeric(month) && DateUtils.isMonth(Integer.parseInt(month));
    }

    private boolean checkYear(String year) {
        return DateUtils.isNumeric(year) &&
                DateUtils.isFourDigit(year) &&
                DateUtils.isCurrentYear(Integer.parseInt(year)) &&
                DateUtils.isOverHundredYearsOld(Integer.parseInt(year));
    }

    public void listenForCommand(String input) {
        if (input.matches(Command.STOP.getCmd())) {
            ApplicationStopper.stop();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BirthdateReader that = (BirthdateReader) o;

        if (!scanner.equals(that.scanner)) return false;
        return message.equals(that.message);
    }

    @Override
    public int hashCode() {
        int result = scanner.hashCode();
        result = 31 * result + message.hashCode();
        return result;
    }
}

