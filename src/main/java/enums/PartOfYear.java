package enums;

public enum PartOfYear {

    YEAR("year: "),
    MONTH("month: "),
    DAY("day: ");

    private final String text;


    PartOfYear(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
