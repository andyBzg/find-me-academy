package entity;

import entity.User;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    public void calculateAge_actualDate_success() {
        // given
        LocalDate birthDate = LocalDate.of(1961, 5, 17);
        int expected = 62;
        User user = new User(birthDate);

        // when
        int actual = user.calculateAge(LocalDate.of(1961, 5, 17));

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void calculateAge_dateInFuture_success() {
        // given
        LocalDate birthDate = LocalDate.of(2200, 5, 17);
        int expected = 0;
        User user = new User(birthDate);

        // when
        int actual = user.calculateAge(LocalDate.of(2200, 5, 17));

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void calculateAge_nullInsteadOfLocalDate_success() {
        // given
        LocalDate birthDate = null;
        int expected = 0;
        User user = new User(birthDate);

        // when
        int actual = user.calculateAge(null);

        // then
        assertEquals(expected, actual);
    }
}