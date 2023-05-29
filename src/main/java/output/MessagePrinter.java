package output;

import lombok.extern.log4j.Log4j2;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Log4j2
public class MessagePrinter {

    public void printBirthdateRequestMessage() {
        log.info("Please enter your date of birth\n");
    }

    public void printErrorIfBirthdateInFuture() {
        log.info("Date of birth cannot be in the future\n");
    }

    public void printInputRequest(String string) {
        log.info(string);
    }

    public void printInputErrorMessage(String input) {
        log.info("Fail. You entered '{}' \nPlease enter correct data: ", input);
    }

    public void printWithCount(List<?> list) {
        AtomicInteger count = new AtomicInteger(0);
        list.forEach(e -> log.info("{}. {}\n", count.incrementAndGet(), e));
    }

    public void printCommands(String command) {
        log.info("You have stop-word! \nType '{}' to exit.\n\n", command);
    }

    public void printListIfNotEmpty(List<?> list) {
        if (!list.isEmpty()) {
            printWithCount(list);
            log.info("\n");
        } else {
            log.info("There is no school you could go to at your age.");
        }
    }
}
