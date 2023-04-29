package pattern.fabricaobiecte;

import pattern.builder.Pokemon;

public class Pelerina implements ObiectPokemon{
    @Override
    public void inzestreaza(Pokemon pokemon) {
        int aparare_speciala = pokemon.getAparareSpeciala();
        aparare_speciala+=2;
        pokemon.setAparareSpeciala(aparare_speciala);
    }
}
