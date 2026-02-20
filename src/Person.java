import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private String surname;
    private int yearOfBirth;
    private String favouriteSport;
    private List<String> hobbies = new ArrayList<>();

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
    public List<String> getHobbies() {
        return List.copyOf(hobbies);
    }
    public void addHobbies(String hobby) {
        hobbies.add(hobby);
    }

    public String getFavouriteSport() {
        return favouriteSport;
    }
    public String toString() {
        return  name + " " + surname;
    }
    public int getAge() {
        return 2026 - yearOfBirth;
    }
}
