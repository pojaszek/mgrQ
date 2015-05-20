package q13;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;

/**
 * Created by user on 19-May-15.
 */
public class Main {

    //2.3.2.4.	Równoległe przetwarzanie danych z wykorzystaniem Stream.parallel()
    public static void main(String[] args) {
        //without idiom
        Random rand = new Random(1);
        List<Integer> numbers = new LinkedList<>();
        for(int a=0; a < 100000; ++a) {
            numbers.add(rand.nextInt());
        }
        ForkJoinPool forkJoinPool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
        Long number = forkJoinPool.invoke(new SubTask(numbers));
         /*
        * Co zawiera zmienna number?
        * A) Najmniejszą liczbę z listy numbers
        * B) Największą liczbę pierwszą z listy numbers
        * +C) Sumę elementów listy numbers
        * D) Największą liczbę z listy numbers
        * */
    }

    public static void main2(String[] args) {
        //with idiom
        Random rand = new Random(1);
        List<Integer> numbers = new LinkedList<>();
        for(int a=0; a < 100000; ++a) {
            numbers.add(rand.nextInt());
        }
        Long number = numbers.parallelStream()
                            .map(x -> x.longValue())
                            .reduce(0L, Long::sum);
         /*
        * Co zawiera zmienna number?
        * A) Najmniejszą liczbę z listy numbers
        * B) Największą liczbę pierwszą z listy numbers
        * +C) Sumę elementów listy numbers
        * D) Największą liczbę z listy numbers
        * */
    }
}
