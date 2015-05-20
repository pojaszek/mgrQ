package q15;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by user on 19-May-15.
 */
public class Main {
    //2.3.2.5.	Iterowanie po elementach kolekcji
    public static void main2(String[] args) {
        //without idiom
        List<Integer> marks = new LinkedList<>();
        marks.add(3);
        marks.add(4);
        marks.add(2);
        marks.add(5);
        marks.add(5);
        marks.add(2);

        for(Integer mark : marks) {
            printCategory(mark);
        }
        /*
        * Jaka wartość zostanie wyświetlona w konsoli po wywołaniu powyższego programu?
        * A) bad awesome awesome bad awesome ok
        * B) ok awesome bad awesome bad
        * +C) ok awesome bad awesome awesome bad
        * D) bad awesome bad awesome ok
        * */
    }

    public static void main(String[] args) {
        //with idiom
        List<Integer> marks = new LinkedList<>();
        marks.add(3);
        marks.add(4);
        marks.add(2);
        marks.add(5);
        marks.add(5);
        marks.add(2);

        marks.stream().forEach(x -> printCategory(x));
        /*
        * Jaka wartość zostanie wyświetlona w konsoli po wywołaniu powyższego programu?
        * A) bad awesome awesome bad awesome ok
        * B) ok awesome bad awesome bad
        * +C) ok awesome bad awesome awesome bad
        * D) bad awesome bad awesome ok
        * */
    }

    private static void printCategory(Integer mark) {
        System.out.print(getCategory(mark) + " ");
    }

    private static String getCategory(Integer mark) {
        if(mark < 3) {
            return "bad";
        } else if(mark < 4) {
            return "ok";
        } else {
            return "awesome";
        }
    }
}
