package q19;

/**
 * Created by user on 21-May-15.
 */
public class Main {

    //2.3.1.1.	Zastąpienie klasy anonimowej wyrażeniem lambda
    interface SimpleAuthorization {
        void authorize();
    }
    interface TokenAuthorization {
        void authorize(String token);
    }
    interface PhoneAuthorization {
        void authorize(String token, String mobile);
    }
    public static void main(String[] args) {
        //with idiom
        authorize(() -> System.out.print("nothing"));
        authorize((token) -> System.out.print(token));
        authorize((token, phone) -> System.out.print(token + " " + phone));
         /*
        * Jaki wynik zostanie wypisany na konsoli po wywołaniu powyższego programu?
        * A) nothingnothingnothing
        * B) W trakcie wykonywania programu zostanie rzucony wyjątek IllegalArgumentException
        * C) wer4cr134tv3wer4cr134tv3vsdfbrgtdyu6 565654345
        * +D) nothingwer4cr134tv3vsdfbrgtdyu6 565654345
        * */
    }

    public static void main2(String[] args) {
        //without idiom
        authorize(new SimpleAuthorization() {
            @Override
            public void authorize() {
                System.out.print("nothing");
            }
        });
        authorize(new TokenAuthorization() {
            @Override
            public void authorize(String token) {
                System.out.print(token);
            }
        });
        authorize(new PhoneAuthorization() {
            @Override
            public void authorize(String token, String mobile) {
                System.out.print(token + " " + mobile);
            }
        });
        /*
        * Jaki wynik zostanie wypisany na konsoli po wywołaniu powyższego programu?
        * A) nothingnothingnothing
        * B) W trakcie wykonywania programu zostanie rzucony wyjątek IllegalArgumentException
        * C) wer4cr134tv3wer4cr134tv3vsdfbrgtdyu6 565654345
        * +D) nothingwer4cr134tv3vsdfbrgtdyu6 565654345
        * */
    }

    public static void authorize(SimpleAuthorization auth) {
        auth.authorize();
    }
    public static void authorize(TokenAuthorization auth) {
        auth.authorize("wer4cr134tv3");
    }
    public static void authorize(PhoneAuthorization auth) {
        auth.authorize("vsdfbrgtdyu6", "565654345");
    }
}
