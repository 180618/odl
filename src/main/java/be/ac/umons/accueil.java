package be.ac.umons;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Window;

public class accueil  {


    @FXML
    private Button agenda;

    @FXML
    protected void handleSubmitButton(ActionEvent event) {
        Window owner = agenda.getScene().getWindow();
        App ex = new App();
        ex.showAgenda();
    }
}

