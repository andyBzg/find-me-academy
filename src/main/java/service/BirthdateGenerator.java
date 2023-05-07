package service;

import input.BirthdateReader;
import lombok.extern.log4j.Log4j2;
import utility.DateUtils;
import output.MessagePrinter;

import java.time.DateTimeException;
import java.time.LocalDate;

@Log4j2
public class BirthdateGenerator {

    private final BirthdateReader birthdateReader;
    private final MessagePrinter message;
    private static final String PLACEHOLDER = "%s-%s-%s";


    public BirthdateGenerator() {
        birthdateReader = new BirthdateReader();
        message = new MessagePrinter();
    }


    public LocalDate createBirthdate() {
        message.printBirthdateRequestMessage();
        String day = birthdateReader.readDay();
        String month = birthdateReader.readMonth();
        String year = birthdateReader.readYear();
        try {
            String date = String.format(PLACEHOLDER, year, month, day);
            LocalDate dateOfBirth = LocalDate.parse(date);

            if (DateUtils.isDateOfBirthInFuture(dateOfBirth)) {
                message.printErrorIfBirthdateInFuture();
                createBirthdate();
            }
            return dateOfBirth;
        } catch (DateTimeException e) {
            log.error(e);
            throw new RuntimeException(e);
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BirthdateGenerator that = (BirthdateGenerator) o;

        if (!birthdateReader.equals(that.birthdateReader)) return false;
        return message.equals(that.message);
    }

    @Override
    public int hashCode() {
        int result = birthdateReader.hashCode();
        result = 31 * result + message.hashCode();
        return result;
    }
}
