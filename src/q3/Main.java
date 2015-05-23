package q3;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by user on 18-May-15.
 */
public class Main {

    //2.3.1.3.	Ponowne użycie wyrażenia lambda
    //2.3.2.1.	Przetwarzanie danych z wykorzystaniem strumieni w celu filtrowania, sortowania i mapowania jej elementów
    public static void main2(String[] args) {
        //without idiom
        List<Order> orders = new LinkedList<>();
        orders.add(new Order(Status.PAID, 34324.0, false));
        orders.add(new Order(Status.PAID, 5443.14, true));
        orders.add(new Order(Status.UNPAID, 234.42, false));
        orders.add(new Order(Status.UNPAID, 11.46, false));
        orders.add(new Order(Status.PREPERING, 55.99, true));
        orders.add(new Order(Status.SEND, 56.99, false));
        orders.add(new Order(Status.SEND, 100.00, true));

        int count = 0;
        for(Order order : orders) {
            if(order.getStatus() != Status.SEND && order.getValue() < 10000 && !order.isPrepaid()) {
                count++;
            }
        }
        System.out.print(count);
        /*
        * Jaka wartość zostanie wyświetlona w konsoli po wywołaniu powyższego programu?
        * A) 1
        * +B) 2
        * C) 3
        * D) 5
        * */
    }

    public static void main(String[] args) {
        //with idiom
        List<Order> orders = new LinkedList<>();
        orders.add(new Order(Status.PAID, 34324.0, false));
        orders.add(new Order(Status.PAID, 5443.14, true));
        orders.add(new Order(Status.UNPAID, 234.42, false));
        orders.add(new Order(Status.UNPAID, 11.46, false));
        orders.add(new Order(Status.PREPERING, 55.99, true));
        orders.add(new Order(Status.SEND, 56.99, false));
        orders.add(new Order(Status.SEND, 100.00, true));

        Predicate<Order> isNotSend = order -> order.getStatus() != Status.SEND;
        Predicate<Order> isLessThan10000 = order -> order.getValue() < 10000;
        Predicate<Order> isNotPrepaid = order -> !order.isPrepaid();
        long count = orders.stream().filter(isNotSend.and(isLessThan10000).and(isNotPrepaid)).count();
        System.out.print(count);
        /*
        * Jaka wartość zostanie wyświetlona w konsoli po wywołaniu powyższego programu?
        * A) 1
        * +B) 2
        * C) 3
        * D) 5
        * */
    }
}
