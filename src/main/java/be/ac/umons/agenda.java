package be.ac.umons;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.Vector;

public class agenda {
    @FXML
    private Label titre;

    @FXML
    private Label description;

    @FXML
    private Label lieu;

    @FXML
    private Label deadline;

    @FXML
    private Button retour;

    @FXML
    private Button attente;

    @FXML
    private Button modifier;

    @FXML
    private TableView<Task> j0;

    @FXML
    private TableView<Task> j1;

    @FXML
    private TableView<Task> j2;

    @FXML
    private TableView<Task> j3;

    @FXML
    private TableView<Task> j4;

    @FXML
    private TableView<Task> j5;

    @FXML
    private TableView<Task> j6;

    @FXML
    private TableColumn<Task, String> j0c;

    @FXML
    private TableColumn<Task, String> j1c;

    @FXML
    private TableColumn<Task, String> j2c;

    @FXML
    private TableColumn<Task, String> j3c;

    @FXML
    private TableColumn<Task, String> j4c;

    @FXML
    private TableColumn<Task, String> j5c;

    @FXML
    private TableColumn<Task, String> j6c;

    private App app;

    public agenda(){

    }

    @FXML
    private void initialize() {
        j0c.setCellValueFactory(cellData -> cellData.getValue().getNomPr());
        j1c.setCellValueFactory(cellData -> cellData.getValue().getNomPr());
        j2c.setCellValueFactory(cellData -> cellData.getValue().getNomPr());
        j3c.setCellValueFactory(cellData -> cellData.getValue().getNomPr());
        j4c.setCellValueFactory(cellData -> cellData.getValue().getNomPr());
        j5c.setCellValueFactory(cellData -> cellData.getValue().getNomPr());
        j6c.setCellValueFactory(cellData -> cellData.getValue().getNomPr());

        showDetailsTache(null);

        j0.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showDetailsTache(newValue)
        );
        j1.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showDetailsTache(newValue)
        );
        j2.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showDetailsTache(newValue)
        );
        j3.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showDetailsTache(newValue)
        );
        j4.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showDetailsTache(newValue)
        );
        j5.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showDetailsTache(newValue)
        );
        j6.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showDetailsTache(newValue)
        );
    }

    private void showDetailsTache(Task tache) {
        if (tache != null) {
            titre.setText(tache.getNom());
            description.setText(tache.getDescription());
            deadline.setText(tache.getDeadline().toString());
            lieu.setText(tache.getLieu());
        } else {
            titre.setText("");
            description.setText("");
            deadline.setText("");
            lieu.setText("");
        }
    }

    public void setApp(App app) {
        Date lundiSemaineActuelle = new Date(1998, 5, 1);
        ObservableList<Task> t0 = FXCollections.observableArrayList();
        ObservableList<Task> t1 = FXCollections.observableArrayList();
        ObservableList<Task> t2 = FXCollections.observableArrayList();
        ObservableList<Task> t3 = FXCollections.observableArrayList();
        ObservableList<Task> t4 = FXCollections.observableArrayList();
        ObservableList<Task> t5 = FXCollections.observableArrayList();
        ObservableList<Task> t6 = FXCollections.observableArrayList();
        this.app = app;
        for (int i = 0; i < app.getTaskData().size(); i++){
            if (app.getTaskData().get(i).getEntry().getStart_time().diff(lundiSemaineActuelle).testMemeJour(new Date(0, 0, 0))){
                t0.add(app.getTaskData().get(i));
            }
            else if (app.getTaskData().get(i).getEntry().getStart_time().diff(lundiSemaineActuelle).testMemeJour(new Date(0, 0, 1))){
                t1.add(app.getTaskData().get(i));
            }
            else if (app.getTaskData().get(i).getEntry().getStart_time().diff(lundiSemaineActuelle).testMemeJour(new Date(0, 0, 2))){
                t2.add(app.getTaskData().get(i));
            }
            else if (app.getTaskData().get(i).getEntry().getStart_time().diff(lundiSemaineActuelle).testMemeJour(new Date(0, 0, 3))){
                t3.add(app.getTaskData().get(i));
            }
            else if (app.getTaskData().get(i).getEntry().getStart_time().diff(lundiSemaineActuelle).testMemeJour(new Date(0, 0, 4))){
                t4.add(app.getTaskData().get(i));
            }
            else if (app.getTaskData().get(i).getEntry().getStart_time().diff(lundiSemaineActuelle).testMemeJour(new Date(0, 0, 5))){
                t5.add(app.getTaskData().get(i));
            }
            else if (app.getTaskData().get(i).getEntry().getStart_time().diff(lundiSemaineActuelle).testMemeJour(new Date(0, 0, 6))){
                t6.add(app.getTaskData().get(i));
            }
            j0.setItems(t0);
            j1.setItems(t1);
            j2.setItems(t2);
            j3.setItems(t3);
            j4.setItems(t4);
            j5.setItems(t5);
            j6.setItems(t6);
        }

    }

    @FXML
    protected void handleSubmitButton(ActionEvent event) {
        App ex = new App();
        ex.showPage("accueil.fxml", "Accueil");
    }

    @FXML
    protected void handleSubmitButton2(ActionEvent event) {

    }

    @FXML
    protected void handleSubmitButton3(ActionEvent event) {

    }
}
