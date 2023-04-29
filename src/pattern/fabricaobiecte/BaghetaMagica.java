package pattern.fabricaobiecte;

import pattern.builder.Pokemon;

public class BaghetaMagica implements ObiectPokemon{
    @Override
    public void inzestreaza(Pokemon pokemon) {
        int atac_special = pokemon.getAtacSpecial();
        if(atac_special>0){
            atac_special=atac_special+3;
            pokemon.setAtacSpecial(atac_special);
        }
    }
}
