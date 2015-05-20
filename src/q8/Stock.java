package q8;

/**
 * Created by user on 18-May-15.
 */
public class Stock {
    private String name;
    private int price;

    public Stock(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
