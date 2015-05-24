package q17;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by user on 20-May-15.
 */

//2.3.2.1.	Przetwarzanie danych z wykorzystaniem strumieni w celu filtrowania, sortowania i mapowania jej elementów
//2.3.3.1.	Opakowywanie obiektów w obiekt typu Optional<T>, jako lepsza alternatywa obsługi niezainicjalizowanych zmiennych

//with idiom

     class Main2 {
        public static void main(String[] args) {
            List<String> myFavouriteNames = new LinkedList<>();
            myFavouriteNames.add("Tomek");
            myFavouriteNames.add("Marek");
            myFavouriteNames.add("Janusz");
            myFavouriteNames.add("Kuba");
            myFavouriteNames.add("Radek");
            myFavouriteNames.add("Damian");

            System.out.print(myFavouriteNames.stream()
                    .map(x -> x.toLowerCase())
                    .filter(x -> x.startsWith("K"))
                    .findFirst());
        }
    }

            /*
        * Jaka wartość zostanie wyświetlona w konsoli po wywołaniu powyższego programu?
        * +A) Optional.empty
        * B) null
        * C) Kuba
        * D) kuba
        * */

//without idiom

    public class Main {
        public static void main(String[] args) {
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
        }
    }

        /*
        * Jaka wartość zostanie wyświetlona w konsoli po wywołaniu powyższego programu?
        * A) Optional.empty
        * +B) null
        * C) Kuba
        * D) kuba
        * */
