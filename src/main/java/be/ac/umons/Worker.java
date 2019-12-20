package be.ac.umons;
import java.util.*;
// Pour addCompetence : pas moyen de lui passer un String directement plutôt que de créer un skill intermédiaire ?
// Récupérer l'id du chef d'équipe pour classe Projet

public class Worker {
    private String nom;
    private String mdp;
    private Vector<Skill> competence;
    private Vector<Task> taches;
    private List<Observer> observers;

    public Worker(String nom, String mdp){
        this.nom = nom;
        this.mdp = mdp;
        this.taches = new Vector<Task>(0);
        this.competence = new Vector<Skill>(0);
        this.observers = new ArrayList<Observer>();
    }

    public void setNom(String nom){ notifyAllObservers(this.nom + " est devenu \"" + nom + "\" ! "); this.nom = nom; }
    public String getNom(){ return nom; }

    public void setMDP(String mdp){ this.mdp = mdp; }
    public String getMDP(){ return mdp; }

    //public void setMCompetence(Skill comp){ this.competence = comp; }
    public Vector<Skill> getCompetence(){ return competence; }
    public void addCompetence(Skill comp){
        this.competence.addElement(comp);
        notifyAllObservers(this.nom + " a aquis la compétence \"" + comp.getNom() + "\" ! ");
    }
    public void deleteCompetence(Skill comp){
        notifyAllObservers(this.nom + " a perdu la compétence \"" + comp.getNom() + "\"");
        competence.remove(comp);
    }

    public Vector<Task> getTaches() { return taches; }
    public void addTache(Task tache){
        this.taches.addElement(tache);
        //triDesTachesParDeadline();
        for (int i = 0; i < taches.size(); i++) {
            if (tache.getDeadline().testSupp(taches.get(i).getDeadline()) && !tache.getDeadline().testSupp(taches.get(i+1).getDeadline())) {
                this.taches.insertElementAt(tache, i);
            }
        }
        notifyAllObservers("La tâche \"" + tache.getNom() + "\" a été attribuée à : " + this.nom);
    }
    public void deleteTache(Task tache){ taches.remove(tache);}

    public void attach(Observer observer){this.observers.add(observer);}
    private void notifyAllObservers(String texte){
        for (Observer observer : observers){
            observer.notif(texte);
        }
    }

    public void affichage(){
        System.out.println("Nom : " + this.nom);
        for (int i = 0; i < this.taches.size(); i++) {
            this.taches.get(i).affichage();
        }
    }

    /*public void triDesTachesParDeadline(){
        Vector<Task> nouv = new Vector<Task>(0);
        boolean test;
        while (nouv.size() < taches.size()) {
            for (int i = 0; i < taches.size(); i++) {
                test = true;
                for (int j = 0; j < taches.size(); j++) {
                    if (!taches.get(i).getDeadline().testSupp(taches.get(j).getDeadline())) { test = false; }
                }
                if (test == true){
                    nouv.addElement(taches.get(i));
                }
            }
        }
        taches = nouv;
    }*/
}
