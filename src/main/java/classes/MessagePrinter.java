package classes;

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
        //TODO сделать универсальный метод который выводит соответсвующий текст в зависисмости от переданных данных
    }

    /**
     * Выводит в консоль список (объектов)организаций с нумерацией
     **/
    public void printWithCount(List<?> list) {
        AtomicInteger count = new AtomicInteger(0);
        list.forEach(e -> System.out.printf("%s. %s\n", count.incrementAndGet(), e));
    }

    public void printGreetings() {
        System.out.println("Написать приветсвенный тест");
    }
}
