package pattern.command;

import pattern.builder.Pokemon;

import java.util.logging.Logger;

public class ComandaAtac extends ComandaDeLaAntrenor{
    private Pokemon pokemonDusman,celCareAtaca;

    public ComandaAtac(Pokemon celAtacat, Pokemon celCareAtaca) {
        super(celAtacat, celCareAtaca);
    }
    //private static final Logger un_logger = Logger.getLogger(ComandaAtac.class.getName());



    @Override
    public int nrDmg() {
        return getCelCareAtaca().getAtacNormal();
    }



    @Override
    public int CD() {
        return 0;
    }

    @Override
    public String tipAtac() {
        return "Atac";
    }

    @Override
    public void executaComanda(Logger logger) {
        if ((nrDmg()>0)&&(!getCelCareAtaca().isEsteBlocat())) {
            int HP = getCelAtacat().getHP();
            if(!getCelAtacat().isAfolositDodge())
                HP = HP - getCelCareAtaca().getAtacNormal() + getCelAtacat().getAparare();
            else
                getCelAtacat().setAfolositDodge(true);
            if (HP < 0) {
                HP = 0;
            }
            getCelAtacat().setHP(HP);
        }
        else if(getCelCareAtaca().isEsteBlocat()){
            logger.info("Se deblocheaza "+getCelCareAtaca().getNume()+"...");
            getCelCareAtaca().setEsteBlocat(true);
        }
        /*try{
            Thread.sleep(nrDmg()* 1000L);
        }catch (InterruptedException ex){
            ex.printStackTrace();
        }

         */

    }
}
