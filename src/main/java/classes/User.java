package classes;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.Period;

@Setter
@Getter
public class User {

    private LocalDate dateOfBirth;
    private int age;


    public User(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        this.age = calculateAge(dateOfBirth);
    }

    public int calculateAge(LocalDate dateOfBirth) {
        LocalDate currentDate = LocalDate.now();
        if (dateOfBirth != null && !DateUtils.isDateOfBirthInFuture(dateOfBirth)) {
            return Period.between(dateOfBirth, currentDate).getYears();
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return String.format("User{%s, %s}\n", dateOfBirth, age);
    }
}
