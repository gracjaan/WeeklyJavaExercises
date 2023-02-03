package ss.week5.tictactoe;

import ss.week4.tictactoe.Board;
import ss.week4.tictactoe.Mark;

import java.util.ArrayList;
import java.util.Collections;

public class SmartStrategy implements Strategy{
    @Override
    public String getName() {
        return "Smart";
    }

    @Override
    public int determineMove(Board board, Mark mark) {
        Board checker = board;
        if (board.getField(4).equals(Mark.EMPTY)){
            return 4;
        }

        //this loop checks for direct wins
        for (int i = 0; i < 9; i++){
            if (checker.isEmptyField(i)){
                checker.setField(i, mark);
                if (checker.hasWinner()){
                    return i;
                }
                checker.setField(i, Mark.EMPTY);
            }
        }

        //this loop checks for direct loses
        Mark m = Mark.XX;
        if (mark.equals(Mark.XX)){
            m = Mark.OO;
        }

        for (int i = 0; i < 9; i++){
            if (checker.isEmptyField(i)){
                checker.setField(i, m);
                if (checker.hasWinner()){
                    return i;
                }
                checker.setField(i, Mark.EMPTY);
            }
        }

        //this one returns random
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
