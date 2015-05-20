package q14;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by user on 19-May-15.
 */
public class Main {

    //2.3.3.1.	Opakowywanie obiektów w obiekt typu Optional<T>, jako lepsza alternatywa obsługi niezainicjalizowanych zmiennych
    public static void main2(String[] args) {
        //with idiom
        List<Bottle> bottles = new LinkedList<>();
        bottles.add(new Bottle(null));
        bottles.add(new Bottle(2.3));
        bottles.add(new Bottle(1.8));
        bottles.add(new Bottle(6.3));
        bottles.add(new Bottle(5.5));
        bottles.add(new Bottle(null));
        bottles.add(new Bottle(6.1));

        List<Optional<Double>> volumes = new LinkedList<>();
        for(Bottle bottle : bottles) {
            volumes.add(bottle.getVolume());
        }

        List<Double> finalVolumes = volumes.stream().
                filter(x -> x.isPresent()).
                map(x -> x.get()).
                collect(Collectors.toList());
        System.out.print(finalVolumes.size());
        /*
        * Jaka wartość zostanie wyświetlona w konsoli po wywołaniu powyższego programu?
        * A) 1
        * B) 3
        * C) 4
        * +D) 5
        * */
    }


    public static void main(String[] args) {
        //without idiom
        List<Bottle> bottles = new LinkedList<>();
        bottles.add(new Bottle(null));
        bottles.add(new Bottle(2.3));
        bottles.add(new Bottle(1.8));
        bottles.add(new Bottle(6.3));
        bottles.add(new Bottle(5.5));
        bottles.add(new Bottle(null));
        bottles.add(new Bottle(6.1));

        List<Optional<Double>> volumes = new LinkedList<>();
        for(Bottle bottle : bottles) {
            volumes.add(bottle.getVolume());
        }

        List<Double> finalVolumes = new LinkedList<>();
        for(Optional<Double> value : volumes) {
            if(value.isPresent()) {
                finalVolumes.add(value.get());
            }
        }
        System.out.print(finalVolumes.size());
        /*
        * Jaka wartość zostanie wyświetlona w konsoli po wywołaniu powyższego programu?
        * A) 1
        * B) 3
        * C) 4
        * +D) 5
        * */
    }
}
