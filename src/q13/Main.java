package q13;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 19-May-15.
 */
public class Main {

    //2.3.2.4.	Równoległe przetwarzanie danych z wykorzystaniem Stream.parallel()
    public static void main(String[] args) throws InterruptedException {
        //without idiom
        List<Integer> numbers = new ArrayList<>(100);
        for(int a=0; a < 100; ++a) {
            numbers.add(a);
        }
        List<Integer> sublist = numbers.subList(0, numbers.size()/2);
        List<Integer> sublist2 = numbers.subList(numbers.size()/2, numbers.size());

        Thread one = new Thread(new Printer(sublist));
        Thread two = new Thread(new Printer(sublist2));
        one.start();
        two.start();

        /*
        * Jakie wartości zostaną wyświetlone na konsoli po wywołaniu powyższego programu?
        * A) Liczby od 0 do 99 w kolejności rosnącej
        * B) Liczby od 0 do 99 w kolejności malejącej
        * +C) Liczby od 0 do 99, lecz nie jesteśmy wstanie przewidzieć kolejności (zależy od wersji JVM)
        * D) Zostanie rzucony wyjątek w trakcie wykonywania programu
        * */
    }

    static class Printer implements Runnable {
        Printer(List<Integer> numbers) {
            this.numbers = numbers;
        }
        List<Integer> numbers;
        @Override
        public void run() {
            for(Integer number : numbers) {
                System.out.println(number);
            }
        }
    }



    public static void main2(String[] args) {
        //with idiom
        List<Integer> numbers = new ArrayList<>(100);
        for(int a=0; a < 100; ++a) {
            numbers.add(a);
        }

        numbers.parallelStream()
               .map(x -> x.longValue())
               .forEach(System.out::println);

         /*
        * Jakie wartości zostaną wyświetlone na konsoli po wywołaniu powyższego programu?
        * A) Liczby od 0 do 99 w kolejności rosnącej
        * B) Liczby od 0 do 99 w kolejności malejącej
        * +C) Liczby od 0 do 99, lecz nie jesteśmy wstanie przewidzieć kolejności (zależy od sprzętu i wersji JVM)
        * D) Zostanie rzucony wyjątek w trakcie wykonywania programu
        * */
    }
}
