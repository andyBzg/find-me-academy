import classes.BirthdateRequest;
import classes.FileService;
import classes.Institution;
import classes.User;

import java.time.LocalDate;
import java.util.*;

public class MainDev {
    public static void main(String[] args) {

        String file = "src/main/resources/Universities.txt";
        FileService fileService = new FileService(file);
        List<String> stringsList = fileService.addStringsFromFileToList();

        Institution institution = new Institution();
        List<Institution> institutionList = institution.convertStringsToObjects(stringsList);

        BirthdateRequest birthdateRequest = new BirthdateRequest();
        LocalDate birthDate = birthdateRequest.getUserBirthdate();

        User user = new User(birthDate);

        List<Institution> suitableList = institution.getSuitableInstitutionByUserAge(institutionList, user.getAge());
        institution.printWithCount(suitableList);




//        workflow();

    }

    private static void workflow() {
        String originalFile = "src/main/resources/Universities.txt";
        String out = "src/main/resources/Universities-new.txt";
        String newOutput = "src/main/resources/Universities.txt";
        String backup = "src/main/resources/backup/Universities-backup.txt";


//        FileService fileService = new FileService();
//        fileService.rewriteToNewFile(originalFile, backup); //бекап файла с организациями

//        List<String> list = fileService.addStringsFromFileToList(originalFile);
//        fileService.writeWithAgeConditionsToFile(out, list);

//        fileService.rewriteToNewFileWithRandomAgeLimit(originalFile, newOutput); //добавляем рандомно ограничения по возрасту
//        List<String> list = fileService.addStringsFromFileToList(newOutput); //заполняем лист организациями из файла

        Institution institution = new Institution();
//        List<Institution> universitiesList = institution.convertStringsToObjects(list); //конвертируем организации из листа в объекты
//        institution.printWithCount(universitiesList); //вывести объекты на экран

        BirthdateRequest birthdateRequest = new BirthdateRequest();
//        LocalDate dateOfBirth = birthdateRequest.getUserBirthdate(); //запускает запрос на введение даты рождения
        LocalDate localDate = LocalDate.now();
//        int age = birthdateRequest.calculateAge(dateOfBirth, localDate); //считает возраст
//
//        User user = new User(age, dateOfBirth);
//        System.out.println(user);

//        System.out.println(dateOfBirth.isBefore(localDate)); //проверяет находится ли дата рождения в прошлом относительно текущей даты

//        System.out.println(Period.between(dateOfBirth, localDate)); //точный период меду датой родления и текущей датой
//        System.out.println(Period.between(dateOfBirth, localDate).getYears()); //период в годах

        int currentYear = LocalDate.now().getYear();

        LocalDate testDate = LocalDate.of(1975, 5, 9);
//        int testAge = birthdateRequest.calculateAge(testDate, localDate);
//        User testUser = new User(testAge, testDate);
//        System.out.println(testUser);

//        institution.printSuitableByAge(universitiesList, testUser.getAge());
    }

}
