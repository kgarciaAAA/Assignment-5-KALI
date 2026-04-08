package rps.controllers;

import java.io.IOException;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import rps.App;
import rps.model.ComputerPlayer;
import rps.model.ComputerStrategyFactory;
import rps.model.Game;
import rps.model.GameData;
import rps.model.GameLogic;
import rps.model.GameRound;
import rps.model.HumanPlayer;
import rps.model.Move;
import rps.model.Player;
import rps.model.ScoreBoard;

public class GameController {
    private Game game;
    private Integer totalRounds;
    private Integer currentRound;
    private Player humanPlayer;
    private Player computerPlayer;
    private ScoreBoard scoreBoard;

    @FXML private Label roundLabel;
    @FXML private Label humanMoveLabel;
    @FXML private Label predictedMoveLabel;
    @FXML private Label computerMoveLabel;
    @FXML private Label roundWinnerLabel;
    @FXML private Label computerWinsLabel;
    @FXML private Label humanWinsLabel;
    @FXML private Label drawsLabel;
    @FXML private Label gameWinnerLabel;

    @FXML private Button rockButton;
    @FXML private Button paperButton;
    @FXML private Button scissorsButton;

    @FXML private VBox gameOverVBox;


    @FXML 
    public void initialize() {
        this.totalRounds = 20;
        this.currentRound = 1;
        roundLabel.setText("Round: " + currentRound + "/" + totalRounds);
        GameData gameData = new GameData();
        this.humanPlayer = new HumanPlayer();
        this.computerPlayer = new ComputerPlayer(ComputerStrategyFactory.createStrategy("-m", gameData));
        this.scoreBoard = new ScoreBoard();
        GameLogic gameLogic = new GameLogic();
        this.game = new Game(humanPlayer, computerPlayer, scoreBoard, gameLogic, gameData);
    }

    @FXML
    public void handleRock(){
        humanPlayer.setPlayerMove(Move.ROCK);
        updateUI();
    }

    @FXML
    public void handlePaper(){
        humanPlayer.setPlayerMove(Move.PAPER);
        updateUI();
    }

    @FXML
    public void handleScissors(){
        humanPlayer.setPlayerMove(Move.SCISSORS);
        updateUI();
    }


    @FXML
    public void updateUI(){
        GameRound gameRound = game.playRound();
        humanMoveLabel.setText("" + gameRound.getHumanMove());
        if (computerPlayer.getPredictedMove() != null) {
            predictedMoveLabel.setText("" + computerPlayer.getPredictedMove());
        } else {
            predictedMoveLabel.setText("N/A");
        }
        computerMoveLabel.setText("" + gameRound.getComputerMove());
        roundWinnerLabel.setText("" + gameRound.getRoundResult());
        humanWinsLabel.setText("" + scoreBoard.getHumanScore());
        computerWinsLabel.setText("" + scoreBoard.getComputerScore());
        drawsLabel.setText("" + scoreBoard.getDraws());

        if (currentRound < totalRounds) {
            currentRound++;
            roundLabel.setText("Round: " + currentRound + "/" + totalRounds);
        } else {
            gameOver();
        }
        
    }

    @FXML
    public void gameOver() {
        rockButton.setDisable(true);
        paperButton.setDisable(true);
        scissorsButton.setDisable(true);
        gameWinnerLabel.setText("" + scoreBoard.getGameWinner());
        gameOverVBox.setDisable(false);
        gameOverVBox.setOpacity(1.0);
        game.save();
    }

    @FXML 
    public void handlePlayAgain() {
        gameOverVBox.setDisable(true);
        gameOverVBox.setOpacity(0);
        this.currentRound = 1;
        roundLabel.setText("Round: " + currentRound);
        scoreBoard.resetScores();
        humanMoveLabel.setText("N/A");
        predictedMoveLabel.setText("N/A");
        computerMoveLabel.setText("N/A");
        roundWinnerLabel.setText("N/A");
        humanWinsLabel.setText("0");
        computerWinsLabel.setText("0");
        drawsLabel.setText("0");

        rockButton.setDisable(false);
        paperButton.setDisable(false);
        scissorsButton.setDisable(false);

        }

    @FXML
    public void switchToMenu() throws IOException{
        App.setRoot("menu");
    }

    @FXML
    private void exitGame() {
        Platform.exit();
    }

    

}
