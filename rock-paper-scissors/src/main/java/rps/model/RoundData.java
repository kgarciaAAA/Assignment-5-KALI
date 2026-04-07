package rps.model;

public class RoundData {
    private final Move humanMove;
    private final Move predictedMove;
    private final Move computerMove;
    private final Result result;
    private final int humanWins;
    private final int computerWins;
    private final int ties;

    public RoundData(Move humanMove, Move predictedMove, Move computerMove,
                     Result result, int humanWins, int computerWins, int ties) {
        this.humanMove = humanMove;
        this.predictedMove = predictedMove;
        this.computerMove = computerMove;
        this.result = result;
        this.humanWins = humanWins;
        this.computerWins = computerWins;
        this.ties = ties;
    }

    public Move getHumanMove() {
        return humanMove;
    }

    public Move getPredictedMove() {
        return predictedMove;
    }

    public Move getComputerMove() {
        return computerMove;
    }

    public Result getResult() {
        return result;
    }

    public int getHumanWins() {
        return humanWins;
    }

    public int getComputerWins() {
        return computerWins;
    }

    public int getTies() {
        return ties;
    }
}