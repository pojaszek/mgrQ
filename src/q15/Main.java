package q15;

import java.util.*;

/**
 * Created by user on 20-May-15.
 */
//2.3.2.5.	Iterowanie po elementach kolekcji
//without idiom

     class Main2 {
        public static void main(String[] args) {
            Map<String, List<Dealer>> map = new TreeMap<>();
            List<Dealer> dealers = new LinkedList<>();
            List<Dealer> dealers2 = new LinkedList<>();
            List<Dealer> dealers3 = new LinkedList<>();
            dealers.add(new Dealer("name1", 444444444));
            dealers.add(new Dealer("name2", 666666666));
            dealers.add(new Dealer("name3", 222222222));
            dealers2.add(new Dealer("name4", 555555555));
            dealers3.add(new Dealer("name5", 111111111));
            dealers3.add(new Dealer("name6", 333333333));

            map.put("key", dealers3);
            map.put("key2", dealers3);
            map.put("key3", dealers2);
            map.put("key4", dealers);
            for (List<Dealer> dealerList : map.values()) {
                for (Dealer dealer : dealerList) {
                    System.out.print(dealer.getMobile() + " ");
                }
            }
        }
    }


    /*
* Jaka wartość zostanie wyświetlona w konsoli po wywołaniu powyższego programu?
* A) 444444444 666666666 222222222 555555555 111111111 333333333
* B) 111111111 333333333 555555555 444444444 666666666 222222222
* +C) 111111111 333333333 111111111 333333333 555555555 444444444 666666666 222222222
* D) name5 name6 name4 name1 name2 name3
* */

 //with idiom

    class Dealer {
        private String name;
        private int mobile;

        public Dealer(String name, int mobile) {
            this.name = name;
            this.mobile = mobile;
        }
        public int getMobile() {
            return mobile;
        }
        public String getName() {
            return name;
        }
    }
    public class Main {
        public static void main(String[] args) {
            Map<String, List<Dealer>> map  = new TreeMap<>();
            List<Dealer> dealers = new LinkedList<>();
            List<Dealer> dealers2 = new LinkedList<>();
            List<Dealer> dealers3 = new LinkedList<>();
            dealers.add(new Dealer("name1", 444444444));
            dealers.add(new Dealer("name2", 666666666));
            dealers.add(new Dealer("name3", 222222222));
            dealers2.add(new Dealer("name4", 555555555));
            dealers3.add(new Dealer("name5", 111111111));
            dealers3.add(new Dealer("name6", 333333333));

            map.put("key", dealers3);
            map.put("key2", dealers3);
            map.put("key3", dealers2);
            map.put("key4", dealers);
            map.values().forEach(x -> x.stream().forEach(
                    y -> System.out.print(y.getMobile() + " ")));
        }
    }


/*



        * Jaka wartość zostanie wyświetlona w konsoli po wywołaniu powyższego programu?
        * A) 444444444 666666666 222222222 555555555 111111111 333333333
        * B) 111111111 333333333 555555555 444444444 666666666 222222222
        * +C) 111111111 333333333 111111111 333333333 555555555 444444444 666666666 222222222
        * D) name5 name6 name4 name1 name2 name3
        * */