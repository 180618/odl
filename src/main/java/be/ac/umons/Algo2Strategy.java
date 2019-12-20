package be.ac.umons;

// On va chercher le worker qui a le plus de temps libre avant la deadline parmis ceux qui ont le skill nécessaire
// et on lui attribue la tâche

//Pour les deux algorithmes, on a considéré qu'on attribuait la tâche à quelqu'un même si la durée estimée était trop
//longue par rapport à la deadline

import java.util.Vector;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Algo2Strategy implements Strategy {
    @Override
    public void executionAlgo(Task tache, Vector<Worker> worker, Date dateActuelle){
        //copier-coller algo1 mais au lieu d'attribuer dés que la condition sur le temps restant est respectée
        //on enregistre le temps restant et l'indice du worker et on les compare tous à la fin
        Skill competence = tache.getCompetence();
        Date tempsRestant;
        Date tempsRestant2;
        Map<Integer, Date> workersPotentiels = new HashMap<>();
        for (int i = 0; i < worker.size(); i++){
            for (int j = 0; j < worker.get(i).getCompetence().size(); j++) {
                if (worker.get(i).getCompetence().get(j) == competence) {
                    if (worker.get(i).getTaches().size() > 0) {
                        tempsRestant = worker.get(i).getTaches().get(0).getDeadline().diff(dateActuelle);
                        tempsRestant = tempsRestant.diff(worker.get(i).getTaches().get(0).getDureeAttendue());
                        for (int k = 1; k < worker.get(i).getTaches().size() - 1; k++) {
                            if (!worker.get(i).getTaches().get(k).getDeadline().diff(worker.get(i + 1).getTaches().get(k).getDeadline()).testSupp(tempsRestant)) {
                                tempsRestant2 = worker.get(i).getTaches().get(k).getDeadline().diff(dateActuelle);
                                tempsRestant2 = tempsRestant.diff(worker.get(i).getTaches().get(k).getDureeAttendue());
                                tempsRestant2 = tempsRestant2.diff((worker.get(i).getTaches().get(k).getDeadline().diff(worker.get(i + 1).getTaches().get(k).getDeadline()).diff(tempsRestant)));
                            } else {
                                tempsRestant2 = worker.get(i).getTaches().get(k).getDeadline().diff(dateActuelle);
                                tempsRestant2 = tempsRestant.diff(worker.get(i).getTaches().get(k).getDureeAttendue());
                            }
                            tempsRestant = tempsRestant2;
                        }
                        if (tempsRestant.testSupp(tache.getDureeAttendue())) {
                            workersPotentiels.put(i, tempsRestant);
                            //worker.get(i).addTache(tache);
                        }
                    }
                    if (worker.get(i).getTaches().size() == 0) {
                        //worker.get(i).addTache(tache);
                        workersPotentiels.put(i, new Date(999999999));
                    }

                }
            }
        }
        Set<Map.Entry<Integer, Date>> setWP = workersPotentiels.entrySet();
        Iterator<Entry<Integer, Date>> it = setWP.iterator();
        if (!it.hasNext()){
            System.out.println("La tâche \"" + tache.getNom() + "\" n'a pas pu être attribuée");
            return;
        }
        int maxId = -1;
        Date maxTemps = new Date(-1);
        while(it.hasNext()){
            Entry<Integer, Date> element = it.next();
            if (element.getValue().testSupp(maxTemps)){
                //System.out.println(element.getValue() + ">" + maxTemps);
                maxId = element.getKey();
                maxTemps = element.getValue();
            }
        }
        worker.get(maxId).addTache(tache);
    }


}
