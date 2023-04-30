package classes;

import enums.EducationLevel;
import lombok.extern.log4j.Log4j2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Log4j2
public class FileService {

    private final String file;

    public FileService(String file) {
        this.file = file;
    }

    /**
     * Добавляет названия организаций из файла в лист
     **/
    public List<String> addStringsFromFileToList() {
        List<String> stringList = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringList.add(line);
            }
        }
        catch (IOException e) {
            log.error("addStringsFromFileToList: " + e.getMessage());
            throw new RuntimeException(e);
        }
        return stringList;
    }

    //TODO удалить служебные методы
    /**
     * Служебный метод для перезаписи файла в новый файл (бекап, перезапись, запись с измененными строчками)
     * **/
    public void rewriteToNewFile(String inputFile, String outputFile) {
        try {
            try(BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile));
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputFile))){
                String line;
                while((line = bufferedReader.readLine()) != null) {
                    bufferedWriter.write(line);
                    bufferedWriter.newLine();
                }
            }
        } catch (IOException e) {
            log.error("rewriteToNewFile: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    /**
     * Служебный метод
     * Добавляет "ограничения по возрасту" для каждой организации рандомно
     **/
    public void rewriteToNewFileWithRandomAgeLimit(String inputFile, String outputFile) {
        try {
            try(BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile));
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputFile))){
                String line;
                while((line = bufferedReader.readLine()) != null) {
                    bufferedWriter.write(EducationLevel.getRandomLevel().getAgeRange() + ", " + line);
                    bufferedWriter.newLine();
                }
            }
        } catch (IOException e) {
            log.error("rewriteToNewFileWithRandomAgeLimit: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

}
