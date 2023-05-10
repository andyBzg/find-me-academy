package service;

import input.BirthdateReader;
import lombok.extern.log4j.Log4j2;
import utility.DateUtils;
import output.MessagePrinter;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Objects;

@Log4j2
public class BirthdateGenerator {

    private static final String PLACEHOLDER = "%s-%s-%s";
    private final BirthdateReader birthdateReader;
    private final MessagePrinter message;
    private String day;
    private String month;
    private String year;


    public BirthdateGenerator() {
        birthdateReader = new BirthdateReader();
        message = new MessagePrinter();
    }


    public void initializeBirthdateRequest() {
        message.printBirthdateRequestMessage();
        day = birthdateReader.readDay();
        month = birthdateReader.readMonth();
        year = birthdateReader.readYear();
    }


    public LocalDate createBirthdate() {
        initializeBirthdateRequest();
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
        if (!message.equals(that.message)) return false;
        if (!Objects.equals(day, that.day)) return false;
        if (!Objects.equals(month, that.month)) return false;
        return Objects.equals(year, that.year);
    }

    @Override
    public int hashCode() {
        int result = birthdateReader.hashCode();
        result = 31 * result + message.hashCode();
        result = 31 * result + (day != null ? day.hashCode() : 0);
        result = 31 * result + (month != null ? month.hashCode() : 0);
        result = 31 * result + (year != null ? year.hashCode() : 0);
        return result;
    }
}
