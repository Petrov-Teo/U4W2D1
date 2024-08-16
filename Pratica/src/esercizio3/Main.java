package esercizio3;

import esercizio3.entities.ContoCorrente;
import esercizio3.exceptions.PrelievoException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ContoCorrente contoCorrente1 = new ContoCorrente("Mario", "Rossi");

        System.out.println(contoCorrente1);
        contoCorrente1.setDisponibilita(5000);
        System.out.println(contoCorrente1);

        try {
            System.out.println("DIGITA 1 PER PRELEVARE OPPURE 2 PER EFFETTUARE UN DEPOSITO");
            int scelta = scanner.nextInt();

            switch (scelta) {
                case 1 -> {

                    System.out.println("Digita l'importo da prelevare:");
                    double prelievo = scanner.nextDouble();
                    contoCorrente1.prelievoContanti(prelievo);
                    System.out.println("Prelievo effettuato. Nuova disponibilità: " + contoCorrente1.getDisponibilita());
                }
                case 2 -> {

                    System.out.println("Digita l'importo da depositare:");
                    double deposito = scanner.nextDouble();
                    contoCorrente1.setDisponibilita(contoCorrente1.getDisponibilita() + deposito);
                    System.out.println("Deposito effettuato. Nuova disponibilità: " + contoCorrente1.getDisponibilita());
                }
                default -> System.out.println("Scelta non valida. Riprovare.");
            }
        } catch (PrelievoException e) {
            System.out.println("Errore: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Errore generico! Per favore, riprova.");
        } finally {
            scanner.close();
        }
    }
}