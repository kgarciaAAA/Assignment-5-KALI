package rps.model;

public interface ComputerStrategy {
    Move computerStrategyMove();
    default void addGameRoundHistory(Move playerMove, Move computerMove) {}
    default Move getPredictedMove() {return null;}
}