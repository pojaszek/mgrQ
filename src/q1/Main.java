package q1;

import java.math.BigDecimal;

public class Main {
    //2.3.1.1.	Zastąpienie klasy anonimowej wyrażeniem lambda

    public static void main(String[] args) {
        //without idiom
        BigDecimal value = BigDecimal.valueOf(5500.40);
        BigDecimal value2 = BigDecimal.valueOf(3300.70);
        final BankingProduct mutualFunds = new BankingProduct() {
            @Override
            public BigDecimal computeEarnings(BigDecimal inputValue) {
                return value.multiply(BigDecimal.valueOf(0.20));
            }
        };
        final BigDecimal profit = computeTotalValueIncludingEarnings(mutualFunds, value2);
        System.out.print(profit);
        /*
        * Jaka wartość zostanie wyświetlona w konsoli po wywołaniu powyższego programu?
        * A) 660.14
        * B) 6600.48
        * C) 3960.84
        * +D) 4400.78
        * */
    }

    public static void main2(String[] args) {
        //with idiom
        final BigDecimal value = BigDecimal.valueOf(5500.40);
        final BigDecimal value2 = BigDecimal.valueOf(3300.70);
        final BigDecimal profit = computeTotalValueIncludingEarnings(inputValue -> value.multiply(BigDecimal.valueOf(0.20)), value2);
        System.out.print(profit);
       /*
        * Jaka wartość zostanie wyświetlona w konsoli po wywołaniu powyższego programu?
        * A) 660.14
        * B) 6600.48
        * C) 3960.84
        * +D) 4400.78
        * */
    }

    public static BigDecimal computeTotalValueIncludingEarnings(BankingProduct bankingProduct, BigDecimal value) {
        return value.add(bankingProduct.computeEarnings(value));
    }
}
