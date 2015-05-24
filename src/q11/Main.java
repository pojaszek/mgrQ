package q11;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by user on 20-May-15.
 */


//2.3.1.2.	Wykorzystanie wyrażeń lambda wraz z interfejsami funkcjonalnymi pochodzącymi z pakietu java.util.function, tj. Predicate, Consumer, Function, Supplier i Operator.
//2.3.1.3.	Ponowne użycie wyrażenia lambda
//2.3.2.5.	Iterowanie po elementach kolekcji

//with idiom

     class Main2 {
        public static void main(String[] args) {
            Consumer<String> print = x -> x.toString();
            List<String> cities = new LinkedList<>();
            cities.add("Warszawa");
            cities.add("Wrocław");
            cities.add("Łódz");
            cities.add("Poznań");
            cities.add("Gdańsk");

            cities.stream().forEach(print);
        }
    }

        /*
        * Co zostanie wypisane na konsolę?
        * A) WarszawaWrocławŁódzPoznańGdańsk
        * B) Warszawa Wrocław Łódz Poznań Gdańsk
        * C) GdańskPoznańŁódzWrocławWarszawa
        * +D) Nic nie zostanie wypisane
        * */


//without idiom


    public class Main {
        public static void main(String[] args) {
            List<String> cities = new LinkedList<>();
            cities.add("Warszawa");
            cities.add("Wrocław");
            cities.add("Łódz");
            cities.add("Poznań");
            cities.add("Gdańsk");

            for(String city : cities) {
                city.toString();
            }
        }
    }



