package rps.controllers;

import java.io.IOException;

import javafx.application.Platform;
import javafx.fxml.FXML;
import rps.App;

public class MenuController {

    @FXML
    private void switchToGameOptions() throws IOException {
        App.setRoot("gameoptions");
    }

    @FXML
    private void switchToAbout() throws IOException {
        App.setRoot("about");
    }

    @FXML
    private void exitGame() {
        Platform.exit();
    }
}
