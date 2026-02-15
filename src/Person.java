public class Person {
    private String name;
    private String surname;
    private int yearOfBirth;
    private String favouriteSport;

    public Person(String name, String surname, int yearOfBirth, String favouriteSport) {
        this.name = name;
        this.surname = surname;
        this.yearOfBirth = yearOfBirth;
        this.favouriteSport = favouriteSport;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getFavouriteSport() {
        return favouriteSport;
    }
    public String toString() {
        return "Data: " + name + " " + surname;
    }
    public int getAge() {
        return 2026 - yearOfBirth;
    }
}
