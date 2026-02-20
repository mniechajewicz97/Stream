import java.util.ArrayList;
import java.util.List;

public class Firma {
    private String name;
    private List<Person> pracownicy = new ArrayList<Person>();

    public Firma(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Person> getPracownicy() {
        return List.copyOf(pracownicy);
    }
    public String toString() {
        return  name + ", lista pracowników: " + pracownicy;
    }
    public void addPerson(Person person) {
        pracownicy.add(person);
    }
}
