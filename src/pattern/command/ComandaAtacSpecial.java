package pattern.command;

import pattern.builder.Pokemon;

import java.util.logging.Logger;

public class ComandaAtacSpecial extends ComandaDeLaAntrenor{
    private Pokemon celAtacat,celCareAtaca;


    public ComandaAtacSpecial(Pokemon pokemonDusman, Pokemon celCareAtaca) {
        super(pokemonDusman,celCareAtaca);
    }

    @Override
    public int nrDmg() {
        return getCelCareAtaca().getAtacSpecial();
    }

    @Override
    public int CD() {
        return 0;
    }

    @Override
    public String tipAtac() {
        return "Atac Special";
    }

    @Override
    public void executaComanda(Logger logger) {
        if((nrDmg()>0)&&(!getCelCareAtaca().isEsteBlocat())) {
            int HP = getCelAtacat().getHP();
            if(!getCelAtacat().isAfolositDodge())
                HP = HP - getCelCareAtaca().getAtacSpecial() + getCelAtacat().getAparareSpeciala();
            else
                getCelAtacat().setAfolositDodge(false);
            if (HP < 0) {
                HP = 0;
            }
            getCelAtacat().setHP(HP);
            //System.out.println("Atac special");
            //afiseaza_info();
        }
        else if(getCelCareAtaca().isEsteBlocat())
        {
            logger.info(getCelCareAtaca().getNume()+" este blocat. Se va debloca...");
            getCelCareAtaca().setEsteBlocat(false);
        }

    }
        /*try {
            Thread.sleep(nrDmg()*1000L);
        }catch (InterruptedException ex){
            ex.printStackTrace();
        }

         */

    }

