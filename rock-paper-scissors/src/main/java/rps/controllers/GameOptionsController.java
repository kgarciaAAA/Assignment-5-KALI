package rps.controllers;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import rps.App;

public class GameOptionsController {
    @FXML
    private ComboBox<Integer> numRoundsComboBox;

    @FXML
    public void initialize() {
        numRoundsComboBox.getItems().addAll(5, 10, 15, 20, 25, 50, 100);
        numRoundsComboBox.setValue(20);
    }

    public int getSelectedRounds() {
        return numRoundsComboBox.getValue();
    }

    @FXML
    public void switchToGame() throws IOException{
        App.setRoot("game");
    }
}