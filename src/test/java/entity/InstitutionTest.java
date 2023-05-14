package entity;

import entity.Institution;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InstitutionTest {

    Institution institution;

    @BeforeEach
    void init() {
        institution = new Institution();
    }

    @Test
    void convertStringsToObjects_validInput_success() {
        // given
        List<String> input = List.of(
                "21-45, Ruprecht-Karls-Universität Heidelberg, Germany, www.uni-heidelberg.de, +49 163 1328460, schaefer.lina@hotmail.com, Dönhoffstr. 11, 07223 Alt Giadaburg, Rheinland-Pfalz"
        );
        List<Institution> expected = List.of(
                new Institution("21-45",
                        "Ruprecht-Karls-Universität Heidelberg",
                        "Germany",
                        "www.uni-heidelberg.de",
                        "+49 163 1328460",
                        "schaefer.lina@hotmail.com",
                        "Dönhoffstr. 11, 07223 Alt Giadaburg, Rheinland-Pfalz"
                )
        );

        // when
        List<Institution> actual = Institution.convertStringsToObjects(input);

        // then
        assertEquals(expected, actual);
    }

    @Test
    void convertStringsToObjects_listIsEmpty_success() {
        // given
        List<String> input = Collections.emptyList();

        // when
        List<Institution> actual = Institution.convertStringsToObjects(input);

        // then
        assertTrue(actual.isEmpty());
    }

    @Test
    void convertStringsToObjects_withNull_throwsException() {
        assertThrows(NullPointerException.class, () -> Institution.convertStringsToObjects(null));
    }

    @Test
    void getSuitableInstitutionByUserAge_validInput() {
        // given
        int age = 25;
        List<Institution> list = List.of(
                new Institution("21-45",
                        "Ruprecht-Karls-Universität Heidelberg",
                        "Germany",
                        "www.uni-heidelberg.de",
                        "+49 163 1328460",
                        "schaefer.lina@hotmail.com",
                        "Dönhoffstr. 11, 07223 Alt Giadaburg, Rheinland-Pfalz"
                )
        );
        List<Institution> expected = List.of(list.get(0));

        // when
        List<Institution> actual = institution.getSuitableInstitutionByUserAge(list, age);

        // then
        assertEquals(expected, actual);
    }

    @Test
    void getSuitableInstitutionByUserAge_invalidAge() {
        // given
        int age = -25;
        List<Institution> list = List.of(
                new Institution("21-45",
                        "Ruprecht-Karls-Universität Heidelberg",
                        "Germany",
                        "www.uni-heidelberg.de",
                        "+49 163 1328460",
                        "schaefer.lina@hotmail.com",
                        "Dönhoffstr. 11, 07223 Alt Giadaburg, Rheinland-Pfalz"
                )
        );

        // when
        List<Institution> actual = institution.getSuitableInstitutionByUserAge(list, age);

        // then
        assertTrue(actual.isEmpty());
    }

    @Test
    void getSuitableInstitutionByUserAge_emptyList() {
        // given
        List<Institution> input = Collections.emptyList();
        int age = 25;

        // when
        List<Institution> actual = institution.getSuitableInstitutionByUserAge(input, age);

        // then
        assertTrue(actual.isEmpty());
    }

    @Test
    void getSuitableInstitutionByUserAge_withNull_throwsException() {
        int age = 25;

        assertThrows(NullPointerException.class, () -> institution.getSuitableInstitutionByUserAge(null, age));
    }

    @Test
    void mapToEntity_validData_success() {
        // given
        String input = "21-45, Ruprecht-Karls-Universität Heidelberg, Germany, www.uni-heidelberg.de, +49 163 1328460, schaefer.lina@hotmail.com, Dönhoffstr. 11, 07223 Alt Giadaburg, Rheinland-Pfalz";
        Institution expected = new Institution(
                "21-45",
                "Ruprecht-Karls-Universität Heidelberg",
                "Germany",
                "www.uni-heidelberg.de",
                "+49 163 1328460",
                "schaefer.lina@hotmail.com",
                "Dönhoffstr. 11, 07223 Alt Giadaburg, Rheinland-Pfalz"
        );

        // when
        Institution actual = Institution.mapToEntity(input);

        // then
        assertEquals(expected, actual);
    }

    @Test
    void mapToEntity_emptyString_throwsException() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> Institution.mapToEntity(""));
    }

    @Test
    void mapToEntity_stringIsTooShort_throwsException() {
        String input = "21-45, Ruprecht-Karls-Universität Heidelberg";

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> Institution.mapToEntity(input));
    }

    @Test
    void mapToEntity_withNull_throwsException() {
        assertThrows(NullPointerException.class, () -> Institution.mapToEntity(null));
    }

}