package kata;

import java.util.List;

public class Historique {

    private final List<Transaction> transactions;
    private final Monnaie soldeInitial;
    private long soldeFinal;

    public Historique(List<Transaction> transactions, double soldeInitial) {
        this.transactions = transactions;
        this.soldeInitial = new Monnaie(soldeInitial);

    }

    public List<Transaction> getTransactions() {
        return this.transactions;
    }

    public double getSoldeInitial() {
        return soldeInitial.monnaieToDouble(this.soldeInitial.getCentimes());
    }

    public double getSoldeFinal() {
        Monnaie solde = this.soldeInitial;
        for (Transaction t:this.getTransactions()) {
            Monnaie monnaie;
            if (t.type.equals(TypeTransac.RETRAIT)) {
                monnaie = t.montant.oppose();
            } else {
                monnaie = new Monnaie(t.montant);
            }
            solde.ajoute(monnaie);
        }
        return solde.monnaieToDouble(solde.getCentimes());
    }
}
