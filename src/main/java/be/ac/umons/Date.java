package be.ac.umons;

public class Date {
    int annee = 0;
    int mois = 0;
    int jour = 0;
    int heure = 0;
    int minute = 0;

    public Date(int annee, int mois, int jour, int heure, int minute){
        this.annee = annee;
        this.mois = mois;
        this.jour = jour;
        this.heure = heure;
        this.minute = minute;
    }

    public Date(int annee, int mois, int jour, int heure){
        this.annee = annee;
        this.mois = mois;
        this.jour = jour;
        this.heure = heure;
    }

    public Date(int annee, int mois, int jour){
        this.annee = annee;
        this.mois = mois;
        this.jour = jour;
    }

    public Date(int annee, int mois){
        this.annee = annee;
        this.mois = mois;
    }

    public Date(int annee){
        this.annee = annee;
    }

    /*public void setAnnee(int annee) {
        this.annee = annee;
    }

    public void setMois(int mois) {
        this.mois = mois;
    }

    public void setJour(int jour) {
        this.jour = jour;
    }

    public void setHeure(int heure) {
        this.heure = heure;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }*/

    public int getAnnee() {
        return annee;
    }

    public int getMois() {
        return mois;
    }

    public int getJour() {
        return jour;
    }

    public int getHeure() {
        return heure;
    }

    public int getMinute() {
        return minute;
    }

    public Date add(Date duree){
        Date nouv = new Date(this.annee + duree.getAnnee(), this.mois + duree.getMois(),
                this.jour + duree.getJour(), this.heure + duree.getHeure(),
                this.minute + duree.getMinute());
        return nouv;
    }

    public Date diff(Date duree){
        Date nouv = new Date(this.annee - duree.getAnnee(), this.mois - duree.getMois(),
                this.jour - duree.getJour(), this.heure - duree.getHeure(),
                this.minute - duree.getMinute());
        return nouv;
    }

    public String toString(){
        return (this.jour + "/" + this.mois + "/" + this.annee + "   " + this.heure + "h" + this.minute);
    }

    public boolean testSupp(Date deadline){
        if (this.annee > deadline.getAnnee()){ return true; }
        else if (this.mois > deadline.getMois()) { return true; }
        else if (this.jour > deadline.getJour()) { return true; }
        else if (this.heure > deadline.getHeure()) { return true; }
        else if (this.minute > deadline.getMinute()) { return true; }
        else {return false;}
    }

    public boolean testMemeJour(Date comp){
        if ((this.annee == comp.getAnnee()) && (this.mois == comp.getMois()) && (this.jour == comp.getJour())){
            return true;
        }
        else{return false;}
    }
}
