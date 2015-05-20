package q12;

/**
 * Created by user on 19-May-15.
 */
public class Speaker {

    private String brand;
    private int power;

    public Speaker(int power) {
        this.power = power;
    }

    public Speaker(String brand, int power) {
        this.brand = brand;
        this.power = power;
    }

    public String getBrand() {
        return brand;
    }

    public int getPower() {
        return power;
    }

    @Override
    public String toString() {
        return "Speaker{" +
                "brand='" + brand + '\'' +
                ", power=" + power +
                '}';
    }
}
