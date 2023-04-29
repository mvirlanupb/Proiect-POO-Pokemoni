package pattern.builder;

import java.util.ArrayList;

public class Pokemon {
    /*
    Construim o clasa pattern.builder.Pokemon care contine urmatoarele campuri:
    -HP
    -Normal Attack
    -Special Attack
    -Defense
    -Special Defense
    - toate cele de mai sus sunt valori intregi
    - N/A =0
     */
    private int HP;
    private int AtacNormal;
    private int AtacSpecial;
    private int Aparare;
    private int AparareSpeciala;
    private ArrayList<Abilitate> abilitati;
    private String nume;

    private boolean esteBlocat;
    private boolean AfolositDodge;

    public void setAfolositDodge(boolean afolositDodge) {
        this.AfolositDodge = afolositDodge;
    }

    public boolean isAfolositDodge() {
        return AfolositDodge;
    }

    public void setEsteBlocat(boolean esteBlocat) {
        this.esteBlocat = esteBlocat;
    }

    public boolean isEsteBlocat() {
        return esteBlocat;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }
// pregatim get-eri si set-eri. Respectam principiul incapsularii


    public int getHP() {
        return HP;
    }

    public int getAtacNormal() {
        return AtacNormal;
    }

    public int getAtacSpecial() {
        return AtacSpecial;
    }

    public int getAparare() {
        return Aparare;
    }

    public int getAparareSpeciala() {
        return AparareSpeciala;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public void setAtacNormal(int atacNormal) {
        AtacNormal = atacNormal;
    }

    public void setAtacSpecial(int atacSpecial) {
        AtacSpecial = atacSpecial;
    }

    public void setAparare(int aparare) {
        Aparare = aparare;
    }

    public void setAparareSpeciala(int aparareSpeciala) {
        AparareSpeciala = aparareSpeciala;
    }

    public ArrayList<Abilitate> getAbilitati() {
        return abilitati;
    }

    public void setAbilitati(ArrayList<Abilitate> abilitati) {
        this.abilitati = abilitati;
    }

}
