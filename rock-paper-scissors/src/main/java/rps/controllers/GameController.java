package rps.controllers;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import rps.App;
import rps.model.*;

public class GameController {
    private Game game;
    private int currentRound;
    private int totalRounds;
    private Player humanPlayer;
    private ScoreBoard scoreBoard;

    @FXML private Label roundLabel;
    @FXML private Label predictedMoveLabel;
    @FXML private Label computerMoveLabel;
    @FXML private Label roundWinnerLabel;
    @FXML private Label humanWinsLabel;
    @FXML private Label computerWinsLabel;
    @FXML private Label tiesLabel;
    @FXML private Label humanMoveLabel;

    @FXML private Button rockButton;
    @FXML private Button paperButton;
    @FXML private Button scissorsButton;

    @FXML
    void initialize() {
        resetGame();
    }

    @FXML
    public void switchToMenu() throws IOException {
        App.setRoot("menu");
    }

    @FXML
    private void handleRock() {
        playRound(Move.ROCK);
    }

    @FXML
    private void handlePaper() {
        playRound(Move.PAPER);
    }

    @FXML
    private void handleScissors() {
        playRound(Move.SCISSORS);
    }

    private void playRound(Move move) {
        if (currentRound > totalRounds) {
            return;
        }

        RoundData data = game.playRound(move);

        humanMoveLabel.setText(data.getHumanMove().toString());
        predictedMoveLabel.setText(
                data.getPredictedMove() == null ? "N/A" : data.getPredictedMove().toString()
        );
        computerMoveLabel.setText(data.getComputerMove().toString());
        roundWinnerLabel.setText(data.getResult().toString());

        humanWinsLabel.setText(String.valueOf(data.getHumanWins()));
        computerWinsLabel.setText(String.valueOf(data.getComputerWins()));
        tiesLabel.setText(String.valueOf(data.getTies()));

        if (currentRound == totalRounds) {
            roundLabel.setText("Game Over");
            rockButton.setDisable(true);
            paperButton.setDisable(true);
            scissorsButton.setDisable(true);
            return;
        }

        currentRound++;
        roundLabel.setText("Round: " + currentRound + " / " + totalRounds);
    }

    @FXML
    private void handleResetGame() {
        resetGame();
    }

    private void resetGame() {
        this.currentRound = 1;
        this.totalRounds = App.getSelectedRounds();

        GameData gameData = new GameData();
        this.humanPlayer = new HumanPlayer();
        Player computerPlayer = new ComputerPlayer(
                ComputerStrategyFactory.createStrategy("-m", gameData)
        );

        this.scoreBoard = new ScoreBoard();
        GameLogic gameLogic = new GameLogic();
        this.game = new Game(humanPlayer, computerPlayer, scoreBoard, gameLogic);

        rockButton.setDisable(false);
        paperButton.setDisable(false);
        scissorsButton.setDisable(false);

        roundLabel.setText("Round: 1 / " + totalRounds);
        humanMoveLabel.setText("");
        predictedMoveLabel.setText("");
        computerMoveLabel.setText("");
        roundWinnerLabel.setText("");
        humanWinsLabel.setText("0");
        computerWinsLabel.setText("0");
        tiesLabel.setText("0");
    }
}
