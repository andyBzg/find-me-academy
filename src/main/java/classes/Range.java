package classes;

public class Range {

    private int from;
    private int to;


    public Range(String range) {
        parseString(range);
    }

    public void parseString(String range) {
        String[] strings = range.split("-");
        from = Integer.parseInt(strings[0]);
        to = Integer.parseInt(strings[1]);
    }

    public boolean isAgeInRange(int age) {
        return age >= from && age <= to;
    }
}
