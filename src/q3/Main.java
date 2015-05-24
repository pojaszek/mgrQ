package q3;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by user on 18-May-15.
 */

//2.3.1.3.	Ponowne użycie wyrażenia lambda
//2.3.2.1.	Przetwarzanie danych z wykorzystaniem strumieni w celu filtrowania, sortowania i mapowania jej elementów
//without idiom

     class Main2 {
        public static void main(String[] args) {
            List<Order> orders = new LinkedList<>();
            orders.add(new Order(Status.PAID, 34324.0, false));
            orders.add(new Order(Status.PAID, 5443.14, true));
            orders.add(new Order(Status.UNPAID, 234.42, false));
            orders.add(new Order(Status.UNPAID, 11.46, false));
            orders.add(new Order(Status.PREPARING, 55.99, true));
            orders.add(new Order(Status.SEND, 56.99, false));
            orders.add(new Order(Status.SEND, 100.00, true));

            int count = 0;
            for (Order order : orders) {
                if (order.getStatus() != Status.SEND &&
                        order.getValue() < 10000 && !order.isPrepaid()) {
                    count++;
                }
            }
            System.out.print(count);
        }
    }


        /*
        * Jaka wartość zostanie wyświetlona w konsoli po wywołaniu powyższego programu?
        * A) 1
        * +B) 2
        * C) 3
        * D) 5
        * */

//with idiom

    class Order {
        private Status status;
        private Double value;
        private boolean isPrepaid;

        public Order(Status status, double value, boolean isPrepaid) {
            this.status = status;
            this.isPrepaid = isPrepaid;
            this.value = value;
        }
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
        UNPAID, PAID, PREPARING, SEND
    }
    public class Main {
        public static void main(String[] args) {
            List<Order> orders = new LinkedList<>();
            orders.add(new Order(Status.PAID, 34324.0, false));
            orders.add(new Order(Status.PAID, 5443.14, true));
            orders.add(new Order(Status.UNPAID, 234.42, false));
            orders.add(new Order(Status.UNPAID, 11.46, false));
            orders.add(new Order(Status.PREPARING, 55.99, true));
            orders.add(new Order(Status.SEND, 56.99, false));
            orders.add(new Order(Status.SEND, 100.00, true));

            Predicate<Order> isNotSend = order -> order.getStatus() != Status.SEND;
            Predicate<Order> isLessThan10000 = order -> order.getValue() < 10000;
            Predicate<Order> isNotPrepaid = order -> !order.isPrepaid();
            long count = orders.stream().filter(
                    isNotSend.and(isLessThan10000).and(isNotPrepaid)).count();
            System.out.print(count);
        }
    }


        /*
        * Jaka wartość zostanie wyświetlona w konsoli po wywołaniu powyższego programu?
        * A) 1
        * +B) 2
        * C) 3
        * D) 5
        * */
