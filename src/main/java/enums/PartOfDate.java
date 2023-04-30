package enums;

public enum PartOfDate {

    YEAR("year: "),
    MONTH("month: "),
    DAY("day: ");

    private final String text;


    PartOfDate(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
