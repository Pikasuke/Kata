import kata.Compte;
import kata.Historique;
import kata.Transaction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.util.ArrayList;

public class TestHistorique {

    @Test
    public void lHistoriqueDonneLeSoldeInitial() {
        Historique historique = new Historique(new ArrayList<Transaction>(), 1000);
        Assertions.assertEquals(1000, historique.getSoldeInitial());
    }
    @Test
    public void lHistoriqueDonneLeSoldeFinal() {
        Compte compte = new Compte(2000);
        Assertions.assertEquals(2000, compte.getHistorique().getSoldeInitial());
        compte.depose(200);
        compte.retire(20);
        compte.retire(2000);
        Assertions.assertEquals(180, compte.getHistorique().getSoldeFinal());
    }

    //TODO
    /*
    remplacer long stoqué en Class de Monnaie
    recois des doubles enregistre des Monnnaies
    renvois des doubles
     */

}
