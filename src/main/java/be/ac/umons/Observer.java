package be.ac.umons;

public abstract class Observer {
    protected Worker worker;
    protected Ressource ress;
    protected Task tache;
    public abstract void notif(String texte);
}
