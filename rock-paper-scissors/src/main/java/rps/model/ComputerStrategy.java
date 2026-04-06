package rps.model;

public interface ComputerStrategy {
    Move computerStrategyMove();
    default void addGameRoundHistory(Move playerMove, Move computerMove) {}
    default void saveData(){}
    default Move getPredictedHumanMove() { return null; }
}