package pattern.fabricaobiecte;

import pattern.builder.Pokemon;

public class Scut implements ObiectPokemon{

    @Override
    public void inzestreaza(Pokemon pokemon) {
         int aparare = pokemon.getAparare();
         aparare=aparare+2;
         pokemon.setAparare(aparare);
         int aparare_speciala = pokemon.getAparareSpeciala();
         aparare_speciala=aparare_speciala+2;
         pokemon.setAparareSpeciala(aparare_speciala);
    }
}
