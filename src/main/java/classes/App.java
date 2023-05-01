package classes;

import classes.*;
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
    private List<String> stringList;
    private List<Institution> institutionList;


    public App(String file) {
        fileService = new FileService(file);
        institution = new Institution();
        message = new MessagePrinter();
        birthdateGenerator = new BirthdateGenerator();
        stringList = new ArrayList<>();
        institutionList = new ArrayList<>();
    }

    public void start() {
        stringList = fileService.addStringsFromFileToList();
        institutionList = institution.convertStringsToObjects(stringList);
        message.printCommands(stopCommand);
        runBirthdateRequest();
    }

    private void runBirthdateRequest() {
        LocalDate birthDate = birthdateGenerator.generate();
        User user = new User(birthDate);
        List<Institution> suitableList = institution.getSuitableInstitutionByUserAge(institutionList, user.getAge());
        message.printItOut(suitableList);
        runBirthdateRequest();
    }

    public static void stop() {
        System.exit(0);
    }

}
