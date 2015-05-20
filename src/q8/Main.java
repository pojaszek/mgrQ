package q8;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by user on 18-May-15.
 */
public class Main {

    //2.3.2.6.	Agregowanie danych za pomocą strumieni, metoda reduce()
    public static void main(String[] args) {
        //without idiom
        List<Stock> stockList = new LinkedList<>();
        stockList.add(new Stock("ALIOR BANK", 100));
        stockList.add(new Stock("ASSECO POLAND", 300));
        stockList.add(new Stock("BOGDANKA", 200));
        stockList.add(new Stock("ENEA", 100));
        stockList.add(new Stock("PEKAO", 50));
        stockList.add(new Stock("PKN ORLEN", 40));

        double value = 0.0;
        for(Stock stock : stockList) {
            value += stock.getPrice();
        }
        System.out.print(value);
        /*
        * Jaka wartość zostanie wyświetlona w konsoli po wywołaniu powyższego programu?
        * A) 40.0
        * +B) 790.0
        * C) 40
        * D) 0.0
        * */
    }

    public static void main2(String[] args) {
        //with idiom
        List<Stock> stockList = new LinkedList<>();
        stockList.add(new Stock("ALIOR BANK", 100));
        stockList.add(new Stock("ASSECO POLAND", 300));
        stockList.add(new Stock("BOGDANKA", 200));
        stockList.add(new Stock("ENEA", 100));
        stockList.add(new Stock("PEKAO", 50));
        stockList.add(new Stock("PKN ORLEN", 40));

        double value = stockList.stream().map(x -> x.getPrice()).reduce(0, (x,y) -> {return x + y;});
        System.out.print(value);
        /*
        * Jaka wartość zostanie wyświetlona w konsoli po wywołaniu powyższego programu?
        * A) 40.0
        * +B) 790.0
        * C) 40
        * D) 0.0
        * */
    }
}
