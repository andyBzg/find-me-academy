package features;

import java.util.Random;

/**
 * Этот энам нужен для генерации возрастных ограничений **/
public enum EducationLevel {

    EARLY_EDUCATION("3-7"),
    PRIMARY_EDUCATION("5-15"),
    SECONDARY_EDUCATION("15-21"),
    TERTIARY_EDUCATION("21-45"),
    BACHELOR_LEVEL("25-55"),
    DOCTORAL_LEVEL("45-65"),
    NOT_CLASSIFIED("1-100");

    private final String ageRange;


    EducationLevel(String ageRange) {
        this.ageRange = ageRange;
    }

    public String getAgeRange() {
        return ageRange;
    }

    public static EducationLevel getRandomLevel() {
        Random random = new Random();
        EducationLevel[] values = EducationLevel.values();
        return values[random.nextInt(values().length)];
    }
}
