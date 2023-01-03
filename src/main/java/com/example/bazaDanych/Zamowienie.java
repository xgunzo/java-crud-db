package com.example.bazaDanych;
import javax.persistence.*;


@Entity
@Table(name="ZamowieniaInternetowe")

public class Zamowienie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nr_zamowienia", length = 5, unique = true)
    private Integer nr_zamowienia;
    private String marka;
    private String model_produktu;
    private String imie;
    private String nazwisko;
    @Column(name = "numer", nullable = false)
    private String nr_telefonu;
    private String email;
    @Transient
    boolean nowy;

    //Constructor
    public Zamowienie(Integer nr_zamowienia, String marka, String model_produktu, String imie, String nazwisko, String nr_telefonu, String email, boolean nowy) {
        this.nr_zamowienia = nr_zamowienia;
        this.marka = marka;
        this.model_produktu = model_produktu;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.nr_telefonu = nr_telefonu;
        this.email = email;
        this.nowy = nowy;
    }

    public Zamowienie(Integer id,Integer nr_zamowienia, String marka, String model_produktu, String imie, String nazwisko, String nr_telefonu, String email, boolean nowy) {
        this.id = id;
        this.nr_zamowienia = nr_zamowienia;
        this.marka = marka;
        this.model_produktu = model_produktu;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.nr_telefonu = nr_telefonu;
        this.email = email;
        this.nowy = nowy;
    }


    public Zamowienie() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNr_zamowienia() {
        return nr_zamowienia;
    }

    public void setNr_zamowienia(Integer nr_zamowienia) {
        this.nr_zamowienia = nr_zamowienia;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getModel_produktu() {
        return model_produktu;
    }

    public void setModel_produktu(String model_produktu) {
        this.model_produktu = model_produktu;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getNr_telefonu() {
        return nr_telefonu;
    }

    public void setNr_telefonu(String nr_telefonu) {
        this.nr_telefonu = nr_telefonu;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isNowy() {
        return nowy;
    }

    public void setNowy(boolean nowy) {
        this.nowy = nowy;
    }


    //toString()
    @Override
    public String toString() {
        return "Zamowienie{" +
                "id=" + id +
                ",nr_zamowienia=" + nr_zamowienia +
                ", marka='" + marka + '\'' +
                ", model='" + model_produktu + '\'' +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", nr_telefonu='" + nr_telefonu + '\'' +
                ", email='" + email + '\'' +
                ", nowy=" + nowy +
                '}';
    }


}
