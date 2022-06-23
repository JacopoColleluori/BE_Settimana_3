import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class Istituto {

    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("0.00");
        Logger logger = LoggerFactory.getLogger(Istituto.class);


        Studente giacomo = new Studente(0, "Giacomo", "Cassano", 'M', randomMap());


        Studente asino = new Studente(1, "Asino", "Laborioso", 'M', randomMap());
        Studente assassino = new Studente(2, "Assassino", "Malvagio", 'M', randomMap());
        Studente mago = new Studente(3, "Mago", "Forrest", 'F', randomMap());
        Studente guerriero = new Studente(4, "Guerriero", "Alberto", 'F', randomMap());

        List<Studente> listaScuola1 = new ArrayList<>();
        listaScuola1.add(giacomo);
        listaScuola1.add(asino);
        listaScuola1.add(assassino);
        listaScuola1.add(mago);
        listaScuola1.add(guerriero);


        Scuola normali = new Scuola(listaScuola1);

        //controllo metodi Classe Scuola e Studente
        logger.info(promossi(normali.getPromossi()));
        logger.info(normali.getStudenti().toString());
        logger.info("media di : " + giacomo.getNome() + " :" + df.format(giacomo.mediaGenerale()));
        logger.info("Lo studente migliore di questa scuola e': " + normali.getStudenteMigliore() + " \n con la media di :" + df.format(normali.getStudenteMigliore().mediaGenerale()));
        File file = new File("C:\\epicode\\Scuola\\studenti.txt");
        normali.salvaStudenti(file);
        logger.info("Voto: " + df.format(giacomo.mediaVotoMateria("Italiano")));
        logger.info("Voto: " + giacomo.promosso());


        Studente superMan = new Studente(6, "Super", "Man", 'M', randomMap());
        Studente batMan = new Studente(7, "Bat", "Man", 'M', randomMap());
        Studente spiderMan = new Studente(8, "Spider", "Man", 'M', randomMap());
        Studente hawkMan = new Studente(9, "Hawk", "Man", 'M', randomMap());
        Studente aquaMan = new Studente(10, "Aqua", "Man", 'M', randomMap());

        List<Studente> listaScuola2 = new ArrayList<>();
        listaScuola2.add(superMan);
        listaScuola2.add(batMan);
        listaScuola2.add(spiderMan);
        listaScuola2.add(hawkMan);
        listaScuola2.add(aquaMan);


        Scuola superEroi = new Scuola(listaScuola2);
        Thread thread1 = new Thread(normali, "Scuola Normali");
        Thread thread2 = new Thread(superEroi, "Scuola SuperEroi");
        thread1.start();
        thread2.start();

    }

    private static List<Double> randomList() {
        SplittableRandom random = new SplittableRandom();
        Double[] arrayRandom = new Double[6];
        for (int i = 0; i < 6; i++) {
            arrayRandom[i] = random.nextDouble(4, 10);
        }
        return Arrays.stream(arrayRandom).collect(Collectors.toList());
    }

    private static HashMap<String, List<Double>> randomMap() {
        HashMap<String, List<Double>> randomMap = new HashMap<>();
        randomMap.put("Italiano", randomList());
        randomMap.put("Matematica", randomList());
        randomMap.put("Scienze", randomList());
        randomMap.put("Filosofia", randomList());
        randomMap.put("Storia", randomList());
        randomMap.put("Inglese", randomList());
        return randomMap;
    }

    private static String promossi(List<Studente> listAlunni) {
        if (listAlunni.size() == 0) {
            return "Non ci sono promossi in questa Scuola";
        } else if (listAlunni.size() == 1) {
            return "Il promosso in questa Scuola e': \n" + listAlunni;
        } else {
            return "I promossi in questa Scuola sono: \n" + listAlunni;
        }
    }


}
