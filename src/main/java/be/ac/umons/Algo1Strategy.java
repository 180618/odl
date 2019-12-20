package be.ac.umons;
// On prend le premier Worker qu'on trouve qui a le skill nécessaire et qui a le temps de la faire
// et on lui attribue la tâche

import java.util.Vector;

public class Algo1Strategy implements Strategy {
    @Override
    public void executionAlgo(Task tache, Vector<Worker> worker, Date dateActuelle){
        Skill competence = tache.getCompetence();
        Date tempsRestant;
        Date tempsRestant2;
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
                            worker.get(i).addTache(tache);
                            return;
                        }
                    }
                    if (worker.get(i).getTaches().size() == 0) {
                        worker.get(i).addTache(tache);
                        return;
                    }
                    // temps restant : deadline - dateactuelle - tempsAccomplissementTache
                    // Partir de la plus grande deadline et calculer le temps restant
                    // Passer à la deadline suivante
                    // Si le temps restant de la tache 1 est plus petit que l'intervalle entre les deux deadline :
                        // Ok, on boucle
                    // Si pas le cas :
                        // temps restant 2 : deadline - dateactuelle - tempsAccomplissementTache
                        // temps restant 2 = temps restant 2 - (intervalle entre les deux deadlines - temps restant 1)

                }
            }
        }
        System.out.println("La tâche \"" + tache.getNom() + "\" n'a pas pu être attribuée");
    }
}
