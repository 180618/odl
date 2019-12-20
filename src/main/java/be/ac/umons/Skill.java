package be.ac.umons;

import java.util.ArrayList;
import java.util.List;

public class Skill {
    private String nom;

    public Skill(String nom){ this.nom = nom; }

    public void setNom(String nom){ this.nom = nom; }
    public String getNom(){ return nom; }
    public String toString(){
        return nom;
    }

}
