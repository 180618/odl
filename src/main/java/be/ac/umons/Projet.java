package be.ac.umons;
import java.util.*;

public class Projet
{
    private String nom;
    Vector<Task> tache = new Vector<Task>(0);
    private Team equipe;


    Projet(String nom, Team equipe)
    {
        this.nom = nom;
        this.equipe = equipe;
    }

    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    public Team getEquipe() {
        return equipe;
    }
    public void setEquipe(Team equipe) {
        this.equipe = equipe;
    }

    public void addtache(Task tache)
    {
        this.tache.addElement(tache);
    }
    public void removetache( Task tache)
    {
        this.tache.removeElement(tache);
    }

    public void affichage(){
        System.out.println("Nom du projet : " + this.nom);
        equipe.affichage();
    }

}
