package classes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Institution {

    private String ageRange;
    private String name;
    private String country;
    private String webpage;
    private String phone;
    private String email;
    private String address;


    /**
     * Превращает лист из строк в лист из объектов
     **/
    public List<Institution> convertStringsToObjects(List<String> list) {
        return list
                .stream()
                .map(Institution::mapToEntity)
                .toList();
    }

    public List<Institution> getSuitableInstitutionByUserAge(List<Institution> list, int age) {
        return list.stream()
                .filter(s -> isAgeInRange(age, s.getAgeRange()))
                .toList();
    }

    private static boolean isAgeInRange(int age, String range) {
        String[] strings = range.split("-");
        int start = Integer.parseInt(strings[0]);
        int end = Integer.parseInt(strings[1]);
        return age >= start && age <= end;
    }

    /**
     * Выводит в консоль список (объектов)организаций с нумерацией
     **/
     public void printWithCount(List<Institution> list) {
        int count = 0;
        for (Institution institution : list) {
            count++;
            System.out.println(count + "." + institution);
        }
    }

    /**
     * Заполняет конструктор объекта соответствующими строками из файла**/
    //TODO попробовать реализовать через стрим
    public static Institution mapToEntity(String line) {
        String[] strings = line.split(",", 7);
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
        return String.format("%s |%s |%s |%s |%s |%s", name, country, webpage, phone, email, address);
    }
}
