package q1;

import java.math.BigDecimal;

public class Main {
    //2.3.1.1.	Zastąpienie klasy anonimowej wyrażeniem lambda

    public static void main2(String[] args) {
        //without idiom
        final BigDecimal money = BigDecimal.valueOf(2500.40);
        final BigDecimal money2 = BigDecimal.valueOf(5500.40);
        final BankingProduct mutualFunds = new BankingProduct() {
            @Override
            public BigDecimal getProfil(BigDecimal money) {
                return money.multiply(BigDecimal.valueOf(0.20));
            }
        };
        final BigDecimal profit = getProfit(mutualFunds, money2);
        System.out.print(profit);
        /*
        * Jaka wartość zostanie wyświetlona w konsoli po wywołaniu powyższego programu?
        * +A) 1100.08
        * B) 1250.20
        * C) 5500.40
        * D) 5500.60
        * */
    }

    public static void main(String[] args) {
        //with idiom
        final BigDecimal money = BigDecimal.valueOf(2500.40);
        final BigDecimal money2 = BigDecimal.valueOf(5500.40);
        final BigDecimal profit = getProfit(inputMoney -> money.multiply(BigDecimal.valueOf(0.50)), money2);
        System.out.print(profit);
        /*
        * Jaka wartość zostanie wyświetlona w konsoli po wywołaniu powyższego programu?
        * A) 2500.90
        * B) 2750.20
        * +C) 1250.20
        * D) 5500.40
        * */
        //1250.20
    }

    public static BigDecimal getProfit(BankingProduct bankingProduct, BigDecimal money) {
        return bankingProduct.getProfil(money);
    }
}
