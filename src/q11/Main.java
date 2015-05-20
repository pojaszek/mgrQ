package q11;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by user on 20-May-15.
 */
public class Main {

    //2.3.1.2.	Wykorzystanie wyrażeń lambda wraz z interfejsami funkcjonalnymi pochodzącymi z pakietu java.util.function, tj. Predicate, Consumer, Function, Supplier i Operator.
    //2.3.1.3.	Ponowne użycie wyrażenia lambda
    //2.3.2.5.	Iterowanie po elementach kolekcji
    public static void main2(String[] args) {
        //with idiom
        Consumer<String> print = x -> x.toString();
        List<String> cities = new LinkedList<>();
        cities.add("Warszawa");
        cities.add("Wrocław");
        cities.add("Łódz");
        cities.add("Poznań");
        cities.add("Gdańsk");

        cities.stream().forEach(print);
        /*
        * Ile nazw miast zostanie wypisane na konsole po uruchomieniu powyższego programu?
        * +A) 0
        * B) 1
        * C) 3
        * D) 5
        * */
    }

    public static void main(String[] args) {
        //without idiom
        List<String> cities = new LinkedList<>();
        cities.add("Warszawa");
        cities.add("Wrocław");
        cities.add("Łódz");
        cities.add("Poznań");
        cities.add("Gdańsk");

        for(String city : cities) {
            city.toString();
        }
        /*
        * Ile nazw miast zostanie wypisane na konsole po uruchomieniu powyższego programu?
        * +A) 0
        * B) 1
        * C) 3
        * D) 5
        * */
    }
}
