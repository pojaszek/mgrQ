package q7;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by user on 18-May-15.
 */

//2.3.2.5.	Iterowanie po elementach kolekcji
//without idiom

     class Main2 {
        public static void reverseTitle(Book book) {
            book.setName(new StringBuffer(book.getName()).reverse().toString());
        }
        public static void main(String[] args) {
            List<Book> books = new LinkedList<>();
            books.add(new Book("Maybe Someday"));
            books.add(new Book("Następczyni"));
            books.add(new Book("Hopeless"));
            books.add(new Book("Gra o tron"));
            books.add(new Book("Eleonora i Park"));
            books.add(new Book("Gwiazd naszych wina"));

            for (Book book : books) {
                reverseTitle(book);
            }
            for (Book book : books) {
                System.out.print(book.getName() + " ");
            }
        }
    }


            /*
        * Jaka wartość zostanie wyświetlona w konsoli po wywołaniu powyższego programu?
        * A) yademoS ebyaMinyzcpętsaNsselepoHnort o arGkraP i aronoelEaniw hcyzsan dzaiwG
        * B) aniw hcyzsan dzaiwG kraP i aronoelE nort o arG sselepoH inyzcpętsaN yademoS ebyaM
        * C) Maybe Someday Następczyni Hopeless Gra o tron Eleonora i Park Gwiazd naszych wina
        * +D) yademoS ebyaM inyzcpętsaN sselepoH nort o arG kraP i aronoelE aniw hcyzsan dzaiwG
        * */
//with idiom

    class Book {
        private String name;

        public Book(String name) {
            this.name = name;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
    }
    public class Main {
        public static void reverseTitle(Book book) {
            book.setName(new StringBuffer(book.getName()).reverse().toString());
        }
        public static void main(String[] args) {
            List<Book> books = new LinkedList<>();
            books.add(new Book("Maybe Someday"));
            books.add(new Book("Następczyni"));
            books.add(new Book("Hopeless"));
            books.add(new Book("Gra o tron"));
            books.add(new Book("Eleonora i Park"));
            books.add(new Book("Gwiazd naszych wina"));

            books.forEach(book -> reverseTitle(book));
            books.forEach(book -> System.out.print(book.getName() + " "));
        }
    }


      /*
        * Jaka wartość zostanie wyświetlona w konsoli po wywołaniu powyższego programu?
        * A) yademoS ebyaMinyzcpętsaNsselepoHnort o arGkraP i aronoelEaniw hcyzsan dzaiwG
        * B) aniw hcyzsan dzaiwG kraP i aronoelE nort o arG sselepoH inyzcpętsaN yademoS ebyaM
        * C) Maybe Someday Następczyni Hopeless Gra o tron Eleonora i Park Gwiazd naszych wina
        * +D) yademoS ebyaM inyzcpętsaN sselepoH nort o arG kraP i aronoelE aniw hcyzsan dzaiwG
        * */
