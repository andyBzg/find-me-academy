package classes;

import lombok.extern.log4j.Log4j2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Log4j2
public class FileService {

    private final String file;

    public FileService(String file) {
        this.file = file;
    }

    public String getFile() {
        return file;
    }

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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FileService that = (FileService) o;

        return Objects.equals(file, that.file);
    }

    @Override
    public int hashCode() {
        return file != null ? file.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "FileService{" +
                "file='" + file + '\'' +
                '}';
    }
}
