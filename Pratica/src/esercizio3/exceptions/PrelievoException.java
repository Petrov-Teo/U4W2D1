package esercizio3.exceptions;


public class PrelievoException extends Exception {
    public PrelievoException(String str) {
        super("il prelievo non è possible, credito disponibile:" + str);
    }

}