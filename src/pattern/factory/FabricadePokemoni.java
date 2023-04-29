package pattern.factory;

import pattern.builder.Abilitate;
import pattern.builder.BuilderAbilitate;
import pattern.builder.BuilderPokemon;
import pattern.builder.Pokemon;
/*
Folosim patternul factory pentru a crea tipuri de pokemoni
 */

public class FabricadePokemoni {
     public Pokemon creeazaPokemonDeTipul(String tip){
         switch (tip){
             case "Pikachu":
                 return returneaza_pokemon(35,0,4,2,3,"Pikachu")
                         .setareAbilitati(returneaza_abilitate(6,false,false,4))
                         .setareAbilitati(returneaza_abilitate(4,true,true,5))
                         .construiestePokemon();
             case "Bulbasaur":
                 return returneaza_pokemon(42,0,5,3,1,"Bulbasaur")
                         .setareAbilitati(returneaza_abilitate(6,false,false,4))
                         .setareAbilitati(returneaza_abilitate(5,false,false,3))
                         .construiestePokemon();
             case "Charmander":
                 return returneaza_pokemon(50,4,0,3,2,"Charmander")
                         .setareAbilitati(returneaza_abilitate(4,true,false,4))
                         .setareAbilitati(returneaza_abilitate(7,false,false,6))
                         .construiestePokemon();
             case "Squirtle":
                 return returneaza_pokemon(60,0,3,5,5,"Squirtle")
                         .setareAbilitati(returneaza_abilitate(4,true,false,4))
                         .setareAbilitati(returneaza_abilitate(7,false,false,6))
                         .construiestePokemon();
             case "Snorlax":
                 return returneaza_pokemon(62,3,0,6,4,"Snorlax")
                         .setareAbilitati(returneaza_abilitate(4,true,false,5))
                         .setareAbilitati(returneaza_abilitate(0,false,true,5))
                         .construiestePokemon();
             case "Vulpix":
                 return returneaza_pokemon(36,5,0,2,4,"Vulpix")
                         .setareAbilitati(returneaza_abilitate(8,false,true,6))
                         .setareAbilitati(returneaza_abilitate(2,true,false,7))
                         .construiestePokemon();
             case "Eevee":
                     return returneaza_pokemon(39,0,4,3,3,"Eevee")
                             .setareAbilitati(returneaza_abilitate(5,false,false,3))
                             .setareAbilitati(returneaza_abilitate(3,true,false,3))
                             .construiestePokemon();
             case "Jigglypuff":
                 return returneaza_pokemon(34,4,0,2,3,"Jigglypuff")
                         .setareAbilitati(returneaza_abilitate(4,true,false,4))
                         .setareAbilitati(returneaza_abilitate(3,true,false,4))
                         .construiestePokemon();
             case "Meowth":
                 return returneaza_pokemon(41,3,0,4,2,"Meowth")
                         .setareAbilitati(returneaza_abilitate(5,false,true,4))
                         .setareAbilitati(returneaza_abilitate(1,false,true,3))
                         .construiestePokemon();
             case "Psyduck":
                 return returneaza_pokemon(43,3,0,3,3,"Psyduck")
                         .setareAbilitati(returneaza_abilitate(2,false,false,4))
                         .setareAbilitati(returneaza_abilitate(2,true,false,5))
                         .construiestePokemon();
             case "Neutrel1":
                 return returneaza_pokemon(10,3,0,1,1,"Neutrel1").construiestePokemon();
             case "Neutrel2":
                 return returneaza_pokemon(20,4,0,1,1,"Neutrel2").construiestePokemon();
             default:
                 throw new IllegalArgumentException("Pokemonul cautat nu exista");
         }
     }

     public Abilitate returneaza_abilitate(int dmg, boolean dodge, boolean stun, int cd){
         return new BuilderAbilitate().seteazaDamage(dmg)
                 .seteazaDodge(dodge)
                 .seteazaStun(stun)
                 .seteazaCooldown(cd)
                 .construieste();
     }

     public BuilderPokemon returneaza_pokemon(int HP,int atac, int atac_special,int aparare,
                                       int aparare_speciala,String nume){
         return new BuilderPokemon().seteazaHP(HP)
                 .seteazaNume(nume)
                 .seteazaAtac(atac)
                 .seteazaAtacSpecial(atac_special)
                 .seteazaAparare(aparare)
                 .seteazaAparareSpeciala(aparare_speciala);
     }

}
