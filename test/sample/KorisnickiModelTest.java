package sample;

import javafx.collections.ObservableList;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KorisnickiModelTest {

    private static KorisnickiModel model= null;

     @BeforeAll
    static void setup(){
         model= new KorisnickiModel();
         model.napuni();
     }
     @Test
    void newKorisnik(){
         ObservableList<Korisnik>
a=model.getKorisnik();
         a.add(new Korisnik("Amer", "Karahasan", "akarahasan4@etf.unsa.ba", "America","finnakvadrat"));
         a.add(new Korisnik("Belma", "Muratovic", "bmuratovic2@etf.unsa.ba", "Beks","belma123"));
         assertEquals(5,a.size());
     }


}