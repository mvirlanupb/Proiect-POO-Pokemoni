package pattern.fabricaobiecte;

import pattern.builder.Pokemon;

public class CentralizatorObiecte {
    public void pune_obiectul(String obiect,Pokemon pokemon) throws Exception {
        switch (obiect){
            case "Scut":
                new Scut().inzestreaza(pokemon);
                break;
            case "Sabiuta":
                new Sabiuta().inzestreaza(pokemon);
                break;
            case "Vesta":
                new Vesta().inzestreaza(pokemon);
                break;
            case "Pelerina":
                new Pelerina().inzestreaza(pokemon);
                break;
            case "Vitamine":
                new Vitamine().inzestreaza(pokemon);
                break;
            case "BaghetaMagica":
                new BaghetaMagica().inzestreaza(pokemon);
                break;
            case "BradCraciun":
                new BradCraciun().inzestreaza(pokemon);
                break;
            default:
                throw new Exception("Obiectul dorit nu exista");
        }
    }
}
