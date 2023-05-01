package features;

import classes.*;
import enums.Command;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Stream;

public class MainDev {

    MessagePrinter message = new MessagePrinter();

    public static void main(String[] args) {

        String file = "src/main/resources/Universities.txt";
        FileService fileService = new FileService(file);
        List<String> stringsList = fileService.addStringsFromFileToList();

        Institution institution = new Institution();
        List<Institution> institutionList = institution.convertStringsToObjects(stringsList);


        BirthdateReader birthdateReader = new BirthdateReader();
//        LocalDate birthDate = birthdateRequest.getUserBirthdate();

//        User user = new User(birthDate);

//        List<Institution> suitableList = institution.getSuitableInstitutionByUserAge(institutionList, user.getAge());
        //        institution.printWithCount(suitableList);

        MessagePrinter message = new MessagePrinter();
//        message.printListWithCount(suitableList);
//        message.printWithCount(suitableList);

//        int command = getCommand();
        String country = Country.UK.getCountry();

        /*switch (command) {
            case 0 -> System.out.println("start");
            case 1 -> showByCountry(suitableList, country);
            case 2 -> System.out.println("previous step");
            case 3 -> stop();
        }*/

//        stop();
//        workflow();

        String str = "21-45, Ruprecht-Karls-Universität Heidelberg, Germany, www.uni-heidelberg.de, +49 163 1328460, schaefer.lina@hotmail.com, Dönhoffstr. 11, 07223 Alt Giadaburg, Rheinland-Pfalz";

        printOneString(str);

    }

    public static void printOneString(String line) {
        String s = Stream.of(line.split(", "))
//                .skip(1)
                .toString();
        System.out.println(s);
    }

    public static void showByCountry(List<Institution> list, String country) {
        String regex = ".*\\b" + country + "\\b.*";
        list.stream() // сделать вызов метода с вводом данных о стране
                .filter(e -> e.getCountry().matches(regex))
                .forEach(System.out::println);
    }

    private static int getCommand() {
        printCommands();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Choose command: ");
        return scanner.nextInt();

    }

    private static void runApp(List<String> stringsList) {
        Institution institution = new Institution();
        List<Institution> institutionList = institution.convertStringsToObjects(stringsList);

        BirthdateReader birthdateReader = new BirthdateReader();
//        birthdateRequest.readUserData();
//        LocalDate birthDate = birthdateRequest.generateBirthdate();

//        User user = new User(birthDate);

//        List<Institution> suitableList = institution.getSuitableInstitutionByUserAge(institutionList, user.getAge());

        MessagePrinter message = new MessagePrinter();
//        message.printListWithCount(suitableList);
    }

    private static void printCommands() {
        List<Command> strings = Arrays.stream(Command.values()).toList();
        strings.forEach(System.out::println);
    }

    /*private static User getUser() {
        BirthdateRequest birthdateRequest = new BirthdateRequest();
        LocalDate birthDate = birthdateRequest.getUserBirthdate();

        User user = new User(birthDate);
        return user;
    }*/




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

        BirthdateReader birthdateReader = new BirthdateReader();
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
