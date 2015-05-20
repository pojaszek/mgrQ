package q18;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/**
 * Created by user on 20-May-15.
 */
public class Main {
    //2.3.2.1.	Przetwarzanie danych z wykorzystaniem strumieni w celu filtrowania, sortowania i mapowania jej elementów
    //2.3.3.1.	Opakowywanie obiektów w obiekt typu Optional<T>, jako lepsza alternatywa obsługi niezainicjalizowanych zmiennych
    public static void main2(String[] args) {
        //with idiom
        List<String> myFavouriveNames = new LinkedList<>();
        myFavouriveNames.add("Tomek");
        myFavouriveNames.add("Marek");
        myFavouriveNames.add("Janusz");
        myFavouriveNames.add("Kuba");
        myFavouriveNames.add("Radek");
        myFavouriveNames.add("Damian");

        System.out.print(myFavouriveNames.stream()
                .map(x -> x.toLowerCase())
                .filter(x -> x.startsWith("K"))
                .findFirst());
        /*
        * Jaka wartość zostanie wyświetlona w konsoli po wywołaniu powyższego programu?
        * +A) Optional.empty
        * B) null
        * C) Kuba
        * D) kuba
        * */
    }


    public static void main(String[] args) {
        //without idiom
        List<String> myFavouriteNames = new LinkedList<>();
        myFavouriteNames.add("Tomek");
        myFavouriteNames.add("Marek");
        myFavouriteNames.add("Janusz");
        myFavouriteNames.add("Kuba");
        myFavouriteNames.add("Radek");
        myFavouriteNames.add("Damian");

        List<String> myFavouriteLowerNames = new LinkedList<>();
        for(String name : myFavouriteNames) {
            myFavouriteLowerNames.add(name.toLowerCase());
        }
        String searchedName = null;
        for(String name : myFavouriteLowerNames) {
            if(name.startsWith("K")) {
                searchedName = name;
                break;
            }
        }
        System.out.print(searchedName);
        /*
        * Jaka wartość zostanie wyświetlona w konsoli po wywołaniu powyższego programu?
        * A) Optional.empty
        * +B) null
        * C) Kuba
        * D) kuba
        * */
    }
}
