package entity;

import lombok.*;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Institution {

    private static final int LIMITATION_FOR_SPLIT = 7;
    private static final String DELIMITER = ", ";
    private static final String EMPTY_STRING = "";
    private static final String STRING_FORMAT = "%s | %s | %s | %s | %s | %s";
    private String ageRange;
    private String name;
    private String country;
    private String webpage;
    private String phone;
    private String email;
    private String address;


    public List<Institution> getSuitableInstitutionByUserAge(List<Institution> list, int age) {
        return list.stream()
                .filter(Objects::nonNull)
                .filter(s -> new Range(s.getAgeRange()).isAgeInRange(age))
                .toList();
    }

    public static List<Institution> convertStringsToObjects(List<String> list) {
        return list
                .stream()
                .filter(Objects::nonNull)
                .map(Institution::mapToEntity)
                .sorted(Comparator.comparing(Institution::getName))
                .toList();
    }

    public static Institution mapToEntity(String line) {
        String[] strings = line.split(DELIMITER, LIMITATION_FOR_SPLIT);
        String ageRestriction = strings.length >= 1 ? strings[0] : EMPTY_STRING;
        String name = strings.length >= 1 ? strings[1] : EMPTY_STRING;
        String country = strings.length >= 1 ? strings[2] : EMPTY_STRING;
        String webpage = strings.length >= 1 ? strings[3] : EMPTY_STRING;
        String phone = strings.length >= 1 ? strings[4] : EMPTY_STRING;
        String email = strings.length >= 1 ? strings[5] : EMPTY_STRING;
        String address = strings.length >= 1 ? strings[6] : EMPTY_STRING;
        return new Institution(ageRestriction, name, country, webpage, phone, email, address);
    }

    @Override
    public String toString() {
        return String.format(STRING_FORMAT, name, country, webpage, phone, email, address);
    }
}
