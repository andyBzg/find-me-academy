package classes;

import enums.AgeLimitation;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileService {

    /**
     * Добавляет названия организаций из файла в лист
     **/
    public List<String> addStringsFromFileToList(String filePath) {
        List<String> stringList = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringList.add(line);
            }
        }
        catch (IOException e) {
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
                    bufferedWriter.write(AgeLimitation.getRandomAgeLimit().getLimit() + ", " + line);
                    bufferedWriter.newLine();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Служебный метод
     * Добавляет "ограничения по возрасту" для каждой организации в зависимости от длинны строки
     **/
    public void writeWithAgeConditionsToFile(String out, List<String> list) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(out))) {
            for (String str : list) {
                if (str.length() >= 110 && str.length() <= 119) {
                    bufferedWriter.write("(up to 18), " + str);
                }
                if (str.length() > 119 && str.length() <= 128) {
                    bufferedWriter.write("(14 - 35), " + str);
                }
                if (str.length() > 128 && str.length() <= 137) {
                    bufferedWriter.write("(65+), " + str);
                }
                if (str.length() > 137 && str.length() <= 146) {
                    bufferedWriter.write("(up to 21), " + str);
                }
                if (str.length() > 146 && str.length() <= 154) {
                    bufferedWriter.write("(no limit), " + str);
                }
                if (str.length() > 154) {
                    bufferedWriter.write("(35 - 55), " + str);
                }
                bufferedWriter.newLine();
            }
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
