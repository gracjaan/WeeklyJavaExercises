package ss.week5.tictactoe;

import ss.week4.tictactoe.Board;
import ss.week4.tictactoe.Mark;

import java.util.ArrayList;
import java.util.Collections;

public class ComputerPlayer extends Player{

    private Strategy strategy;
    public ComputerPlayer (Mark mark, Strategy strategy){
        super(strategy.getName() + "-" + mark, mark);
        this.strategy = strategy;
    }

    public ComputerPlayer (Mark mark){
        this(mark, new NaiveStrategy());
    }

    @Override
    public int determineMove(Board board) {
        return strategy.determineMove(board, super.getMark());
    }

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
}
