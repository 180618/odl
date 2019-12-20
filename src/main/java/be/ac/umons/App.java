package be.ac.umons;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Vector;

public class App extends Application
{
    private Stage primaryStage;
    private Pane rootLayout;

    private ObservableList<Task> taskData = FXCollections.observableArrayList();

    public App() {
        Skill comp1 = new Skill("Expelliarmus");
        Skill comp2 = new Skill("Ne pas se couper en manipulant un crochet de serpent");
        Skill comp3 = new Skill("Mettre un chapeau");

        Vector<Worker> workers = new Vector<Worker>(0);
        workers.addElement(new Worker("Harry Potter", "Tarte à la mélasse"));
        workers.addElement(new Worker("Ron Weasley", "Limace"));
        workers.addElement(new Worker("Hermione Granger", "Bibliothèque"));
        workers.addElement(new Worker("Neville Longdubas", "Mimbulus Mimbeltonia"));
        for (int i = 0; i < workers.size(); i++){
            new NotifObserver(workers.get(i));
        }

        Team equipe1 = new Team("AD", workers, workers.get(0));
        Projet projet1 = new Projet("Projet 7e année", equipe1);
        Task tache1 = new Task("Sauver le monde partie 2", "Tuer Nagini",new Date(0,0, 0, 0, 5),new Date(1998,5, 2, 23, 59),comp3, "Poudlard, cour", projet1);
        Task tache2 = new Task("Sauver le monde partie 3", "Tuer Voldemort",new Date(0,0, 0, 0, 30),new Date(1998,5, 2, 23, 59),comp1, "Poudlard, grande salle", projet1);
        Task tache3 = new Task("Sauver le monde partie 1", "Détruire la coupe d'Helga Poufsouffle",new Date(0,0, 0, 0, 2),new Date(1998,5, 2, 23, 59),comp2, "Poudlard, chambre des secrets", projet1);
        Task tache4 = new Task("Sauver le monde partie 4", "Espionner Voldemort",new Date(0,0, 0, 0, 1 ),new Date(1998,5, 2, 23, 59),comp1, "Cabane hurlante", projet1);

        tache1.setEntry(new AgendaEntry(new Date (1998, 5, 2, 10), new Date (1998, 5, 2, 14)));
        tache2.setEntry(new AgendaEntry(new Date (1998, 5, 4, 10), new Date (1998, 5, 4, 14)));
        tache3.setEntry(new AgendaEntry(new Date (1998, 5, 6, 11), new Date (1998, 5, 6, 14)));
        tache4.setEntry(new AgendaEntry(new Date (1998, 5, 3, 10), new Date (1998, 5, 3, 14)));

        taskData.add(tache1);
        taskData.add(tache2);
        taskData.add(tache3);
        taskData.add(tache4);
        taskData.add(tache4);
    }

    public ObservableList<Task> getTaskData() {
        return taskData;
    }

    @Override
    public void start(Stage stage) throws Exception {

        this.primaryStage = stage;
        this.primaryStage.setTitle("JavaFX Sample App");

        showConnexion();
    }

    public void showConnexion() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("connexion.fxml"));

            rootLayout = loader.load();

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showPage(String nom, String titre) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource(nom));
            Pane accueil = (Pane) loader.load();

            Stage nouv = new Stage();
            nouv.setTitle(titre);
            Scene scene = new Scene(accueil);
            nouv.setScene(scene);
            nouv.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showAgenda() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("agenda.fxml"));
            Pane accueil = (Pane) loader.load();

            agenda controller = loader.getController();
            controller.setApp(this);

            Stage nouv = new Stage();
            nouv.setTitle("Agenda");
            Scene scene = new Scene(accueil);
            nouv.setScene(scene);
            nouv.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args )
    {
        System.out.println( "Hello World!" );

        Vector<Worker> workers = new Vector<Worker>(0);
        Skill comp1 = new Skill("Expelliarmus");
        Skill comp2 = new Skill("Ne pas se couper en manipulant un crochet de serpent");
        Skill comp3 = new Skill("Mettre un chapeau");
        Skill comp4 = new Skill("d");
        Skill comp5 = new Skill("e");

        workers.addElement(new Worker("Harry Potter", "Tarte à la mélasse"));
        workers.addElement(new Worker("Ron Weasley", "Limace"));
        workers.addElement(new Worker("Hermione Granger", "Bibliothèque"));
        workers.addElement(new Worker("Neville Longdubas", "Mimbulus Mimbeltonia"));
        for (int i = 0; i < workers.size(); i++){
            new NotifObserver(workers.get(i));
        }
        workers.get(0).addCompetence(comp1);
        workers.get(2).addCompetence(comp2);
        workers.get(2).addCompetence(comp1);
        workers.get(3).addCompetence(comp3);

        Manager manager = new Manager("Albus Dumbledore", "Sorbet Citron");
        Team equipe1 = new Team("AD", workers, workers.get(0));
        Projet projet1 = new Projet("Projet 7e année", equipe1);
        Task tache1 = new Task("Sauver le monde partie 2", "Tuer Nagini",new Date(0,0, 0, 0, 5),new Date(1998,5, 2, 23, 59),comp3, "Poudlard, cour", projet1);
        Task tache2 = new Task("Sauver le monde partie 3", "Tuer Voldemort",new Date(0,0, 0, 0, 30),new Date(1998,5, 2, 23, 59),comp1, "Poudlard, grande salle", projet1);
        Task tache3 = new Task("Sauver le monde partie 1", "Détruire la coupe d'Helga Poufsouffle",new Date(0,0, 0, 0, 2),new Date(1998,5, 2, 23, 59),comp2, "Poudlard, chambre des secrets", projet1);
        Task tache4 = new Task("Sauver le monde partie 4", "Espionner Voldemort",new Date(0,0, 0, 0, 1 ),new Date(1998,5, 2, 23, 59),comp1, "Cabane hurlante", projet1);
        tache1.executeStrat(new Algo2Strategy(), workers);
        tache2.executeStrat(new Algo2Strategy(), workers);
        tache3.executeStrat(new Algo2Strategy(), workers);
        tache4.executeStrat(new Algo2Strategy(), workers);
        for (int i = 0; i < workers.size(); i++) {
            System.out.println();
            workers.get(i).affichage();
        }

        Ressource ress = new Ressource("Choipeaux", "Poudlard");
        new NotifObserver(ress);
        ress.addcontenu(new SousRessource("Epée de Godric Gryffondor"));
        ress.affichage();/*

        AgendaEntry entry = new AgendaEntry(start, end);

        tache.setEntry(entry);
        tache.affichage();*/

        Application.launch(args);
    }
}
