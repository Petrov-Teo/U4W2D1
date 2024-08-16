package esercizio1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int[] num = new int[5];

        // Inizializzare l'array con valori casuali tra 1 e 10
        for (int i = 0; i < num.length; i++) {
            num[i] = random.nextInt(10) + 1;
        }

        // Stampa iniziale dell'array
        printArray(num);

        while (true) {
            System.out.print("Inserisci un numero (0 per uscire): ");
            int value = scanner.nextInt();

            if (value == 0) {
                System.out.println("Programma terminato.");
                break;
            }

            System.out.print("Inserisci la posizione (0-4): ");
            int index = scanner.nextInt();

            try {
                // Inserire il valore nella posizione specificata
                num[index] = value;
                // Stampare il nuovo stato dell'array
                printArray(num);
            } catch (ArrayIndexOutOfBoundsException e) {
                // Gestire errori di posizione non valida
                logger.error("Posizione non valida: " + index, e);
            }
        }

        scanner.close();
    }

    // Stampare l'array
    private static void printArray(int[] array) {
        System.out.print("Stato dell'array: ");
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}