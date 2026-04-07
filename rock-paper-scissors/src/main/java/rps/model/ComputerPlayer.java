package rps.model;

public class ComputerPlayer extends Player {
    private final ComputerStrategy strat;

    public ComputerPlayer(ComputerStrategy strat) {
        this.strat = strat;
    }

    @Override
    public Move getPlayerMove() {
        return strat.computerStrategyMove();
    }

    @Override
    public void processRound(Move playerMove, Move computerMove) {
        strat.addGameRoundHistory(playerMove, computerMove);
    }

    @Override
    public void saveData() {
        strat.saveData();
    }

    public Move getPredictedMove() {
        return strat.getPredictedMove();
    }
}