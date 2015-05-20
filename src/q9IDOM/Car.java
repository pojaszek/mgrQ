package q9IDOM;

import q9IDOM.Engine;

import java.util.Optional;

/**
 * Created by user on 18-May-15.
 */
public class Car {
    private Optional<Engine> engine;

    public Car(Optional<Engine> engine) {
        this.engine = engine;
    }

    public Optional<Engine> getEngine() {
        return engine;
    }
}
