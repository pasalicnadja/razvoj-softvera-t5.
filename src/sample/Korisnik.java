package sample;

import javafx.beans.property.SimpleStringProperty;

public class Korisnik {

private SimpleStringProperty ime = new SimpleStringProperty("");
private SimpleStringProperty prezime= new SimpleStringProperty("");
private SimpleStringProperty email= new SimpleStringProperty("");
private SimpleStringProperty korisnickoime= new SimpleStringProperty("");
private SimpleStringProperty lozinka= new SimpleStringProperty("");


    public String getIme() {
        return ime.get();
    }

    public SimpleStringProperty imeProperty() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime.set(ime);
    }

    public String getPrezime() {
        return prezime.get();
    }

    public SimpleStringProperty prezimeProperty() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime.set(prezime);
    }

    public String getEmail() {
        return email.get();
    }

    public SimpleStringProperty emailProperty() {
        return email;
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public String getKorisnickoime() {
        return korisnickoime.get();
    }

    public SimpleStringProperty korisnickoimeProperty() {
        return korisnickoime;
    }

    public void setKorisnickoime(String korisnickoime) {
        this.korisnickoime.set(korisnickoime);
    }

    public String getLozinka() {
        return lozinka.get();
    }

    public SimpleStringProperty lozinkaProperty() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka.set(lozinka);
    }

public Korisnik() {};

public Korisnik(String ime, String prezime, String email, String korisnickoime,String lozinka){
        this.ime = new SimpleStringProperty(ime);
        this.prezime = new SimpleStringProperty(prezime);
        this.email = new SimpleStringProperty(email);
        this.korisnickoime = new SimpleStringProperty(korisnickoime);
        this.lozinka = new SimpleStringProperty(lozinka);
        }

@Override
public  String toString() {
        String str = ime.get() + " " + prezime.get();
        return str;
        }

        }

