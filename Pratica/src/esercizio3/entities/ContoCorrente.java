package esercizio3.entities;

import esercizio3.exceptions.PrelievoException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

public class ContoCorrente {
    public static Logger logger = LoggerFactory.getLogger(ContoCorrente.class);
    private String numeroConto;
    private String nome;
    private String cognome;
    private double disponibilita;

    public ContoCorrente(String nome, String cognome) {
        Random random = new Random();
        this.numeroConto = String.format("%06d", random.nextInt(999999)); // Numero conto formattato con 6 cifre
        this.nome = nome;
        this.cognome = cognome;
        this.disponibilita = 0;
    }

    public String getNumeroConto() {
        return numeroConto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public double getDisponibilita() {
        return disponibilita;
    }

    public void setDisponibilita(double disponibilita) {
        this.disponibilita = disponibilita;
    }

    public void prelievoContanti(double importo) throws PrelievoException {
        if (importo <= 0) {
            logger.error("L'importo del prelievo deve essere positivo.");
            throw new PrelievoException("Importo prelievo non valido: " + importo);
        }

        if (this.disponibilita < importo) {
            logger.error("Disponibilità fondi insufficiente: {} € ", this.disponibilita);
            throw new PrelievoException("Disponibilità fondi insufficiente. Richiesto: € " + importo + ", Disponibile: € " + this.disponibilita);
        }

        this.disponibilita -= importo;
        logger.info("Prelievo di {} € ", importo);
        logger.info("effettuato con successo. Nuova disponibilità: {} € ", this.disponibilita);
    }

    @Override
    public String toString() {
        return "ContoCorrente{" +
                "Numero Conto='" + numeroConto + '\'' +
                ", Nome='" + nome + '\'' +
                ", Cognome='" + cognome + '\'' +
                ", Disponibilità=" + " " + "€" + " " + disponibilita +
                '}';
    }
}