package q9IDOM;

import java.util.Optional;

/**
 * Created by user on 18-May-15.
 */
public class Engine {
    private Optional<Model> model;

    public Engine(Optional<Model> model) {
        this.model = model;
    }

    public Optional<Model> getModel() {
        return model;
    }
}
