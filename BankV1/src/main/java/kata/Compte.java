package kata;

import java.util.ArrayList;
import java.util.List;

public class Compte {

    long solde;
    Monnaie soldeM;
    List<Transaction> transactions = new ArrayList<>();
    Historique historique;

    public Compte(double solde) {
        this.soldeM = new Monnaie(solde);
        historique = new Historique(transactions, solde);
    }

    public double getSolde() {
        return soldeM.monnaieToDouble(soldeM.getCentimes());
    }

    public void depose(double montant) {
        if (montant >= 0.01) {
            this.soldeM.ajoute(new Monnaie(montant));
            Transaction transaction = new Transaction(TypeTransac.DEPOT, montant);
            transactions.add(transaction);
        }
    }

    public void retire(double montant) {
        if ((Math.round((getSolde() - montant) * 100)) >= 0) {
            this.solde = Math.round((getSolde() - montant) * 100);
            this.soldeM.ajoute(new Monnaie(-montant));
                    Transaction transaction = new Transaction(TypeTransac.RETRAIT, montant);
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
