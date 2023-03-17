package kata;

import java.util.Objects;

public class Transaction {
    public TypeTransac type;

    public Monnaie montant;

    public Transaction(TypeTransac type, double montant) {
        this.type = type;
        this.montant = new Monnaie(montant);
    }

    public Transaction() {
    }
    public double getMontant() {
        return montant.monnaieToDouble(montant.getCentimes());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return type == that.type && Objects.equals(montant, that.montant);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, montant);
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "type=" + type +
                ", montant=" + montant +
                '}';
    }
}
