package q4;

/**
 * Created by user on 18-May-15.
 */
public class Operation {
    public Operation(String name, double value, int prority) {

        this.name = name;
        this.value = value;
        this.prority = prority;
    }

    private String name;
    private double value;
    private int prority;

    public String getName() {
        return name;
    }

    public double getValue() {
        return value;
    }

    public int getPrority() {
        return prority;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "name='" + name + '\'' +
                '}';
    }
}

class OperationDTO {
    OperationDTO(String name) {
        this.name = name;
    }
    String name;
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "OperationDTO{" +
                "name='" + name + '\'' +
                '}';
    }
}