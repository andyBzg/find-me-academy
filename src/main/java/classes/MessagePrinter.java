package classes;

public class MessagePrinter {

    public void printInitialMessage() {
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

}
