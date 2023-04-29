package pattern.command;

import pattern.builder.Pokemon;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.*;

public class Antrenor implements Runnable{
    ComandaDeLaAntrenor[] comenzi;

    private String nume;
    private int varsta;

    private ArrayList<Pokemon> lista;

    public ArrayList<Pokemon> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Pokemon> lista) {
        this.lista = lista;
    }

    public Antrenor() {

    }

    public String getNume() {
        return nume;
    }

    public int getVarsta() {
        return varsta;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setVarsta(int varsta) {
        this.varsta = varsta;
    }

    private Logger logger;

    public Logger getLogger() {
        return logger;
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }

    private Pokemon pokemonulMeu;
    public Antrenor(Pokemon pokemon) throws IOException {
        this.pokemonulMeu=pokemon;
    }


    public Pokemon getPokemonulMeu() {
        return pokemonulMeu;
    }

    public void setPokemonulMeu(Pokemon pokemonulMeu) {
        this.pokemonulMeu = pokemonulMeu;
    }

    public ComandaDeLaAntrenor[] getComenziContra() {
        return comenzi;
    }

    public void setComenzi(ComandaDeLaAntrenor[] comenzi) {
        this.comenzi = comenzi;
    }

    public void pregatesteComenzi(Pokemon dusman){
        if((!getPokemonulMeu().getNume().equals("Neutrel1"))&&(!getPokemonulMeu().getNume().equals("Neutrel2"))) {
            comenzi = new ComandaDeLaAntrenor[4];
            comenzi[0] = new ComandaAtac(dusman, pokemonulMeu);
            comenzi[1] = new ComandaAtacSpecial(dusman, pokemonulMeu);
            comenzi[2] = new ComandaAbilitate1(dusman, pokemonulMeu);
            comenzi[2].setEste_activata(false);
            comenzi[3] = new ComandaAbilitate2(dusman, pokemonulMeu);
            comenzi[3].setEste_activata(false);
        }
        else {
            comenzi = new ComandaDeLaAntrenor[2];
            comenzi[0] = new ComandaAtac(dusman, pokemonulMeu);
            comenzi[1] = new ComandaAtacSpecial(dusman, pokemonulMeu);
        }
            setComenzi(comenzi);

    }

    public Pokemon pokemonDusman(){
        return comenzi[0].getCelAtacat();
    }


    public void executaComandaAleatorie(Logger logger) throws InterruptedException, IOException {

        int indice;
        if((getPokemonulMeu().getNume().equals("Neutrel1"))||(getPokemonulMeu().getNume().equals("Neutrel2")))
            indice=(int) (Math.random()*2);
        else
            indice=(int)(Math.random()*4);
        long ultima_folosire_ab1=System.currentTimeMillis();
        long ultima_folosire_ab2=System.currentTimeMillis();


        logger.log(Level.INFO,"Pokemonul {0} are HP-ul {1}",new Object[]{getPokemonulMeu().getNume(),getPokemonulMeu().getHP()});
        if (comenzi[indice].getCelAtacat().getHP()*comenzi[indice].getCelCareAtaca().getHP()>0) {
            if (((indice==0)||(indice==1))&&(comenzi[indice].nrDmg()>0)&&(!getPokemonulMeu().isEsteBlocat()))
                logger.info("Pokemonul " + comenzi[indice].getCelCareAtaca().getNume() + " cu HP-ul " +
                        comenzi[indice].getCelCareAtaca().getHP() + " va folosi " + comenzi[indice].tipAtac());
            switch (indice){
                case 2:

                    comandaSpecialadeIndice(2,logger);
                    break;
                case 3:
                    comandaSpecialadeIndice(3,logger);
                    break;
                default:
                    comenzi[indice].executaComanda(logger);

            }
            Thread.sleep(300);
            //System.out.println("Pokemonul "+getPokemonulMeu().getNume()+" are HP-ul "+getPokemonulMeu().getHP()+" si a folosit"+comenzi[indice].tipAtac());
            indice=(int)(Math.random()*4);
        }

        //logger.info("Pokemonul meu "+getPokemonulMeu().getNume()+ " are la HP-ul "+getPokemonulMeu().getHP());
        //logger.info("Pokemonul dusman "+comenzi[0].getCelAtacat().getNume()+" are la HP-ul "+comenzi[0].getCelAtacat().getHP());

    }

    public void comandaSpecialadeIndice(int index,Logger logger){
        //System.out.println(comenzi[index].isEste_activata());
        if(!comenzi[index].isEste_activata()){

            if(!comenzi[index].getCelCareAtaca().isEsteBlocat()) {
                if(comenzi[index].getCelCareAtaca().getAbilitati().get(index-2).isStun())
                    comenzi[index].getCelAtacat().setEsteBlocat(true);

                logger.info("Pokemonul " + comenzi[index].getCelCareAtaca().getNume() + " cu HP-ul " +
                        comenzi[index].getCelCareAtaca().getHP() + " va folosi " + comenzi[index].tipAtac());
            }
            comenzi[index].executaComanda(logger);
            long timp=System.currentTimeMillis();
            comenzi[index].setTimp(timp);
            comenzi[index].setEste_activata(true);

        }
        else{
            if(System.currentTimeMillis()-comenzi[index].getTimp()>=comenzi[index].CD()*1000L)
            {
                System.out.println(System.currentTimeMillis()-comenzi[index].getTimp() +comenzi[index].getCelCareAtaca().getNume()+" "+comenzi[index].tipAtac());
                if(!comenzi[index].getCelCareAtaca().isEsteBlocat()) {
                    if(comenzi[index].getCelCareAtaca().getAbilitati().get(index-2).isStun())
                        comenzi[index].getCelAtacat().setEsteBlocat(true);

                    logger.info("Pokemonul " + comenzi[index].getCelCareAtaca().getNume() + " cu HP-ul " +
                            comenzi[index].getCelCareAtaca().getHP() + " va folosi " + comenzi[index].tipAtac());
                }
                comenzi[index].executaComanda(logger);
                comenzi[index].setTimp(System.currentTimeMillis());
            }
        }
    }

    @Override
    public void run() {
        try {
            while(getPokemonulMeu().getHP()*pokemonDusman().getHP()>0) {
                executaComandaAleatorie(getLogger());
                Thread.sleep(800);
            }
            logger.info("Pokemonul meu "+getPokemonulMeu().getNume()+ " are la final HP-ul "+getPokemonulMeu().getHP());
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }
   /*
    public static void main(String[] args) throws InterruptedException, IOException {
        FabricadePokemoni fabricadePokemoni= new FabricadePokemoni();
        Pokemon pokemon1= fabricadePokemoni.creeazaPokemonDeTipul("Pikachu");
        Pokemon pokemon2= fabricadePokemoni.creeazaPokemonDeTipul("Bulbasaur");
        pokemon1.setEsteBlocat(false);
        pokemon2.setEsteBlocat(false);
        Antrenor antrenor1= new Antrenor(pokemon1);
        Antrenor antrenor2=new Antrenor(pokemon2);
        antrenor1.pregatesteComenzi(pokemon2);
        antrenor2.pregatesteComenzi(pokemon1);
        Thread t1=new Thread(antrenor1);
        Thread t2=new Thread(antrenor2);
        t1.setName("Andrei");
        t2.setName("Ioana");
        t1.start();
        t2.start();

    }

    */
    /*
    2 threaduri functioneaza in paralel
    cand unul trebuie sa se opreasca, celalalt trebuie si el sa se opreasca
     */
}
