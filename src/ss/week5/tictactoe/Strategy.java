package ss.week5.tictactoe;

import ss.week4.tictactoe.Board;
import ss.week4.tictactoe.Mark;

public interface Strategy {
    public String getName();
    public int determineMove (Board board, Mark mark);
}
