package pattern.builder;

import java.util.ArrayList;

public class BuilderPokemon {
    //vom folosi tot design patternul builder pentru a seta campurile unui pokemon
    // nu dorim sa folosim constructori
    //folosim arraylist pentru abilitati, pentru a parametriza
    private final Pokemon pokemon = new Pokemon();
    private final ArrayList<Abilitate> lista_abilitati= new ArrayList<>();

    public BuilderPokemon seteazaHP(int hp){
        pokemon.setHP(hp);
        return this;
    }
    public BuilderPokemon seteazaAtac(int puncte_atac){
        pokemon.setAtacNormal(puncte_atac);
        return this;
    }
    public BuilderPokemon seteazaAtacSpecial(int puncte_atac_special){
        pokemon.setAtacSpecial(puncte_atac_special);
        return this;
    }
    public BuilderPokemon seteazaAparare(int def){
        pokemon.setAparare(def);
        return this;
    }
    public BuilderPokemon seteazaAparareSpeciala(int special_def){
        pokemon.setAparareSpeciala(special_def);
        return this;
    }
    public BuilderPokemon setareAbilitati(Abilitate abilitate){
        lista_abilitati.add(abilitate);
        pokemon.setAbilitati(lista_abilitati);
        return this;
    }

    public BuilderPokemon seteazaNume(String nume){
        pokemon.setNume(nume);
        return this;
    }

    public Pokemon construiestePokemon(){
        return pokemon;
    }
}
