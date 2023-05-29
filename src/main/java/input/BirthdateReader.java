package input;

import enums.PartOfDate;
import lombok.Data;
import service.ConsoleCommandHandler;
import utility.DateUtils;
import output.MessagePrinter;

import java.util.Scanner;

@Data
public class BirthdateReader {

    private final Scanner scanner;
    private final MessagePrinter message;
    private final ConsoleCommandHandler commandHandler;


    public BirthdateReader() {
        scanner = new Scanner(System.in);
        message = new MessagePrinter();
        commandHandler = new ConsoleCommandHandler();
    }


    public String readDay() {
        message.printInputRequest(PartOfDate.DAY.getText());
        String day = scanner.nextLine();
        commandHandler.listenForStopCommand(day);
        while (!validateDay(day)) {
            message.printInputErrorMessage(day);
            day = scanner.nextLine();
            commandHandler.listenForStopCommand(day);
        }
        return DateUtils.addZeroIfNumberIsOnlyOneDigit(day);
    }

    public String readMonth() {
        message.printInputRequest(PartOfDate.MONTH.getText());
        String month = scanner.nextLine();
        commandHandler.listenForStopCommand(month);
        while (!validateMonth(month)) {
            message.printInputErrorMessage(month);
            month = scanner.nextLine();
            commandHandler.listenForStopCommand(month);
        }
        return DateUtils.addZeroIfNumberIsOnlyOneDigit(month);
    }

    public String readYear() {
        message.printInputRequest(PartOfDate.YEAR.getText());
        String year = scanner.nextLine();
        commandHandler.listenForStopCommand(year);
        while (!validateYear(year)) {
            message.printInputErrorMessage(year);
            year = scanner.nextLine();
            commandHandler.listenForStopCommand(year);
        }
        return year;
    }

    private boolean validateDay(String day) {
        return DateUtils.isNumeric(day) && DateUtils.isDay(Integer.parseInt(day));
    }

    private boolean validateMonth(String month) {
        return DateUtils.isNumeric(month) && DateUtils.isMonth(Integer.parseInt(month));
    }

    private boolean validateYear(String year) {
        return DateUtils.isNumeric(year) &&
                DateUtils.isFourDigit(year) &&
                DateUtils.isCurrentYear(Integer.parseInt(year)) &&
                !DateUtils.isOverHundredYearsOld(Integer.parseInt(year));
    }
}

