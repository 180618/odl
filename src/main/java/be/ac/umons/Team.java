package be.ac.umons;
import java.util.*;

public class Team {
    private String nom;
    private Vector<Worker> membres;
    private Worker chef;

    public Team(String nom, Vector<Worker> employes, Worker chef){
        this.nom = nom;
        this.membres = employes;
        this.chef = chef;
    }

    public void setNom(String nom, Vector<Worker> membres){
        this.nom = nom;
        this.membres = membres;
    }
    public String getNom(){ return nom; }
    public void addMembre(Worker memb){ membres.addElement(memb); }
    public void deleteMembre(Worker memb){ membres.remove(memb);}
    public Worker get_chef() {
        return chef;
    }

    public void affichage(){
        System.out.println("Nom : " + this.nom + "\nChef : ");
        System.out.println(this.chef + "Membres de l'équipe : \n" + this.membres);
    }
}
