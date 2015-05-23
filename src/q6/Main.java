package q6;

import q6.Operation;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by user on 18-May-15.
 */
public class Main {

    //2.3.2.3.	Przetwarzanie danych typu String z wykorzystaniem strumieni w celu ich powiązania
    //2.3.3.2.	Referencje do metod
    public static void main(String[] args) {
        //without idiom
        List<Operation> operations = new LinkedList<>();
        operations.add(new Operation("sell ALIOR BANK"));
        operations.add(new Operation("buy BOGDANKA"));
        operations.add(new Operation("sell ENERGA"));
        operations.add(new Operation("buy ORANGE POLSKA"));
        operations.add(new Operation("sell PKN ORLEN"));

        String operationNames = "";
        for(Operation operation : operations) {
           operationNames += operation.getName() + ", ";
        }
        if(operations.size() > 0) {
            operationNames = operationNames.substring(0, operationNames.length()-2);
        }
        System.out.print(operationNames);

        /*
        * Jaka wartość zostanie wyświetlona w konsoli po wywołaniu powyższego programu?
        * A) sell ALIOR BANK, buy BOGDANKA, sell ENERGA, buy ORANGE POLSKA, sell PKN ORLEN,
        * B) sell PKN ORLEN, buy ORANGE POLSKA, sell ENERGA, buy BOGDANKA, sell ALIOR BANK,
        * C) , , , , , , , , ,
        * +D) sell ALIOR BANK, buy BOGDANKA, sell ENERGA, buy ORANGE POLSKA, sell PKN ORLEN
        * */
    }


    public static void main2(String[] args) {
        //with idiom
        List<Operation> operations = new LinkedList<>();
        operations.add(new Operation("sell ALIOR BANK"));
        operations.add(new Operation("buy BOGDANKA"));
        operations.add(new Operation("sell ENERGA"));
        operations.add(new Operation("buy ORANGE POLSKA"));
        operations.add(new Operation("sell PKN ORLEN"));

        String operationNames = operations.stream().map(Operation::getName).collect(Collectors.joining(", "));
        System.out.print(operationNames);
        /*
        * Jaka wartość zostanie wyświetlona w konsoli po wywołaniu powyższego programu?
        * A) sell ALIOR BANK, buy BOGDANKA, sell ENERGA, buy ORANGE POLSKA, sell PKN ORLEN,
        * B) sell PKN ORLEN, buy ORANGE POLSKA, sell ENERGA, buy BOGDANKA, sell ALIOR BANK,
        * C) , , , , , , , , ,
        * +D) sell ALIOR BANK, buy BOGDANKA, sell ENERGA, buy ORANGE POLSKA, sell PKN ORLEN
        * */
    }
}
