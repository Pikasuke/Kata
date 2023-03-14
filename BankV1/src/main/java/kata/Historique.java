package kata;

import java.util.List;

public class Historique {

    private final List<Transaction> transactions;
    private final long soldeInitial;
    private long soldeFinal;

    public Historique(List<Transaction> transactions, double soldeInitial) {
        this.transactions = transactions;
        this.soldeInitial = Math.round(soldeInitial*100.00);

    }

    public List<Transaction> getTransactions() {
        return this.transactions;
    }

    public double getSoldeInitial() {
        return this.soldeInitial/100;
    }

    public double getSoldeFinal() {
        long solde = this.soldeInitial;
        for (Transaction t:this.getTransactions()) {
            long montant = switch (t.type) {
                case DEPOT-> t.montant;
                case RETRAIT-> -t.montant;
                default-> 0;
            };
            solde+= t.montant;
        }

        return solde/100;
    }
}
