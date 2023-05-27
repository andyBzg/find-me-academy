package service;

import lombok.Data;
import lombok.extern.log4j.Log4j2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Log4j2
@Data
public class FileService {

    private final String file;


    public List<String> addStringsFromFileToList() {
        List<String> stringList = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringList.add(line);
            }
        }
        catch (IOException e) {
            log.error("addStringsFromFileToList(): " + e.getMessage());
            throw new RuntimeException(e);
        }
        return stringList;
    }
}
