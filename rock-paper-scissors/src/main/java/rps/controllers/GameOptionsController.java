package rps.controllers;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import rps.App;

public class GameOptionsController {
    @FXML
    private ComboBox<Integer> numRoundComboBox;

    @FXML
    public void initialize() {
        numRoundComboBox.getItems().addAll(5, 10, 15, 20, 25, 50, 100);
        numRoundComboBox.setValue(20);
    }

    public int getSelectedRounds() {
        return numRoundComboBox.getValue();
    }

    @FXML
    public void switchToGame() throws IOException{
        App.setRoot("game");
    }

    @FXML
    public void switchToMenu() throws IOException {
        App.setRoot("menu");
    }

}