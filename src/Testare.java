import pattern.builder.Pokemon;
import pattern.command.Antrenor;
import pattern.fabricaobiecte.CentralizatorObiecte;
import pattern.factory.FabricadePokemoni;
import pattern.singleton.Arena;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;

public class Testare {
    Antrenor antrenor1 = new Antrenor();
    Antrenor antrenor2 = new Antrenor();


    public void citeste_din_fisier(int index) throws Exception {
        File file = new File("src/teste");
        File[] fisiere = file.listFiles();
        assert fisiere != null;
        Scanner sc = new Scanner(fisiere[index]);


        puneLaAntrenor(antrenor1,sc);
        puneLaAntrenor(antrenor2,sc);
    }

    public void puneLaAntrenor(Antrenor antrenor, Scanner sc) throws Exception {
        String nume = sc.next();
        antrenor.setNume(nume);
        int varsta = sc.nextInt();
        antrenor.setVarsta(varsta);
        String lista_pokemoni = sc.next();
        String[] pokemoni = lista_pokemoni.split(",");
        ArrayList<Pokemon> listaPokemoni = new ArrayList<>();
        FabricadePokemoni fabricadePokemoni = new FabricadePokemoni();
        for(int i=0;i<3;i++){
            listaPokemoni.add(fabricadePokemoni.creeazaPokemonDeTipul(pokemoni[i]));
        }
        antrenor.setLista(listaPokemoni);
        CentralizatorObiecte centralizator = new CentralizatorObiecte();
        for (int i = 0; i < 3; i++) {
            String inzestrare = sc.next();
            String[] parti = inzestrare.split(":");
            String[] obiectele=parti[1].split(",");
            for(String obiect: obiectele){
                centralizator.pune_obiectul(obiect, listaPokemoni.get(i));
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Logger logger = Logger.getLogger(Testare.class.getName());
        Handler handler = new FileHandler("src/inregistrare");
        logger.addHandler(handler);
        Testare t= new Testare();
        t.citeste_din_fisier(0);
        Arena arena = Arena.arenaSingleton();

        arena.seteazaPokemoniArena(t.antrenor1.getLista(),t.antrenor2.getLista());

        FabricadePokemoni fabricadePokemoni = new FabricadePokemoni();
        Pokemon neutrel1 = fabricadePokemoni.creeazaPokemonDeTipul("Neutrel1");
        Pokemon neutrel2 = fabricadePokemoni.creeazaPokemonDeTipul("Neutrel2");

        Pokemon pok1 =t.antrenor1.getLista().get(0);
        Pokemon pok2 =t.antrenor2.getLista().get(0);

        t.antrenor1.setLogger(logger);
        t.antrenor2.setLogger(logger);

        int i=(int)(Math.random()*3);
        while(i!=2) {

            if (i == 0) {
                logger.info("Batalia cu neutrel 1 incepe.");
                if (neutrel1.getHP() == 0)
                    neutrel1 = fabricadePokemoni.creeazaPokemonDeTipul("Neutrel1");
                arena.duelVsNeutrel(pok1, neutrel1, logger);
                if (neutrel1.getHP() == 0)
                    neutrel1 = fabricadePokemoni.creeazaPokemonDeTipul("Neutrel1");
                arena.duelVsNeutrel(pok2, neutrel1, logger);
            } else if (i == 1) {
                logger.info("Batalia cu neutrel 2 incepe");
                if (neutrel2.getHP() == 0)
                    neutrel2 = fabricadePokemoni.creeazaPokemonDeTipul("Neutrel2");
                arena.duelVsNeutrel(pok1, neutrel2, logger);
                if (neutrel2.getHP() == 0)
                    neutrel2 = fabricadePokemoni.creeazaPokemonDeTipul("Neutrel2");
                arena.duelVsNeutrel(pok2, neutrel2, logger);
            }


            i = (int) (Math.random() * 3);

        }
        t.antrenor1.setPokemonulMeu(pok1);
        t.antrenor2.setPokemonulMeu(pok2);
        t.antrenor1.pregatesteComenzi(pok2);
        t.antrenor2.pregatesteComenzi(pok1);
        Thread t1 = new Thread(t.antrenor1);
        Thread t2= new Thread(t.antrenor2);
        t1.start();
        t2.start();
        if((!t1.isAlive())&&(!t2.isAlive())){
            if(pok1.getHP()>0)
                arena.cresteCaracteristici(pok1);
            else
                arena.cresteCaracteristici(pok2);
        }

    }
}
