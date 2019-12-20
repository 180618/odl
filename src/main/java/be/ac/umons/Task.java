package be.ac.umons;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.*;


public class Task {
    //private final StringProperty firstName;
    private String nom;
    private String description;
    private Date dureeAttendue;
    private Date deadline;
    private Skill competence;
    private Vector<Ressource> ressources;
    private String lieu;
    private Projet projet;
    private AgendaEntry entry;
    private List<Observer> observers;

    public Task(String nom, String description, Date duree, Date deadline, Skill comp, String lieu, Projet projet){
        //this.firstName = new SimpleStringProperty(nom);
        this.nom = nom;
        this.description = description;
        this.deadline = deadline;
        this.dureeAttendue = duree;
        this.competence = comp;
        ressources = new Vector<Ressource>(0);
        this.lieu = lieu;
        this.projet = projet;
        this.observers = new ArrayList<Observer>();
    }

    public void setNom(String nom){ notifyAllObservers("La tâche \"" + this.nom + "\" est devenu \"" + nom + "\""); this.nom = nom; }
    public String getNom(){ return nom; }
    public StringProperty getNomPr(){ return new SimpleStringProperty(nom); }



    public void setDescription(String description){
        this.description = description;
        notifyAllObservers("La description de la tâche \"" + this.nom + " a été modifiée et est à présent : \"" + description + "\"");
    }
    public String getDescription(){ return description; }

    public void setDureeAttendue(Date duree){
        this.dureeAttendue = duree;
        notifyAllObservers("La durée attendue de la tâche \"" + this.nom + " a été modifiée et est à présent : \"" + duree + "\"");
    }
    public Date getDureeAttendue(){ return dureeAttendue; }

    public void setDeadline(Date date){
        this.deadline = date;
        notifyAllObservers("La deadline de la tâche \"" + this.nom + " a été modifiée et est à présent : \"" + deadline + "\"");
    }
    public Date getDeadline(){ return deadline; }

    public void addRessource(Ressource ress){
        this.ressources.addElement(ress);
        notifyAllObservers("La tâche \"" + this.nom + " nécessite maintenant la ressource : \"" + ress.getNom() + "\"");
    }
    public void deleteRessource(Ressource ress){
        ressources.remove(ress);
        notifyAllObservers("La tâche \"" + this.nom + " ne nécessite plus la ressource : \"" + ress.getNom() + "\"");
    }

    //public void addCompetence(Skill comp){ this.competences.addElement(comp); }
    //public void deleteCompetence(Skill comp){ competences.remove(comp); }

   //public void setCompetence(Skill competence) { this.competence = competence; }
    public Skill getCompetence() { return competence; }

    public void setLieu(String lieu){
        this.lieu = lieu;
        notifyAllObservers("Le lieu de la tâche \"" + this.nom + " a été modifiée et est à présent : \"" + this.lieu + "\" ! ");
    }
    public String getLieu(){ return lieu; }

    public void setEntry(AgendaEntry entry){
        this.entry = entry;
        notifyAllObservers("La période durant laquelle la tâche \"" + this.nom +
                " sera effectuée a été modifiée et est à présent fixée entre le " + this.entry.getStart_time() +
                "et le " + this.entry.getEnd_time());
    }
    public AgendaEntry getEntry(){ return entry; }

    public void affichage(){
        System.out.println("Tâche : " + nom + "\n" + description + "\nDurée attendue (en heures) : " + dureeAttendue);
        System.out.println("Deadline : " + deadline + "\nLieu : " + lieu);
        if(entry != null){
            System.out.println(entry);
        }
        System.out.println("Compétence nécessaire : " + competence);
        //for (int i = 0; i < competences.size(); i++){
            //System.out.println("- " + competences.get(i));
        //}
    }

    public void executeStrat(Strategy strat, Vector<Worker> worker){
        strat.executionAlgo(this, worker, new Date(1998, 5, 2, 23, 0));
    }


    public void attach(Observer observer){this.observers.add(observer);}
    private void notifyAllObservers(String texte){
        for (Observer observer : observers){
            observer.notif(texte);
        }
    }
}
