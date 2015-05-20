package q12;

import java.util.function.Function;

/**
 * Created by user on 19-May-15.
 */
public class Main {

    //2.3.3.3.	Wykorzystanie referencji do konstruktora
    public static void main2(String[] args) {
        //without idiom
        final Speaker speaker = new Speaker(120);
        System.out.print(speaker);

        /*
        * Jaka wartość zostanie wyświetlona w konsoli po wywołaniu powyższego programu?
        * +A) Speaker{brand='null', power=120}
        * B) Speaker{brand='', power=120}
        * C) 120
        * D) Speaker{power=120}
        * */
    }

    public static void main(String[] args) {
        //with idiom
        final Function<Integer, Speaker> speaker = Speaker::new;
        System.out.print(speaker.apply(120));
         /*
        * Jaka wartość zostanie wyświetlona w konsoli po wywołaniu powyższego programu?
        * +A) Speaker{brand='null', power=120}
        * B) Speaker{brand='', power=120}
        * C) 120
        * D) Speaker{power=120}
        * */
    }
}
