package ss.week5.tictactoe;

import ss.week4.tictactoe.Board;
import ss.week4.tictactoe.Mark;

import java.util.ArrayList;
import java.util.Collections;

public class NaiveStrategy implements Strategy{

    @Override
    public String getName() {
        return "Naive";
    }

    @Override
    public int determineMove(Board board, Mark mark) {
        ArrayList<Integer> collection = new ArrayList<>();
        for (int i = 0; i < 9; i++){
            if (board.getField(i) == Mark.EMPTY){
                collection.add(i);
            }
        }
        Collections.shuffle(collection);
        return collection.get(0);
    }
}
