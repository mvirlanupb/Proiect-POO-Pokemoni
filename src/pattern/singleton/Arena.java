package pattern.singleton;

import pattern.builder.Pokemon;
import pattern.command.*;
import pattern.factory.FabricadePokemoni;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;

public class Arena {
    private ArrayList<Pokemon> pokemoniAntrenor1;
    private ArrayList<Pokemon> pokemoniAntrenor2;

    private static Arena arena;

    public static Arena arenaSingleton() throws IOException {
        if(arena==null)
            arena= new Arena();
        return arena;
    }




    public void seteazaPokemoniArena(ArrayList<Pokemon> pokemoniAntrenor1, ArrayList<Pokemon> pokemoniAntrenor2) throws IOException {
        this.pokemoniAntrenor1 = pokemoniAntrenor1;
        this.pokemoniAntrenor2 = pokemoniAntrenor2;
    }

    private Arena() throws IOException {

    }

    public ArrayList<Pokemon> getPokemoniAntrenor1() {
        return pokemoniAntrenor1;
    }

    public ArrayList<Pokemon> getPokemoniAntrenor2() {
        return pokemoniAntrenor2;
    }

    public void duelVsNeutrel(Pokemon pokemon, Pokemon neutrel,Logger logger) throws IOException, InterruptedException {
        Antrenor antrenor = new Antrenor();
        Antrenor robotAI= new Antrenor();
        antrenor.setPokemonulMeu(pokemon);
        robotAI.setPokemonulMeu(neutrel);
        pokemon.setEsteBlocat(false);
        neutrel.setEsteBlocat(false);
        antrenor.pregatesteComenzi(neutrel);
        robotAI.pregatesteComenzi(pokemon);
        antrenor.setLogger(logger);
        antrenor.setLogger(logger);

        while (pokemon.getHP()*neutrel.getHP()>0){
            antrenor.executaComandaAleatorie(logger);
            robotAI.executaComandaAleatorie(logger);
        }

        Thread.sleep(900);

        if(pokemon.getHP()>0)
            cresteCaracteristici(pokemon);


    }

    public void cresteCaracteristici(Pokemon pokemon){
        pokemon=new FabricadePokemoni().creeazaPokemonDeTipul(pokemon.getNume());
        pokemon.setHP(pokemon.getHP()+1);
        pokemon.setAtacNormal(pokemon.getAtacNormal()+1);
        pokemon.setAtacSpecial(pokemon.getAtacSpecial()+1);
        pokemon.setAparare(pokemon.getAparare()+1);
        pokemon.setAparareSpeciala(pokemon.getAparareSpeciala()+1);
    }

}
