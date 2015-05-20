package q16;

/**
 * Created by user on 20-May-15.
 */
public class Dealer {
    private String name;
    private int mobile;

    public Dealer(String name, int mobile) {
        this.name = name;
        this.mobile = mobile;
    }

    public int getMobile() {
        return mobile;
    }

    public String getName() {
        return name;
    }
}
