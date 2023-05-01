import classes.*;

import lombok.extern.log4j.Log4j2;

import java.time.LocalDate;
import java.util.List;

@Log4j2
public class Main {
    public static void main(String[] args) {

        String file = "src/main/resources/Universities.txt";
        FileService fileService = new FileService(file);
        List<String> stringsList = fileService.addStringsFromFileToList();

        Institution institution = new Institution();
        List<Institution> institutionList = institution.convertStringsToObjects(stringsList);

        BirthdateGenerator birthdateGenerator = new BirthdateGenerator();
        LocalDate birthDate = birthdateGenerator.generate();

        User user = new User(birthDate);

        List<Institution> suitableList = institution.getSuitableInstitutionByUserAge(institutionList, user.getAge());

        MessagePrinter message = new MessagePrinter();

        message.printWithCount(suitableList);
    }
}
