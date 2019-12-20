package be.ac.umons;

import java.util.Vector;

public class SousRessource implements Component {
    private String nom;
    Vector<Ressource> contenu = new Vector<Ressource>(0);
    SousRessource( String nom)
    {
        this.nom =  nom;
    }
    public void setNom(String nom)
    {
        this.nom=nom;
    }
    public String getNom(){ return nom;}

    public void affichage(){
        System.out.println(this.nom);
    }
}
