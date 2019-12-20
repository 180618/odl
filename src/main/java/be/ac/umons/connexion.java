package be.ac.umons;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.util.Properties;
import java.util.Vector;

public class connexion  {
    private Stage primaryStage;
    private Pane rootLayout;

    @FXML
    private TextField pseudo;

    @FXML
    private TextField mdp;

    @FXML
    private Button connexion;

    @FXML
    protected void handleSubmitButton(ActionEvent event) {
        Window owner = connexion.getScene().getWindow();
        Vector<Worker> workers = new Vector<Worker>(0);
        workers.addElement(new Worker("aze", "rty"));


        if (pseudo.getText().isEmpty()) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error", "Identifiant manquant");
            return;
        }
        else if (mdp.getText().isEmpty()) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error", "Mot de passe manquant");
            return;
        }
        else{
            for(int i = 0; i < workers.size(); i++) {
                String var1 = this.pseudo.getText();
                String var2 = this.pseudo.getText();
                if (var1 == var2){
                    System.out.println("!!!");
                }
                if ((workers.get(i).getNom() == this.pseudo.getText()) && (workers.get(i).getMDP() == this.mdp.getText())) {
                    App ex = new App();
                    ex.showPage("accueil.fxml", "Accueil");
                }
                App ex = new App();
                ex.showPage("accueil.fxml", "Accueil");
            }
        }

    }



}
