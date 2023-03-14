package kata;

import java.util.ArrayList;
import java.util.List;

public class Compte {

    Monnaie solde;
    List<Transaction> transactions = new ArrayList<>();
    Historique historique;

    public Compte(double solde) {
        this.solde = new Monnaie(solde);
        historique = new Historique(transactions, solde);
    }

    public double getSolde() {
        return this.solde.monnaieToDouble();
    }

    public void depose(double depot) {
        if (depot >= 0.01) {
            this.solde = new Monnaie(depot);
            Transaction transaction = new Transaction(TypeTransac.DEPOT, depot);
            transactions.add(transaction);
        }
    }

    public void retire(double retrait) {
        if ((Math.round((getSolde() - retrait) * 100)) >= 0) {
            this.solde = Math.round((getSolde() - retrait) * 100);
            Transaction transaction = new Transaction(TypeTransac.RETRAIT, -retrait);
            transactions.add(transaction);
        }
    }

    public Historique getHistorique() {
        return historique;
    }

    private void printTransaction() {
        System.out.println("Transaction historique");
        for (Transaction t: transactions) {
            System.out.println(t.toString());
        }
        System.out.println("-----------------------");
    }

}
