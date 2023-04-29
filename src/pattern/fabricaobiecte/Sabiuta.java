package pattern.fabricaobiecte;

import pattern.builder.Pokemon;

public class Sabiuta implements ObiectPokemon{
    @Override
    public void inzestreaza(Pokemon pokemon) {
        int atac = pokemon.getAtacNormal();
        if(atac>0) {
            atac = atac + 3;
            pokemon.setAtacNormal(atac);
        }
    }
}
