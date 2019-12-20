package be.ac.umons;

public class Manager
{
    private String nom;
    private String mdp;

    Manager(String nom, String mdp)
    {
        this.nom = nom;
        this.mdp = mdp;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getNom() {
        return nom;
    }
    public String toString(){
        return "Nom : " + nom;
    }
}
