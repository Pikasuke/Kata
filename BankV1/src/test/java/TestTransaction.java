import kata.Compte;
import kata.Historique;
import kata.Transaction;
import kata.TypeTransac;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestTransaction {

    private Compte compte;
    private double soldeInitial;

    @BeforeEach
    void setUp() {
        soldeInitial = 3000.00;
        compte = new Compte(soldeInitial);
    }
    @Test void CreerUneTransation() {
        compte.depose(1000.00);
        Transaction transaction = new Transaction(TypeTransac.DEPOT, 500.00);
        Assertions.assertEquals(TypeTransac.DEPOT,transaction.type);
        Assertions.assertEquals(500.00,transaction.getMontant());
    }

    @Test void unDepotCreerUneTransation() {
        compte.depose(1000.00);
        Historique historiqueDuCompte = compte.getHistorique();
        List<Transaction> transactions = List.of(new Transaction(TypeTransac.DEPOT, 1000.00));
        Assertions.assertEquals(transactions, historiqueDuCompte.getTransactions());
    }
    @Test void unRetraitCreerUneTransation() {
        compte.retire(10.00);
        Historique historiqueDuCompte = compte.getHistorique();
        List<Transaction> transactions = List.of(new Transaction(TypeTransac.RETRAIT, -10.00));
        Assertions.assertEquals(transactions, historiqueDuCompte.getTransactions());
    }

    //TODO
}
