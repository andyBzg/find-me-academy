package service;

import input.BirthdateReader;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import utility.DateUtils;
import output.MessagePrinter;

import java.time.DateTimeException;
import java.time.LocalDate;

@Log4j2
@Data
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
            throw new DateTimeException(e.getMessage());
        }
    }
}
