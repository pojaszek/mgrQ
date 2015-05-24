package q16;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by user on 20-May-15.
 */

//2.3.1.3.	Ponowne użycie wyrażenia lambda
//with idiom


     class Main2 {
        public static void main(String[] args) {
            final Predicate<String> containsDashChar = x -> x.contains("-");
            final List<String> phoneNumbers = new LinkedList<>();
            phoneNumbers.add("878-432-657");
            phoneNumbers.add("565 423 455");
            phoneNumbers.add("656345534");
            phoneNumbers.add("654-543-443");
            phoneNumbers.add("48-545-123-432");

            System.out.print(phoneNumbers.stream().filter(containsDashChar).count());
        }
    }

            /*
        * Jaka wartość zostanie wyświetlona w konsoli po wywołaniu powyższego programu?
        * +A) 3
        * B) 2
        * C) 1
        * D) 0
        * */
//without idiom

    public class Main {
        public static void main(String[] args) {
            final List<String> phoneNumbers = new LinkedList<>();
            phoneNumbers.add("878-432-657");
            phoneNumbers.add("565 423 455");
            phoneNumbers.add("656345534");
            phoneNumbers.add("654-543-443");
            phoneNumbers.add("48-545-123-432");

            System.out.print(phoneNumbers.stream().filter(x -> x.contains("-")).count());
        }
    }

        /*
        * Jaka wartość zostanie wyświetlona w konsoli po wywołaniu powyższego programu?
        * +A) 3
        * B) 2
        * C) 1
        * D) 0
        * */
