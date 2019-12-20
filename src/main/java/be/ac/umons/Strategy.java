package be.ac.umons;
import java.util.*;

public interface Strategy {
    public void executionAlgo(Task tache, Vector<Worker> worker, Date dateActuelle);
}
