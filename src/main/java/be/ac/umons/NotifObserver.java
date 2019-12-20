package be.ac.umons;

public class NotifObserver extends Observer {

    public NotifObserver(Worker worker){
        this.worker = worker;
        this.worker.attach(this);
    }

    public NotifObserver(Ressource ress){
        this.ress = ress;
        this.ress.attach(this);
    }

    public NotifObserver(Task tache){
        this.tache = tache;
        this.tache.attach(this);
    }

    public void notif(String texte){
        System.out.println(texte);
    }
}
