package be.ac.umons;
import java.util.*;

public class Ressource implements Component
{
    private String nom;
    private String lieu;
    Vector<SousRessource> contenu = new Vector<SousRessource>(0);
    private List<Observer> observers;

    Ressource( String nom, String lieu)
    {
        this.nom =  nom;
        this.lieu = lieu;
        this.observers = new ArrayList<Observer>();
    }
    public void setNom(String nom)
    {
        this.nom=nom;
        notifyAllObservers("La ressource \"" + this.nom + "\" a changé de nom et s'appelle maintenant \"" + nom + "\"");
    }
    public String getNom(){ return nom;}

    public String getLieu() { return lieu; }
    public void setLieu(String lieu) {
        this.lieu = lieu;
        notifyAllObservers("La ressource \"" + this.nom + "\" a changé de place et se trouve maintenant à l'endroit : " + this.lieu);
    }

    public void addcontenu (SousRessource contenu)
    {
        this.contenu.addElement(contenu);
        notifyAllObservers("La ressource \"" + contenu.getNom() + "\" a été ajoutée à " + this.nom);
    }
    public void removecontenu ( SousRessource contenu)
    {
        this.contenu.removeElement(contenu);
        notifyAllObservers("La ressource \"" + contenu + "\" a été retirée de " + this.nom);
    }

    public void affichage(){
        System.out.println("La ressource " + this.nom + " se trouve à l'endroit : " + this.lieu);
        if (contenu.size() != 0){
            System.out.println("Elle contient : ");
            for (int i = 0; i < contenu.size(); i++){
                contenu.get(i).affichage();
            }
        }
    }

    public void attach(Observer observer){this.observers.add(observer);}
    private void notifyAllObservers(String texte){
        for (Observer observer : observers){
            observer.notif(texte);
        }
    }

}
