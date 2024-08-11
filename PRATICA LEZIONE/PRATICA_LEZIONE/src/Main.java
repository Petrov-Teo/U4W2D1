import entities.User;
import exceptions.StringNotValidException;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        //   print("Hello world!");
        //-----------------------------------ERRORI----------------------------------------------------

   /* public static void print(String str) {
        print(str); //<-- StackOverFlowError  = immagina una pila di piatti
    }
    codice corretto :
    public static void print (String str){
        System.out.println(str);
    }
    */
        //-----------------------------------ERRORI UNCHECKED------------------------------------------
        int[] numbers = {1, 2, 3, 4, 5};
        int index = 5;
        if (index > 4 || index < 0) {
            System.out.println("Ci spiace ma, l'indice da te cercato non esiste");
        } else {
            System.out.println(numbers[index]);
        }

        String nome = null;
        if (nome != null) {
            System.out.println(nome);
        } else {
            System.out.println("Oggetto è Inesistente");
        }
        int numero1 = 5;
        int numero2 = 0;
        if (numero2 != 0) {
            System.out.println(numero1 / numero2);
        } else {
            System.out.println("La divisione non può essere effettuata, uno dei due numeri è 0");
        }

        //-----------------------------------ECCEZIONI CHECKED------------------------------------------
        // Sono obbligato a gestire gli errori in quanto non potremmo eseguire l'applicazione
        /*try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("C'è stato un problema!");
        }*/
        //-----------------------------------ECCEZIONI CUSTOM------------------------------------------
        // throw new NumberLessThanZeroException(-20); <–– si lancia l'eccezione personalizzata!

        User aldo = new User("Rossi", "Aldo");
        try {
            aldo.setNome("A");
        } catch (StringNotValidException e) {
            System.out.println(e);

        }
        System.out.println(aldo);

        //----------------------------------- TRY-CATCH ------------------------------------------
        User giovanni = new User("Santeri", "Giovani");
        try {
            giovanni.setNome("G");
        } catch (StringNotValidException |
                 ArithmeticException e) { // <-- catch multi- eccezione serve per gestire duo o pù tipi di eccezioni alla stessa maniera
            System.out.println(e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("Null pointer exception");
        } catch (Exception e) {
            System.out.println("C'e stato un errore generico!");
        }
        // Fare più catch mi permette di gestire errori di tipologia diversa
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci un numero da 1 a 4 ");
        int[] num = {0, 1, 2, 3, 4};
        int i = scanner.nextInt();
        try {
            System.out.println(5 / num[i]);
        } catch (Exception e) { // Questo è un catch polimorfico, mi consente di catchare tutti i tipi di errori
            System.out.println("Il numero inserto deve essere tra 1 e 4." + " " + "Il numero inserto è" + " " + i + "!");
        } finally { // Serve per far eseguire un determinato codice sia se siamo finiti nel try oppure nel catch
            scanner.close();
        }
    }

}

