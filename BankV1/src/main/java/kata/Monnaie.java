package kata;

import java.math.BigInteger;
import java.util.Objects;

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
    public double monnaieToDouble(BigInteger solde) {
        double somme = Double.parseDouble(String.valueOf(solde))/Double.parseDouble(String.valueOf(100));
        return somme;
    }
    public BigInteger getMontant() {
        //TODO
        return this.montant;
    }

    public void setMontant(BigInteger montant) {
        this.montant = montant;
    }

    public double reverse(double montant) {
        return -montant;
    }
    public BigInteger reverse() {
        return this.montant.negate();
    }
    public BigInteger plus (BigInteger bIntA, BigInteger bIntB) {
        return bIntA.add(bIntB);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Monnaie monnaie = (Monnaie) o;
        return Objects.equals(montant, monnaie.montant) && Objects.equals(devise, monnaie.devise);
    }

    @Override
    public int hashCode() {
        return Objects.hash(montant, devise);
    }

    //TODO
    /*
     opération add qui prends un monnaie et qui additionne 2 montants

     faire en parallele le travail actuel en Mmonnaie pour faire paaser les tests monnaie et supprimer ensuite le long

     */
}