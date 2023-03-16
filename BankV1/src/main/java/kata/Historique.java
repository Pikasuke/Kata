package kata;

import java.math.BigInteger;
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
        return soldeInitial.monnaieToDouble(this.soldeInitial.getMontant());
    }

    public double getSoldeFinal() {
        Monnaie solde = this.soldeInitial;
        for (Transaction t:this.getTransactions()) {
            BigInteger montant = switch (t.type) {
                case DEPOT-> t.montant.getMontant();
                case RETRAIT-> t.montant.reverse() ;
                default-> BigInteger.valueOf(0);
            };
            BigInteger a = BigInteger.valueOf(2);
            BigInteger b = a.negate();

            BigInteger sum = a.add(b);
            System.out.println("sum      " + sum);
            System.out.println("a      " + a);
            System.out.println("b      " + b);

            System.out.println("montant" + montant);
            solde.setMontant(solde.plus(solde.getMontant(),montant));
            System.out.println("solde " + solde.getMontant());

        }

        return solde.monnaieToDouble(solde.getMontant());
    }
}
