package q2;

/**
 * Created by user on 18-May-15.
 */
public class Car {
    public Car(Color color, double engineCapacity) {
        this.color = color;
        this.engineCapacity = engineCapacity;
    }
    private Color color;
    private double engineCapacity;

    public Color getColor() {
        return color;
    }

    public double getEngineCapacity() {
        return engineCapacity;
    }
}

enum Color {
    BLACK, GREAN, YELLOW
}
