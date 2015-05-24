package q12;

import java.util.function.Function;

/**
 * Created by user on 19-May-15.
 */
//2.3.3.3.	Wykorzystanie referencji do konstruktora
//without


     class Main2 {
        public static void main(String[] args) {
            final Speaker speaker = new Speaker(120);
            int volume = increaseVolume(speaker);
            System.out.print(volume + " ");
            int volume2 = increaseVolume(speaker);
            System.out.print(volume2);
        }
        public static int increaseVolume(Speaker speaker) {
            speaker.setVolume(speaker.getVolume() + 10);
            return speaker.getVolume();
        }
    }


    /*
        * Jaka wartość zostanie wyświetlona w konsoli po wywołaniu powyższego programu?
        * A) 120 130
        * B) 120 120
        * C) 130 130
        * +D) 130 140
        * */

//with idiom


    class Speaker {
        private int volume;

        public Speaker(int volume) {
            this.volume = volume;
        }
        public int getVolume() {
            return volume;
        }
        public void setVolume(int volume) {
            this.volume = volume;
        }
    }
    public class Main {
        public static void main(String[] args) {
            final Function<Integer, Speaker> speaker = Speaker::new;
            int volume = increaseVolume(speaker.apply(120));
            System.out.print(volume + " ");
            int volume2 = increaseVolume(speaker.apply(120));
            System.out.print(volume2);
        }
        public static int increaseVolume(Speaker speaker) {
            speaker.setVolume(speaker.getVolume() + 10);
            return speaker.getVolume();
        }
    }

        /*
        * Jaka wartość zostanie wyświetlona w konsoli po wywołaniu powyższego programu?
        * A) 120 130
        * B) 120 120
        * +C) 130 130
        * D) 130 140
        * */
