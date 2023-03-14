package kata;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Monnaie {

    private BigInteger montant;
    private String devise;

    public Monnaie(double solde) {
        this.montant = BigInteger.valueOf(Math.round(solde*100.00));
    }

    public BigInteger doubleToMonnaie(double solde) {
        this.montant = BigInteger.valueOf(Math.round(solde*100.00));
        return this.montant;
    }
    public double monnaieToDouble() {
        double somme = Double.parseDouble(String.valueOf(this.montant))/Double.parseDouble(String.valueOf(100));
        return somme;
    }

    public long getMontant() {
        //TODO
        return 0;
    }

    //TODO
    /*
     opération add qui prends un monnaie et qui additionne 2 montants

     faire en parallele le travail actuel en Mmonnaie pour faire paaser les tests monnaie et supprimer ensuite le long

     */
}