package classes;

import org.junit.jupiter.api.Test;
import service.FileService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileServiceTest {

    @Test
    void addStringsFromFileToList_givenCorrectFile_success() {
        // given
        String file = "src/test/resources/Test-file.txt";
        FileService fileService = new FileService(file);
        List<String> expected = List.of("String for test");

        // when
        List<String> actual = fileService.addStringsFromFileToList();

        // then
        assertEquals(expected, actual);
    }

    @Test
    void addStringsFromFileToList_fileIsEmpty_nothing() {
        // given
        String file = "src/test/resources/Empty-file.txt";
        FileService fileService = new FileService(file);
        List<String> expected = new ArrayList<>();

        // when
        List<String> actual = fileService.addStringsFromFileToList();

        // then
        assertEquals(expected, actual);
    }

    @Test
    void addStringsFromFileToList_filepathIsEmpty_throwsException() {
        String file = "";
        FileService fileService = new FileService(file);

        assertThrows(RuntimeException.class, () -> fileService.addStringsFromFileToList());
    }
}