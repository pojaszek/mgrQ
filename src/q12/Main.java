package q12;

import java.util.function.Function;

/**
 * Created by user on 19-May-15.
 */
public class Main {

    //2.3.3.3.	Wykorzystanie referencji do konstruktora
    public static void main(String[] args) {
        //without idiom
        final Speaker speaker = new Speaker(120);
        int volume = increaseVolume(speaker);
        System.out.println(volume);
        int volume2 = increaseVolume(speaker);
        System.out.println(volume2);

        /*
        * Jaka wartość zostanie wyświetlona w konsoli po wywołaniu powyższego programu?
        * A) 120
        *    130
        * B) 120
        *    120
        * C) 130
        *    130
        * +D) 130
        *     140
        * */

    }

    public static void main2(String[] args) {
        //with idiom
        final Function<Integer, Speaker> speaker = Speaker::new;
        int volume = increaseVolume(speaker.apply(120));
        System.out.println(volume);
        int volume2 = increaseVolume(speaker.apply(120));
        System.out.println(volume2);

        /*
        * Jaka wartość zostanie wyświetlona w konsoli po wywołaniu powyższego programu?
        * A) 120
        *    130
        * B) 120
        *    120
        * +C) 130
        *     130
        * D) 130
        *    140
        * */
    }

    public static int increaseVolume(Speaker speaker) {
        speaker.setVolume(speaker.getVolume() + 10);
        return speaker.getVolume();
    }


}
