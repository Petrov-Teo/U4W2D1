package esercizio2.entities;

import esercizio2.exceptions.KmPerLitroException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KmpercorsiClass {
    public static Logger logger = LoggerFactory.getLogger(KmpercorsiClass.class);
    double km;
    double litriCarburante;

    public KmpercorsiClass(double km, double litriCarburante) {
        this.km = km;
        this.litriCarburante = litriCarburante;

    }

    public double getLitriCarburante() {
        return litriCarburante;
    }

    public void setLitriCarburante(double litriCarburante) throws KmPerLitroException {
        if (litriCarburante == 0) throw new KmPerLitroException(litriCarburante);
        this.litriCarburante = litriCarburante;
    }

    public double getKm() {
        return km;
    }

    public void setKm(double km) throws KmPerLitroException {
        if (km == 0) throw new KmPerLitroException(km);
        this.km = km;
    }

    public void calcoloConsumo(double km, double litriCarburante) {
        if (litriCarburante == 0) {
            throw new ArithmeticException("LA divisione non è possibile se i litri sono zero!");
        }
        {
            double consumo = this.km / this.litriCarburante;
            double consumoArrotondato = (double) Math.round(consumo * 100.0) / 100.0;
            System.out.println("Hai percorso km/lt - " + consumoArrotondato);
            logger.info("Hai percorso km/lt - " + consumoArrotondato);
        }
    }

    @Override
    public String toString() {
        return "KmpercorsiClass{" +
                "kilometri=" + km +
                ", litriCarburante=" + litriCarburante +
                '}';
    }
}
