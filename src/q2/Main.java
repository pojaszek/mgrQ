package q2;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by user on 18-May-15.
 */

//2.3.1.2.	Wykorzystanie wyrażeń lambda wraz z interfejsami funkcjonalnymi pochodzącymi z pakietu java.util.function, tj. Predicate, Consumer, Function, Supplier i Operator.
//without idiom


     class Main2 {
        public static void main(String[] args) {
            List<Car> cars = new LinkedList<>();
            cars.add(new Car(Color.BLACK, 3.5));
            cars.add(new Car(Color.BLACK, 1.1));
            cars.add(new Car(Color.GREEN, 2.1));
            cars.add(new Car(Color.YELLOW, 1.6));
            cars.add(new Car(Color.BLACK, 1.5));
            cars.add(new Car(Color.GREEN, 1.22));
            cars.add(new Car(Color.YELLOW, 0.97));

            long count = 0;
            for (Car car : cars) {
                if (car.getEngineCapacity() <= 1.5 && car.getColor() != Color.BLACK) {
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

    class Car {
        private Color color;
        private double engineCapacity;

        public Car(Color color, double engineCapacity) {
            this.color = color;
            this.engineCapacity = engineCapacity;
        }
        public Color getColor() {
            return color;
        }
        public double getEngineCapacity() {
            return engineCapacity;
        }
    }
    enum Color {
        BLACK, GREEN, YELLOW
    }
    public class Main {
        public static void main(String[] args) {
            List<Car> cars = new LinkedList<>();
            cars.add(new Car(Color.BLACK, 3.5));
            cars.add(new Car(Color.BLACK, 1.1));
            cars.add(new Car(Color.GREEN, 2.1));
            cars.add(new Car(Color.YELLOW, 1.6));
            cars.add(new Car(Color.BLACK, 1.5));
            cars.add(new Car(Color.GREEN, 1.22));
            cars.add(new Car(Color.YELLOW, 0.97));

            long count = cars.stream().filter(
                 car -> car.getEngineCapacity() <= 1.5 && car.getColor() != Color.BLACK).count();
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
