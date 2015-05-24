package q19;

/**
 * Created by user on 21-May-15.
 */
//Nieopisane w pracy - do dopisania
//Nowe API, które pojawiło się w klasie String: statyczna metoda join w String.class i metoda chars() zwracająca strumień danych typu char
//Podchwytliwe pytanie, dane typu char w strumieniu uznawane są jako int, stąd odpowiedz A
//with idiom


    class Main2 {
        public static void main(String[] args) {
            String uri = String.join("/", "api", "v1", "books", "5");
            uri.chars()
                    .forEach(c -> System.out.print(String.valueOf(c)));
            System.out.print(" ");
            System.out.print(uri);
        }
    }

         /*
        * Jaki wynik zostanie wypisany na konsoli po wywołaniu powyższego programu?
        * +A) 97112105471184947981111111071154753 api/v1/books/5
        * B) api/v1/books/5 api/v1/books/5
        * C) /api/v1/books/5/ api/v1/books/5
        * D) /api/v1/books/5/ /api/v1/books/5/
        * */

 //without

    public class Main {
        public static void main(String[] args) {
            String uri =  "api" + "/" + "v1" + "/" + "books" + "/" + "5";
            for(char c : uri.toCharArray()) {
                System.out.print(String.valueOf(c));
            }
            System.out.print(" ");
            System.out.print(uri);
        }
    }


        /*
        * Jaki wynik zostanie wypisany na konsoli po wywołaniu powyższego programu?
        * A) 97112105471184947981111111071154753 api/v1/books/5
        * +B) api/v1/books/5 api/v1/books/5
        * C) /api/v1/books/5/ api/v1/books/5
        * D) /api/v1/books/5/ /api/v1/books/5/
        * */