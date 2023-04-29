package pattern.fabricaobiecte;

import pattern.builder.Pokemon;

public class BradCraciun implements ObiectPokemon{
    @Override
    public void inzestreaza(Pokemon pokemon) {
        int aparare = pokemon.getAparare();
        aparare=aparare+2;
        pokemon.setAparare(aparare);
    }
}
