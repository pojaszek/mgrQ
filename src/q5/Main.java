package q5;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by user on 18-May-15.
 */


//2.3.2.2.	Przetwarzanie danych z wykorzystaniem strumieni w celu znajdowania maksymalnego lub minimalnego elementu kolekcji
//2.3.3.2.	Referencje do metod
//without idiom

     class Main2 {
        public static void main(String[] args) {
            List<Box> boxes = new LinkedList<>();
            boxes.add(new Box(0.43));
            boxes.add(new Box(4.11));
            boxes.add(new Box(1.32));
            boxes.add(new Box(1.73));
            boxes.add(new Box(6.11));
            boxes.add(new Box(11.3));
            boxes.add(new Box(4.99));
            boxes.add(new Box(3.43));

            double tmp = Double.MIN_VALUE;
            Box searchedBox = null;
            for (Box box : boxes) {
                if (tmp < box.getHeight()) {
                    tmp = box.getHeight();
                    searchedBox = box;
                }
            }
            System.out.print(searchedBox.getHeight());
        }
    }


    /*
         * Jaka wartość zostanie wyświetlona w konsoli po wywołaniu powyższego programu?
         * +A) 11.3
         * B) 6.11
         * C) 1.32
         * D) 0.43
         * */
//with idiom

    class Box {
        private double height;

        public Box(double height) {
            this.height = height;
        }
        public double getHeight() {
            return height;
        }
    }
    public class Main {
        public static void main(String[] args) {
            List<Box> boxes = new LinkedList<>();
            boxes.add(new Box(0.43));
            boxes.add(new Box(4.11));
            boxes.add(new Box(1.32));
            boxes.add(new Box(1.73));
            boxes.add(new Box(6.11));
            boxes.add(new Box(11.3));
            boxes.add(new Box(4.99));
            boxes.add(new Box(3.43));

            Optional<Box> box = boxes.stream().
                    collect(Collectors.maxBy(Comparator.comparing(Box::getHeight)));
            System.out.print(box.get().getHeight());
        }
    }

        /*
        * Jaka wartość zostanie wyświetlona w konsoli po wywołaniu powyższego programu?
        * +A) 11.3
        * B) 6.11
        * C) 1.32
        * D) 0.43
        * */
