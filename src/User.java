import java.util.Optional;

public class User {
    private String name;
    private Optional<Address> address;

    public User(String name, Optional<Address> address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public Optional<Address> getAddress() {
        return address;
    }
}
