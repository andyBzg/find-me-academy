package classes;

import java.util.List;

public class Institution {

    private String ageRestriction;
    private String name;
    private String country;
    private String webpage;
    private String phoneNr;
    private String email;
    private String address;


    public Institution() {

    }

    private Institution(String ageRestriction, String name, String country, String webpage, String phoneNr, String email, String address) {
        this.ageRestriction = ageRestriction;
        this.name = name;
        this.country = country;
        this.webpage = webpage;
        this.phoneNr = phoneNr;
        this.email = email;
        this.address = address;
    }

    public String getAgeRestriction() {
        return ageRestriction;
    }

    public void setAgeRestriction(String ageRestriction) {
        this.ageRestriction = ageRestriction;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getWebpage() {
        return webpage;
    }

    public void setWebpage(String webpage) {
        this.webpage = webpage;
    }

    public String getPhoneNr() {
        return phoneNr;
    }

    public void setPhoneNr(String phoneNr) {
        this.phoneNr = phoneNr;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Превращает строки из листа в лист из объектов
     **/
    public List<Institution> convertStringsToObjects(List<String> list) {
        return list
                .stream()
                .map(Institution::mapToEntity)
                .toList();
    }

    /**
     * Выводит в консоль список (объектов)организаций с нумерацией
     **/
     public void printWithCount(List<Institution> list) {
        int count = 0;
        for (Institution institution : list) {
            count++;
            System.out.println(count + ". " + institution);
        }
    }

    /**
     * Заполняет конструктор объекта соответствующими строками из файла**/
    //TODO попробовать реализовать через стрим
    public static Institution mapToEntity(String line) {
//        (up to 21), Imperial College London, UK, www.imperial.ac.uk, +44 7703 624285, dicki.phyllis@jones.com, 3146 North Old Wire Road, Fayetteville AR 72703
        //   0,             1,                  2,       3,                 4,                  5,                        6,
        String[] strings = line.split(",", 7);
        String ageRestriction = strings.length >= 1 ? strings[0] : ""; //(up to 21)
        String name = strings.length >= 1 ? strings[1] : ""; // Imperial College London
        String country = strings.length >= 1 ? strings[2] : ""; // UK
        String webpage = strings.length >= 1 ? strings[3] : ""; // www.imperial.ac.uk
        String phoneNr = strings.length >= 1 ? strings[4] : ""; //+44 7703 624285
        String email = strings.length >= 1 ? strings[5] : ""; //dicki.phyllis@jones.com
        String address = strings.length >= 1 ? strings[6] : ""; //3146 North Old Wire Road, Fayetteville AR 72703
        return new Institution(ageRestriction, name, country, webpage, phoneNr, email, address);
    }

    @Override
    public String toString() {
        return String.format("%s |%s |%s |%s |%s |%s |%s", ageRestriction, name, country, webpage, phoneNr, email, address);
    }
}
