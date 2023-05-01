package classes;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InstitutionTest {

    @Test
    void convertStringsToObjects_validInput_success() {
        // given
        List<String> input = List.of(
                "21-45, Ruprecht-Karls-Universität Heidelberg, Germany, www.uni-heidelberg.de, +49 163 1328460, schaefer.lina@hotmail.com, Dönhoffstr. 11, 07223 Alt Giadaburg, Rheinland-Pfalz"
        );
        Institution institution = new Institution();
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
        List<Institution> actual = institution.convertStringsToObjects(input);

        // then
        assertEquals(expected, actual);
    }

    @Test
    void convertStringsToObjects_listIsEmpty_success() {
        // given
        List<String> input = Collections.emptyList();
        Institution institution = new Institution();

        // when
        List<Institution> actual = institution.convertStringsToObjects(input);

        // then
        assertTrue(actual.isEmpty());
    }

    @Test
    void convertStringsToObjects_withNull_success() {
        Institution institution = new Institution();

        assertThrows(NullPointerException.class, () -> institution.convertStringsToObjects(null));
    }

    @Test
    void getSuitableInstitutionByUserAge_validInput() {
        // given
        Institution institution = new Institution();
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
        Institution institution = new Institution();
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
        Institution institution = new Institution();

        // when
        List<Institution> actual = institution.getSuitableInstitutionByUserAge(input, age);

        // then
        assertTrue(actual.isEmpty());
    }

    @Test
    void getSuitableInstitutionByUserAge_withNull() {
        Institution institution = new Institution();
        int age = 25;

        assertThrows(NullPointerException.class, () -> institution.getSuitableInstitutionByUserAge(null, age));
    }

    @Test
    void isAgeInRange_positive() {
        Institution institution = new Institution();

        assertTrue(institution.isAgeInRange(25,"21-45"));
    }

    @Test
    void isAgeInRange_negative() {
        Institution institution = new Institution();

        assertFalse(institution.isAgeInRange(50,"21-45"));
    }

    @Test
    void isAgeInRange_border() {
        Institution institution = new Institution();

        assertTrue(institution.isAgeInRange(21,"21-45"));
        assertTrue(institution.isAgeInRange(45, "21-45"));
        assertFalse(institution.isAgeInRange(20,"21-45"));
        assertFalse(institution.isAgeInRange(46, "21-45"));
    }

    @Test
    void mapToEntity() {
        // given
        // when
        // then
    }
}