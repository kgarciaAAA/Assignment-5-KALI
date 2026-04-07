package rps.model;

public interface ComputerStrategy {
    Move computerStrategyMove();

    default Move getPredictedMove() {
        return null; // Random strategy has no prediction
    }

    default void addGameRoundHistory(Move playerMove, Move computerMove) {}

    default void saveData() {}
}