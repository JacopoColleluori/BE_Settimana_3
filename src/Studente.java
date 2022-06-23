import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

public class Studente {
    private final int id;
    private final String nome;
    private final String cognome;
    private final char genere;
    private final HashMap<String, List<Double>> voti;


    /**Constructor*/
    public Studente(int id, String nome, String cognome, char genere, HashMap<String, List<Double>> voti) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.genere = genere;
        this.voti = voti;
    }

    //Getter and Setter


    public String getNome() {
        return nome;
    }
    public HashMap<String, List<Double>> getVoti() {
        return voti;
    }

    @Override
    public String toString() {
        return " \n id= " + id +
                "\n nome= " + nome +
                "\n cognome= " + cognome + " ;\n";


    }

    //metodi
    public double mediaVotoMateria(String materia){
       Collection<Double> collection=getVoti().get(materia);
       Double totVoti=collection.stream().reduce(0.0, Double::sum);
        return totVoti/collection.size();
    }
    public double votoMiglioreMateria(String materia){
        Collection<Double> collection=getVoti().get(materia);
        return collection.stream().reduce(0.0,(max, voto) -> (voto > max ? max=voto : max) );
    }
    public boolean promosso() {
        Stream<String> collection = getVoti().keySet().stream();
        long contatore=collection.filter(el -> mediaVotoMateria(el) < 6).count();
        return contatore < 4;
    }
    public double mediaGenerale(){
        Stream<String> collection = getVoti().keySet().stream();
       double totVoti=collection.mapToDouble(this::mediaVotoMateria).sum();
       return totVoti/getVoti().size();
    }
}
