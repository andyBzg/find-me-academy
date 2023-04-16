package enums;

import java.util.Random;

public enum AgeLimitation {

    BEFORE_18("up to 18"),
    BEFORE_21("up to 21"),
    FROM_14_TO_35("14 - 35"),
    FROM_35_TO_55("35 - 55"),
    FROM_65_AND_UP("65+"),
    NO_LIMIT("no limit");

    private String limit;


    AgeLimitation(String limit) {
        this.limit = limit;
    }

    public String getLimit() {
        return limit;
    }

    public static AgeLimitation getRandomAgeLimit() {
        Random random = new Random();
        AgeLimitation[] values = AgeLimitation.values();
        return values[random.nextInt(values().length)];
    }
}
