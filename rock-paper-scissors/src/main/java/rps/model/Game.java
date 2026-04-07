package rps.model;

public class Game {
    private final Player humanPlayer;
    private final Player computerPlayer;
    private final ScoreBoard scoreBoard;
    private final GameLogic gameLogic;

    public Game(Player humanPlayer, Player computerPlayer,
                ScoreBoard scoreBoard, GameLogic gameLogic) {
        this.humanPlayer = humanPlayer;
        this.computerPlayer = computerPlayer;
        this.scoreBoard = scoreBoard;
        this.gameLogic = gameLogic;
    }

    public RoundData playRound(Move humanMove) {
        if (humanPlayer instanceof HumanPlayer human) {
            human.setHumanPlayerMove(humanMove);
        }

        Move predictedMove = null;
        if (computerPlayer instanceof ComputerPlayer computer) {
            predictedMove = computer.getPredictedMove();
        }

        GameRound gameRound = new GameRound(humanPlayer, computerPlayer, gameLogic);

        Move actualHumanMove = gameRound.getHumanMove();
        Move computerMove = gameRound.getComputerMove();
        Result result = gameRound.getRoundResult();

        computerPlayer.processRound(actualHumanMove, computerMove);
        scoreBoard.recordResult(result);

        return new RoundData(
                actualHumanMove,
                predictedMove,
                computerMove,
                result,
                scoreBoard.getHumanWins(),
                scoreBoard.getComputerWins(),
                scoreBoard.getTies()
        );
    }
}
