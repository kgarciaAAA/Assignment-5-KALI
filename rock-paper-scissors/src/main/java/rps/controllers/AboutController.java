package rps.controllers;

import java.io.IOException;

import javafx.fxml.FXML;
import rps.App;

public class AboutController {
    @FXML
    private void switchToMenu() throws IOException {
        App.setRoot("menu");
    }
}
