package q14;

import java.util.Optional;

/**
 * Created by user on 19-May-15.
 */
public class Bottle {
    private Double volume;

    public Bottle(Double volume) {
        this.volume = volume;
    }

    public Optional<Double> getVolume() {
        return Optional.ofNullable(volume);
    }
}
