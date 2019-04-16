package sample;

import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.ListView;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
public class Controller {

    public ListView<Korisnik>  ispislista;
    public TextField xfime;
    public TextField xfprezime;
    public TextField xfemail;
    public TextField xfkorisnickoime;
    public TextField xflozinka;
    public Button dodaj;
    public Button kraj;
    private SimpleObjectProperty<KorisnickiModel> model = new SimpleObjectProperty<>(this, "model");


    @FXML
    public void dodaj(ActionEvent actionEvent) {
        model.get().dodajKorisnika();
        setTextPropetryUnBind();
        ispislista.refresh();
        ispislista.requestFocus();
        ispislista.getSelectionModel().selectLast();
    }
    @FXML
    public void kraj(ActionEvent actionEvent) {
        Node n = (Node) actionEvent.getSource();
        Stage stage = (Stage) n.getScene().getWindow();
        stage.close();
    }
    public Controller(KorisnickiModel m) {
        model.set(m);
    }
    public void initialize(){
        ispislista.requestFocus();
        model.get().setTrenutniKorisnik(model.get().getKorisnik().get(0));
        setTextPropetryBind();
        ispislista.setItems(model.get().getKorisnik());
        ispislista.getFocusModel().focus(0);
        setTextPropetryUnBind();

        ispislista.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Korisnik>() {
            @Override
            public void changed(ObservableValue<? extends Korisnik> observableValue, Korisnik korisnikOld, Korisnik korisnikNew) {
                if (korisnikOld != null) {
                    setTextPropetryUnBind();
                }
                if (korisnikNew == null) {
                    xfime.setText("");
                    xfprezime.setText("");
                    xfemail.setText("");
                    xfkorisnickoime.setText("");
                    xflozinka.setText("");
                }
                else {
                    updateKorisnika();
                }
                ispislista.refresh();
            }
        });
    }
    private void updateKorisnika() {
        Korisnik korisnik = (Korisnik) ispislista.getSelectionModel().getSelectedItem();
        setTextPropetryUnBind();
        model.get().setTrenutniKorisnik(korisnik);
        setTextPropetryBind();
        ispislista.refresh();
    }

    private void setTextPropetryBind() {
        xfime.textProperty().bindBidirectional(model.get().getTrenutniKorisnik().imeProperty());
        xfprezime.textProperty().bindBidirectional(model.get().getTrenutniKorisnik().prezimeProperty());
        xfemail.textProperty().bindBidirectional(model.get().getTrenutniKorisnik().emailProperty());
        xfkorisnickoime.textProperty().bindBidirectional(model.get().getTrenutniKorisnik().korisnickoimeProperty());
        xflozinka.textProperty().bindBidirectional(model.get().getTrenutniKorisnik().lozinkaProperty());
    }

    private void setTextPropetryUnBind() {
        xfime.textProperty().unbindBidirectional(model.get().getTrenutniKorisnik().imeProperty());
        xfprezime.textProperty().unbindBidirectional(model.get().getTrenutniKorisnik().prezimeProperty());
        xfemail.textProperty().unbindBidirectional(model.get().getTrenutniKorisnik().emailProperty());
        xfkorisnickoime.textProperty().unbindBidirectional(model.get().getTrenutniKorisnik().korisnickoimeProperty());
        xflozinka.textProperty().unbindBidirectional(model.get().getTrenutniKorisnik().lozinkaProperty());
    }



}
