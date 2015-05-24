package q9;

/**
 * Created by user on 18-May-15.
 */
//2.3.3.1.	Opakowywanie obiektów w obiekt typu Optional<T>, jako lepsza alternatywa obsługi niezainicjalizowanych zmiennych
//without idiom

    class Model {
        private String name;

        public Model(String name) {
            this.name = name;
        }
        public String getName() {
            return name;
        }
    }
    class Engine {
        private Model model;

        public Engine(Model model) {
            this.model = model;
        }
        public Model getModel() {
            return model;
        }
    }
    class Car {
        private Engine engine;

        public Car(Engine engine) {
            this.engine = engine;
        }
        public Engine getEngine() {
            return engine;
        }
    }

    public class Main {
        public static void main(String[] args) {
            Model model1 = new Model("fast");
            Model model2 = new Model("normal");
            Engine engine1 = new Engine(model1);
            Engine engine2 = new Engine(null);
            Engine engine3 = new Engine(model2);
            Car car1 = new Car(engine1);
            Car car2 = new Car(engine2);
            Car car3 = new Car(engine3);
            printCarEngineModel(car1);
            printCarEngineModel(car2);
            printCarEngineModel(car3);
        }
        private static void printCarEngineModel(Car car) {
            if(car ==null) {
                return;
            }
            if(car.getEngine() == null) {
                return;
            }
            if(car.getEngine().getModel() == null) {
                return;
            }
            System.out.print(car.getEngine().getModel().getName());
        }
    }


        /*
        * Jaka wartość zostanie wyświetlona w konsoli po wywołaniu powyższego programu?
        * +A) fastnormal
        * B) null null
        * C) fast normal
        * D) fast + Program zostanie przerwany przez NullPointer exception
        * */