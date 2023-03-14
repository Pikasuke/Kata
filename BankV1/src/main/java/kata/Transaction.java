package kata;

import java.util.Objects;

public class Transaction {
    public TypeTransac type;

    public long montant;

    public Transaction(TypeTransac type, double montant) {
        this.type = type;
        this.montant = Math.round(montant*100);
    }

    public Transaction() {
    }
    public double getMontant() {
        return montant/100;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Double.compare(that.montant, montant) == 0 && Objects.equals(type, that.type);
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
