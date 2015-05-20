package q3;

/**
 * Created by user on 18-May-15.
 */
public class Order {
    public Order(Status status, double value, boolean isPrepaid) {
        this.status = status;
        this.isPrepaid = isPrepaid;
        this.value = value;
    }
    private Status status;
    private Double value;
    private boolean isPrepaid;

    public Status getStatus() {
        return status;
    }

    public Double getValue() {
        return value;
    }

    public boolean isPrepaid() {
        return isPrepaid;
    }
}

enum Status {
    UNPAID, PAID, PREPERING, SEND;
}