package kata;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Objects;

public class Monnaie {

    private long centimes;
    private String devise;

    public Monnaie(double montant) {

        this.centimes = (Math.round(montant*100.00));
    }

    public Monnaie(long centimes) {
        this.centimes = centimes;
    }

    public Monnaie (Monnaie monnaie) {
        this.centimes = monnaie.getCentimes();
    }
    public Monnaie oppose() {
        return new Monnaie(this.centimes *(-1));
    }
    public void oppose2() {
        this.centimes = this.centimes *(-1);
    }
    public void setCentimes(double solde) {
        this.centimes = (Math.round(solde*100.00));
    }
    public double monnaieToDouble(long solde) {
        double somme = Double.parseDouble(String.valueOf(solde))/Double.parseDouble(String.valueOf(100));
        return somme;
    }
    public long getCentimes() {
        return this.centimes;
    }

    public void setMontant(long montant) {
        this.centimes = montant;
    }


    public void ajoute(Monnaie autre) {
        this.centimes = this.centimes + autre.getCentimes();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Monnaie monnaie = (Monnaie) o;
        return Objects.equals(centimes, monnaie.centimes) && Objects.equals(devise, monnaie.devise);
    }

    @Override
    public int hashCode() {
        return Objects.hash(centimes, devise);
    }

    //TODO
    /*
     opération add qui prends un monnaie et qui additionne 2 montants

     faire en parallele le travail actuel en Mmonnaie pour faire paaser les tests monnaie et supprimer ensuite le long

     */
}