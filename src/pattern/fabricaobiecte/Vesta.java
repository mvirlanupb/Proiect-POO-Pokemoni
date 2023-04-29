package pattern.fabricaobiecte;

import pattern.builder.Pokemon;

public class Vesta implements ObiectPokemon{
    @Override
    public void inzestreaza(Pokemon pokemon) {
        int HP= pokemon.getHP();
        HP=HP+2;
        pokemon.setHP(HP);
    }
}
