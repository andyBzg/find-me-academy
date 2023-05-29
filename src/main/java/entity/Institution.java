package entity;

import lombok.*;

import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Institution {

    private static final int NUMBER_OF_LINES_TO_FILL_CLASS_FIELDS = 7;
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
        List<String> strings = Arrays.stream(line.split(DELIMITER, NUMBER_OF_LINES_TO_FILL_CLASS_FIELDS))
                .map(s -> s.isEmpty() ? EMPTY_STRING : s)
                .toList();
        return new Institution(
                strings.get(0),
                strings.get(1),
                strings.get(2),
                strings.get(3),
                strings.get(4),
                strings.get(5),
                strings.get(6)
        );
    }


    @Override
    public String toString() {
        return String.format(STRING_FORMAT, name, country, webpage, phone, email, address);
    }
}
