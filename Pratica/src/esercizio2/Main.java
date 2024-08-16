package esercizio2;

import esercizio2.entities.KmpercorsiClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;


public class Main {
    public static Logger logger = LoggerFactory.getLogger(esercizio1.Main.class);

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Inserisci il numero di chilometri percorsi!");
            double kmAuto1 = scanner.nextDouble();

            System.out.println("Inserisci il numero di litri di carburante!");
            double ltCarburanteAuto1 = scanner.nextDouble();

            KmpercorsiClass auto1 = new KmpercorsiClass(kmAuto1, ltCarburanteAuto1);
            auto1.calcoloConsumo(kmAuto1, ltCarburanteAuto1);
        } catch (Exception e) {
            logger.error("Errore generico");
        }

    }
}
