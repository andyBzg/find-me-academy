package classes;

import enums.Command;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class App {

    private final String stopCommand = Command.STOP.getCmd();
    private final FileService fileService;
    private final Institution institution;
    private final MessagePrinter message;
    private final BirthdateGenerator birthdateGenerator;
    private List<String> stringsFromFile;
    private List<Institution> institutionList;


    public App(String file) {
        fileService = new FileService(file);
        institution = new Institution();
        message = new MessagePrinter();
        birthdateGenerator = new BirthdateGenerator();
        stringsFromFile = new ArrayList<>();
        institutionList = new ArrayList<>();
    }

    public void start() {
        stringsFromFile = fileService.addStringsFromFileToList();
        institutionList = Institution.convertStringsToObjects(stringsFromFile);
        message.printCommands(stopCommand);
        runBirthdateRequest();
    }

    private void runBirthdateRequest() {
        LocalDate birthDate = birthdateGenerator.createBirthdate();
        User user = new User(birthDate);
        List<Institution> suitableList = institution.getSuitableInstitutionByUserAge(institutionList, user.getAge());
        message.printListIfNotEmpty(suitableList);
        runBirthdateRequest();
    }
}
