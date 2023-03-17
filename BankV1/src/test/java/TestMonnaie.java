import kata.Compte;
import kata.Monnaie;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestMonnaie {
    private Compte compte;
    private double soldeInitial;

    @BeforeEach
    public void setUp() {
        soldeInitial = 4807.00;
        compte = new Compte(soldeInitial);
    }
    @Test
    public void laDonneesEstStockeEnMonnaie() {
        Monnaie monnaie = new Monnaie(4807.00);
        Assertions.assertEquals(monnaie.monnaieToDouble(monnaie.getCentimes()), compte.getSolde());
    }
}
