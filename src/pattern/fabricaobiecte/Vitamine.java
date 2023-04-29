package pattern.fabricaobiecte;

import pattern.builder.Pokemon;

public class Vitamine implements ObiectPokemon{
    @Override
    public void inzestreaza(Pokemon pokemon) {
        int atac,atac_special,HP;
        atac=pokemon.getAtacNormal();
        atac_special=pokemon.getAtacSpecial();
        HP=pokemon.getHP();
        if(atac>0)
            atac+=2;
        if(atac_special>0)
            atac_special+=2;
        HP+=2;
        pokemon.setHP(HP);
        pokemon.setAtacNormal(atac);
        pokemon.setAtacSpecial(atac_special);
    }
}
