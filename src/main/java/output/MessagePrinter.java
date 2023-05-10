package output;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class MessagePrinter {

    public void printBirthdateRequestMessage() {
        System.out.println("Please enter your date of birth");
    }

    public void printErrorIfBirthdateInFuture() {
        System.out.println("Date of birth cannot be in the future");
    }

    public void printInputRequest(String string) {
        System.out.print(string);
    }

    public void printInputErrorMessage(String input) {
        System.err.printf("Fail. You entered '%s' \nPlease enter correct data: ", input);
    }

    public void printWithCount(List<?> list) {
        AtomicInteger count = new AtomicInteger(0);
        list.forEach(e -> System.out.printf("%s. %s\n", count.incrementAndGet(), e));
    }

    public void printCommands(String command) {
        System.out.printf("You have stop-word! \nType '%s' to exit.\n\n", command);
    }

    public void printListIfNotEmpty(List<?> list) {
        if (list.size() >= 1) {
            printWithCount(list);
            System.out.println();
        } else {
            System.out.println("There is no school you could go to at your age.");
        }
    }
}