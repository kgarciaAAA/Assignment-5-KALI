package rps.controllers;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import rps.App;
import rps.model.ComputerPlayer;
import rps.model.ComputerStrategyFactory;
import rps.model.Game;
import rps.model.GameData;
import rps.model.GameLogic;
import rps.model.HumanPlayer;
import rps.model.Player;
import rps.model.ScoreBoard;

public class GameController {
    private Game game;
    private Integer totalRounds;
    private Integer currentRound;
    private Player humanPlayer;
    //private GameRound gameRound;
    private ScoreBoard scoreBoard;

    @FXML
    private Label roundLabel;
    
    @FXML
    private Label humanMoveLabel;

    @FXML
    private Label predictedMoveLabel;

    @FXML
    private Label computerMoveLabel;

    @FXML
    private Label computerWinsLabel;

    @FXML
    private Label humanWinsLabel;

    @FXML
    private Label tiesLabel;

    @FXML
    private Button rockButton;

    @FXML
    private Button paperButton;

    @FXML
    private Button scissorsButton;

    @FXML
    void intialize() {
        this.totalRounds = 20;
        this.currentRound = 1;
        GameData gameData = new GameData();
        this.humanPlayer = new HumanPlayer();
        Player computerPlayer = new ComputerPlayer(ComputerStrategyFactory.createStrategy("-m", gameData));
        ScoreBoard scoreBoard = new ScoreBoard();
        GameLogic gameLogic = new GameLogic();
        this.game = new Game(humanPlayer, computerPlayer, scoreBoard, gameLogic);
    }

    @FXML
    public void switchToMenu() throws IOException{
        App.setRoot("menu");
    }

}
