package classes;

import lombok.*;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Institution {

    private String ageRange;
    private String name;
    private String country;
    private String webpage;
    private String phone;
    private String email;
    private String address;


    public List<Institution> convertStringsToObjects(List<String> list) {
        return list
                .stream()
                .filter(Objects::nonNull)
                .map(Institution::mapToEntity)
                .sorted(Comparator.comparing(Institution::getName))
                .toList();
    }

    public List<Institution> getSuitableInstitutionByUserAge(List<Institution> list, int age) {
        return list.stream()
                .filter(Objects::nonNull)
                .filter(s -> isAgeInRange(age, s.getAgeRange()))
                .toList();
    }

    public boolean isAgeInRange(int age, String range) {
        String[] strings = range.split("-");
        int start = Integer.parseInt(strings[0]);
        int end = Integer.parseInt(strings[1]);
        return age >= start && age <= end;
    }

    public static Institution mapToEntity(String line) {
        String[] strings = line.split(", ", 7);
        String ageRestriction = strings.length >= 1 ? strings[0] : "";
        String name = strings.length >= 1 ? strings[1] : "";
        String country = strings.length >= 1 ? strings[2] : "";
        String webpage = strings.length >= 1 ? strings[3] : "";
        String phone = strings.length >= 1 ? strings[4] : "";
        String email = strings.length >= 1 ? strings[5] : "";
        String address = strings.length >= 1 ? strings[6] : "";
        return new Institution(ageRestriction, name, country, webpage, phone, email, address);
    }

    @Override
    public String toString() {
        return String.format("%s | %s | %s | %s | %s | %s", name, country, webpage, phone, email, address);
    }
}
