package q10;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by user on 19-May-15.
 */
public class Main {

    //2.3.3.2.	Referencje do metod

    public static void main2(String[] args) {
        //without idiom
        List<String> fruits = new LinkedList<>();
        fruits.add("watermelon");
        fruits.add("strawberries");
        fruits.add("grape");
        fruits.add("peach");
        fruits.add("banana");
        fruits.add("mango");
        fruits.sort((String a, String b) -> a.toUpperCase().compareTo(b.toLowerCase()));

        for(String fruit : fruits) {
            System.out.print(fruit + " ");
        }
        /*
        * Jaka wartość zostanie wyświetlona w konsoli po wywołaniu powyższego programu?
        * A) MANGO BANANA PEACH GRAPE STRAWBERRIES WATERMELON
        * B) banana grape mango peach strawberries watermelon
        * +C) mango banana peach grape strawberries watermelon
        * D) BANANA GRAPE MANGO PEACH STRAWBERRIES WATERMELON
        * */
    }

    public static void main(String[] args) {
        //with idiom
        List<String> fruits = new LinkedList<>();
        fruits.add("watermelon");
        fruits.add("strawberries");
        fruits.add("grape");
        fruits.add("peach");
        fruits.add("banana");
        fruits.add("mango");
        fruits.sort(Comparator.comparing(String::toUpperCase));

        for(String fruit : fruits) {
            System.out.print(fruit + " ");
        }
        /*
        * Jaka wartość zostanie wyświetlona w konsoli po wywołaniu powyższego programu?
        * A) MANGO BANANA PEACH GRAPE STRAWBERRIES WATERMELON
        * +B) banana grape mango peach strawberries watermelon
        * C) mango banana peach grape strawberries watermelon
        * D) BANANA GRAPE MANGO PEACH STRAWBERRIES WATERMELON
        * */
    }
}
