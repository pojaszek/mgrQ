package q4;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by user on 18-May-15.
 */
public class Main {

    //2.3.2.1.	Przetwarzanie danych z wykorzystaniem strumieni w celu filtrowania, sortowania i mapowania jej elementów
    //2.3.3.2.	Referencje do metod
    public static void main2(String[] args) {
        //without idiom
        List<Operation> operations = new LinkedList<>();
        operations.add(new Operation("sell ALIOR BANK", 313.0, 2));
        operations.add(new Operation("sell ASSECO POLAND", 534.7, 1));
        operations.add(new Operation("buy BOGDANKA", 11.5, 0));
        operations.add(new Operation("sell BOGDANKA", 111.6, 1));
        operations.add(new Operation("buy ENEA", 756.4, 1));
        operations.add(new Operation("sell ENERGA", 43242.43, 2));
        operations.add(new Operation("buy ORANGE POLSKA", 657.6, 2));
        operations.add(new Operation("sell PEKAO", 342.4, 2));
        operations.add(new Operation("sell PKN ORLEN", 3123.4, 0));

        List<Operation> operationsAboveThousand = new LinkedList<>();
        for(Operation operation : operations) {
            if(operation.getValue() > 1000) {
                operationsAboveThousand.add(operation);
            }
        }
        Collections.sort(operationsAboveThousand, new Comparator<Operation>() {
            @Override
            public int compare(Operation o1, Operation o2) {
                return Integer.compare(o1.getPrority(), o2.getPrority());
            }
        });
        List<OperationDTO> operationDTOs = new LinkedList<>();
        for(Operation operation : operationsAboveThousand) {
            operationDTOs.add(new OperationDTO(operation.getName()));
        }
        for(OperationDTO operationDTO : operationDTOs) {
            System.out.println(operationDTO);
        }
        /*
        * Jaka wartość zostanie wyświetlona w konsoli po wywołaniu powyższego programu?
        * A) OperationDTO{name='sell ENERGA'}
        * B) OperationDTO{name='null'}
        *    OperationDTO{name='null'}
        * +C) OperationDTO{name='sell PKN ORLEN'}
              OperationDTO{name='sell ENERGA'}
        * D) OperationDTO{name='sell PKN ORLEN'}
        * */
    }


    public static void main(String[] args) {
        //with idiom
        List<Operation> operations = new LinkedList<>();
        operations.add(new Operation("sell ALIOR BANK", 313.0, 2));
        operations.add(new Operation("sell ASSECO POLAND", 534.7, 1));
        operations.add(new Operation("buy BOGDANKA", 11.5, 0));
        operations.add(new Operation("sell BOGDANKA", 111.6, 1));
        operations.add(new Operation("buy ENEA", 756.4, 1));
        operations.add(new Operation("sell ENERGA", 43242.43, 2));
        operations.add(new Operation("buy ORANGE POLSKA", 657.6, 2));
        operations.add(new Operation("sell PEKAO", 342.4, 2));
        operations.add(new Operation("sell PKN ORLEN", 3123.4, 0));

        List<OperationDTO> operationDTOs =
                operations.stream()
                            .filter(operation -> operation.getValue() > 1000)
                            .sorted(Comparator.comparing(Operation::getPrority))
                            .map(operation -> new OperationDTO(operation.getName()))
                            .collect(Collectors.toList());

        for(OperationDTO operationDTO : operationDTOs) {
            System.out.println(operationDTO);
        }

        /*
        * Jaka wartość zostanie wyświetlona w konsoli po wywołaniu powyższego programu?
        * A) OperationDTO{name='sell ENERGA'}
        * B) OperationDTO{name='null'}
        *    OperationDTO{name='null'}
        * +C) OperationDTO{name='sell PKN ORLEN'}
              OperationDTO{name='sell ENERGA'}
        * D) OperationDTO{name='sell PKN ORLEN'}
        * */
    }
}
