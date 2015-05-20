package q9IDOM;

import java.util.Optional;

/**
 * Created by user on 18-May-15.
 */
public class Main {
    //2.3.3.1.	Opakowywanie obiektów w obiekt typu Optional<T>, jako lepsza alternatywa obsługi niezainicjalizowanych zmiennych
    public static void main(String[] args) {
        //with idiom
        Model model1 = new Model("fast");
        Model model2 = new Model("normal");

        Engine engine1 = new Engine(Optional.of(model1));
        Engine engine2 = new Engine(Optional.empty());
        Engine engine3 = new Engine(Optional.of(model2));

        Car car1 = new Car(Optional.of(engine1));
        Car car2 = new Car(Optional.of(engine2));
        Car car3 = new Car(Optional.of(engine3));

        printCarEngineModel(car1);
        printCarEngineModel(car2);
        printCarEngineModel(car3);
        /*
        * Jaka wartość zostanie wyświetlona w konsoli po wywołaniu powyższego programu?
        * +A) fastnormal
        * B) null null
        * C) fast normal
        * D) fast + Program zostanie przerwany przez NullPointer exception
        * */
    }

    private static void printCarEngineModel(Car car) {
        if(car ==null) {
            return;
        }
        if(!car.getEngine().isPresent()) {
            return;
        }
        if(!car.getEngine().get().getModel().isPresent()) {
            return;
        }
        System.out.print(car.getEngine().get().getModel().get().getName());
    }
}
