package esercizio2.exceptions;

public class KmPerLitroException extends Exception {

    public KmPerLitroException(double kmOlt) {
        super("il valore di: " + kmOlt + "non puo essere 0,00");
    }

}
