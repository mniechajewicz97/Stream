import java.util.Optional;

public class Product {
    private String name;
    private Optional<Double> discount;

    public Product(String name, Optional<Double> discount) {
        this.name = name;
        this.discount = discount;

        }
        public String getName () {
            return name;
        }
        public Optional<Double> getDiscount () {
            return discount;
        }
    }



