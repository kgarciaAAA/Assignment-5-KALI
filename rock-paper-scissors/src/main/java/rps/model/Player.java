package rps.model;

public abstract class Player {
    public abstract Move getPlayerMove();
    public void setPlayerMove(Move playerMove){};
    public void processRound(Move playerMove, Move computerMove){}
    public Move getPredictedMove(){return null;}
}
