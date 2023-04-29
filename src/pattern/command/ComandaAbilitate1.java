package pattern.command;

import pattern.builder.Pokemon;

import java.util.logging.Logger;

public class ComandaAbilitate1 extends ComandaDeLaAntrenor{
    private Pokemon celCareAtaca, celAtacat;
    public ComandaAbilitate1(Pokemon celAtacat, Pokemon celCareAtaca){
        super(celAtacat, celCareAtaca);
    }


    @Override
    public int nrDmg() {
        return getCelCareAtaca().getAbilitati().get(0).getDamage();
    }

    public int CD(){
        return getCelCareAtaca().getAbilitati().get(0).getCooldown();
    }

    public boolean areDodge(){
        return getCelCareAtaca().getAbilitati().get(0).isDodge();
    }
    public boolean areBlock(){
        return getCelCareAtaca().getAbilitati().get(0).isStun();
    }

    @Override
    public String tipAtac() {
        return "Abilitate 1";
    }

    @Override
    public void executaComanda(Logger logger){
        if((nrDmg()>0)&&(!getCelCareAtaca().isEsteBlocat())){
            int HP=getCelAtacat().getHP();
            if(!getCelAtacat().isAfolositDodge())
                HP=HP-nrDmg();
            else
                getCelAtacat().setAfolositDodge(false);
            if(HP<0)
                HP=0;
            getCelAtacat().setHP(HP);
            if(areDodge()) {
                logger.info(getCelCareAtaca().getNume()+" va evita pe "+getCelAtacat().getNume());
                getCelCareAtaca().setAfolositDodge(true);
            }
            if(areBlock()){
                logger.info(getCelCareAtaca().getNume()+ " va bloca pe "+getCelAtacat().getNume());
                getCelAtacat().setEsteBlocat(true);
            }

        }
        else if (getCelCareAtaca().isEsteBlocat()) {
            logger.info(getCelCareAtaca().getNume()+" este blocat. Se va debloca...");
            getCelCareAtaca().setEsteBlocat(false);
        }
    }
}
