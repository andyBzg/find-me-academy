package classes;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileServiceTest {

    @Test
    void addStringsFromFileToList_givenCorrectFile_success() {
        // given
        String file = "src/test/resources/Test.txt";
        FileService fileService = new FileService(file);
        List<String> expected = List.of("String for test");

        // when
        List<String> actual = fileService.addStringsFromFileToList();

        // then
        assertEquals(expected, actual);
    }

    @Test
    void addStringsFromFileToList_fileIsEmpty_success() {
        // given
        String file = "src/test/resources/Test_empty.txt";
        FileService fileService = new FileService(file);
        List<String> expected = new ArrayList<>();

        // when
        List<String> actual = fileService.addStringsFromFileToList();

        // then
        assertEquals(expected, actual);
    }

    @Test
    void addStringsFromFileToList_filepathIsEmpty_success() {
        String file = "";
        FileService fileService = new FileService(file);

        assertThrows(RuntimeException.class, () -> fileService.addStringsFromFileToList());
    }
}