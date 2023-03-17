import kata.Compte;
import kata.Historique;
import kata.Transaction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TestCompte {

    private Compte compte;
    private double soldeInitial;

    @BeforeEach
    public void setUp() {
        soldeInitial = 4807.00;
        compte = new Compte(soldeInitial);
    }

    @Test
    public void creationDeCompteAvecSoldeInitial() {
        Assertions.assertEquals(soldeInitial, compte.getSolde());
    }

    @Test
    public void apresDepotDeCentLeSoldeAugmenteDeCent() {
        compte.depose(100.00);
        Assertions.assertEquals(soldeInitial+100, compte.getSolde());
    }
    @Test
    public void apresDepotDeUnCentimeLeSoldeAugmenteDeUnCentime() {
        compte.depose(0.01);
        Assertions.assertEquals(soldeInitial+0.01, compte.getSolde());
    }

    @Test
    public void depotInferieurAUnCentimeImpossible() {
        compte.depose(-1.00);
        Assertions.assertEquals(soldeInitial, compte.getSolde());
        compte.depose(0.001);
        Assertions.assertEquals(soldeInitial, compte.getSolde());
    }

    @Test
    public void apresRetraitLeSoldeDiminueDuMontantRetire() {
        compte.retire(1000);
        Assertions.assertEquals(soldeInitial-1000, compte.getSolde());
    }
    @Test
    public void apresRetraitAvecSoldeNegatifImpossible() {
        compte.retire(5000);
        Assertions.assertEquals(soldeInitial, compte.getSolde());
    }

    @Test
    public void sansDepotRetraitLHistoriqueEstVide() {
        List<Transaction> listTransactionVide = new ArrayList<Transaction>();
        Assertions.assertEquals(listTransactionVide, compte.getHistorique().getTransactions());
    }

    @Test
    public void apresUnDepotLHistoriqueContientLeDepot() {
        compte.depose(1000);
        Assertions.assertEquals(1,compte.getHistorique().getTransactions().size());
        Assertions.assertEquals(1000, compte.getHistorique().getTransactions().get(0).getMontant());
    }

    @Test
    public void apresUnRetraitLHistoriqueContientLeRetrait() {
        compte.retire(10);
        Assertions.assertEquals(1,compte.getHistorique().getTransactions().size());
        Assertions.assertEquals(10, compte.getHistorique().getTransactions().get(0).getMontant());
    }

    @Test
    public void apresDesRetraitEtDepotLHistoriqueContientLesTransactions() {
        double soldeInitial = compte.getSolde();
        compte.retire(10);
        compte.depose(500);
        compte.depose(490);
        compte.retire(2000);
        double soldeFinal = compte.getSolde();
        Historique historique = compte.getHistorique();
        Assertions.assertEquals(4, historique.getTransactions().size());
        Assertions.assertEquals(10, historique.getTransactions().get(0).getMontant());
        Assertions.assertEquals(2000, historique.getTransactions().get(3).getMontant());
    }


    //TODO
    /*
    evoluer avec des dates
     */
}

