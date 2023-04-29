package pattern.command;

import pattern.builder.Pokemon;

import java.io.IOException;
import java.util.logging.*;

//faza mai neobisnuita este ca, in cazul acestui pattern comanda, stim cine ataca si cine este atacat
public abstract class ComandaDeLaAntrenor{
    private Pokemon celAtacat,celCareAtaca;
    private static Handler filehandler;

    private long timp;

    public void setTimp(long timp) {
        this.timp = timp;
    }

    public long getTimp() {
        return timp;
    }


    static {
        try {
            filehandler = new FileHandler("src/inregistrare.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean este_activata;

    public void setEste_activata(boolean este_activata) {
        this.este_activata = este_activata;
    }

    public boolean isEste_activata() {
        return este_activata;
    }

    public ComandaDeLaAntrenor(Pokemon celAtacat, Pokemon celCareAtaca) {
        this.celAtacat = celAtacat;
        this.celCareAtaca = celCareAtaca;
    }

    public Pokemon getCelAtacat() {
        return celAtacat;
    }

    public Pokemon getCelCareAtaca() {
        return celCareAtaca;
    }


    public abstract void executaComanda(Logger logger);
    abstract int nrDmg();

    public abstract String tipAtac();


    public abstract int CD();
}
