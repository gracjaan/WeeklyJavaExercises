package ss.week4.tictactoe;

/**
 * Board for the Tic Tac Toe game. Module 2 lab assignment.
 *
 * @author Theo Ruys en Arend Rensink
 * @version $Revision: 1.4 $
 */
public class Board {
    public static final int DIM = 3;
    private static final String[] NUMBERING = {" 0 | 1 | 2 ", "---+---+---",
        " 3 | 4 | 5 ", "---+---+---", " 6 | 7 | 8 "};
    private static final String LINE = NUMBERING[1];
    private static final String DELIM = "     ";

    /**
     * The DIM by DIM fields of the Tic Tac Toe board. See NUMBERING for the
     * coding of the fields.
     * @invariant there are always DIM*DIM fields
     * @invariant all fields are either Mark.EMPTY, Mark.XX or Mark.OO
     */
    private Mark[] fields;

    // -- Constructors -----------------------------------------------

    /**
     * Creates an empty board.
     * @ensures all fields are EMPTY
     */
    public Board() {
    	fields = new Mark[9];
        for (int i=0;i<DIM*DIM;i++) {
            fields[i] = Mark.EMPTY;
        }
    }

    /**
     * Creates a deep copy of this field.
     * @ensures the result is a new object, so not this object
     * @ensures the values of all fields of the copy match the ones of this Board
     */
    public Board deepCopy() {
    	Board board = new Board();
        for (int i=0;i<9;i++) {
            board.fields[i] = this.fields[i];
        }
        return board;
    }

    /**
     * Calculates the index in the linear array of fields from a (row, col)
     * pair.
     * @requires row to be between 0 and DIM
     * @requires col to be between 0 and DIM
     * @return the index belonging to the (row,col)-field
     */
    public int index(int row, int col) {
    	assert row <= DIM;
        assert col <= DIM;
        int ind = 0;
        for (int i=0; i<row;i++) {
            ind+=DIM;
        }
        for (int j=0;j<col;j++) {
            ind+=1;
        }
        return ind;
    }

    /**
     * Returns true if index is a valid index of a field on the board.
     * @ensures a positive result when the index is between 0 and DIM*DIM
     * @return true if 0 <= index < DIM*DIM
     */
    public boolean isField(int index) {
    	if (index>=0&&index<DIM*DIM) {
            return true;
        }
        return false;
    }

    /**
     * Returns true of the (row,col) pair refers to a valid field on the board.
     * @ensures true when both row and col are within the board's bounds
     * @return true if 0 <= row < DIM && 0 <= col < DIM
     */
    public boolean isField(int row, int col) {
    	if (row>=0&&row<DIM) {
            if (col>=0&&col<DIM) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Returns the content of the field i.
     * @requires i to be a valid field
     * @ensures the result to be either EMPTY, XX or OO
     * @param i the number of the field (see NUMBERING)
     * @return the mark on the field
     */
    public Mark getField(int i) {
    	assert isField(i);
        return this.fields[i];
    }

    /**
     * Returns the content of the field referred to by the (row,col) pair.
     * @requires (row, col) to be a valid field
     * @ensures the result to be either EMPTY, XX or OO
     * @param row the row of the field
     * @param col the column of the field
     * @return the mark on the field
     */
    public Mark getField(int row, int col) {
    	assert isField(row, col);
        int ind = index(row, col);
        return this.fields[ind];
    }

    /**
     * Returns true if the field i is empty.
     * @requires i to be a valid field index
     * @ensures true when the Mark at index i is EMPTY
     * @param i the index of the field (see NUMBERING)
     * @return true if the field is empty
     */
    public boolean isEmptyField(int i) {
    	assert isField(i);
        if (fields[i]==Mark.EMPTY) {
            return true;
        }
        return false;
    }

    /**
     * Returns true if the field referred to by the (row,col) pair it empty.
     * @requires (row, col) to be a valid field
     * @ensures true when the Mark at (row, col) is EMPTY
     * @param row the row of the field
     * @param col the column of the field
     * @return true if the field is empty
     */
    public boolean isEmptyField(int row, int col) {
        assert isField(row, col);
        int i = index(row, col);
        if (fields[i]==Mark.EMPTY) {
            return true;
        }
        return false;
    }

    /**
     * Tests if the whole board is full.
     * @ensures true if all fields are occupied
     * @return true if all fields are occupied
     */
    public boolean isFull() {
    	for (int i=0;i<DIM*DIM;i++) {
            if (fields[i] == Mark.EMPTY) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns true if the game is over. The game is over when there is a winner
     * or the whole board is full.
     * @ensures true if the board is full or when there is a winner
     * @return true if the game is over
     */
    public boolean gameOver() {
    	if (hasWinner() || isFull()) {
            return true;
        }
        return false;
    }

    /**
     * Checks whether there is a row which is full and only contains the mark
     * m.
     * @param m the Mark of interest
     * @return true if there is a row controlled by m
     */
    public boolean hasRow(Mark m) {
        int flag = 0;
        int index = 0;
    	for (int i=0;i<DIM;i++) {
            flag = 0;
            for (int j=0;j<DIM;j++) {
                if (fields[index+j]==m) {
                    flag++;
                }
            }
            if (flag==3) {
                return true;
            }
            index+=DIM;
        }
        return false;
    }

    /**
     * Checks whether there is a column which is full and only contains the mark
     * m.
     * @param m the Mark of interest
     * @return true if there is a column controlled by m
     */
    public boolean hasColumn(Mark m) {
        int flag = 0;
        int index = 0;
        for (int i=0;i<DIM;i++) {
            flag = 0;
            for (int j=0;j<DIM*DIM;j+=DIM) {
                if (fields[i+j]==m) {
                    flag++;
                }
            }
            if (flag==DIM) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks whether there is a diagonal which is full and only contains the
     * mark m.
     * @param m the Mark of interest
     * @return true if there is a diagonal controlled by m
     */
    public boolean hasDiagonal(Mark m) {
        int flag = 0;
        //1st Diagonal
    	for (int i=0;i<DIM*DIM;i+=(DIM+1)) {
            if (fields[i]==m) {
                flag++;
            }
        }
        if (flag==DIM) {return true;}
        flag = 0;
        //2nd Diagonal
        for (int i=DIM-1;i<DIM*DIM;i+=(DIM-1)) {
            if (fields[i]==m) {
                flag++;
            }
        }
        if (flag==DIM) {return true;}
        return false;
    }

    /**
     * Checks if the mark m has won. A mark wins if it controls at
     * least one row, column or diagonal.
     * @requires m to be either XX or OO
     * @ensures true when m has a row, column or diagonal 
     * @param m the mark of interest
     * @return true if the mark has won
     */
    public boolean isWinner(Mark m) {
    	assert m == Mark.XX || m == Mark.OO;
        if (hasRow(m) || hasColumn(m) || hasDiagonal(m)) {
            return true;
        }
        return false;
    }

    /**
     * Returns true if the game has a winner. This is the case when one of the
     * marks controls at least one row, column or diagonal.
     * @ensures true when either XX or OO has won
     * @return true if the student has a winner.
     */
    public boolean hasWinner() {
    	if (isWinner(Mark.OO) || isWinner(Mark.XX)) {
            return true;
        }
        return false;
    }

    /**
     * Returns a String representation of this board. In addition to the current
     * situation, the String also shows the numbering of the fields.
     *
     * @return the game situation as String
     */
    public String toString() {
        String s = "";
//        for (int i = 0; i < DIM; i++) {
//            String row = "";
//            for (int j = 0; j < DIM; j++) {
//                row = row + " " + getField(i, j).toString() + " ";
//                if (j < DIM - 1) {
//                    row = row + "|";
//                }
//            }
//            s = s + row + DELIM + NUMBERING[i * 2];
//            if (i < DIM - 1) {
//                s = s + "\n" + LINE + DELIM + NUMBERING[i * 2 + 1] + "\n";
//            }
//        }
        return s;
    }

    /**
     * Empties all fields of this board (i.e., let them refer to the value
     * Mark.EMPTY).
     * @ensures all fields are EMPTY
     */
    public void reset() {
        for (int i=0;i<DIM*DIM;i++) {
            fields[i] = Mark.EMPTY;
        }
    }

    /**
     * Sets the content of field i to the mark m.
     * @requires i to be a valid field
     * @ensures field i to be set to Mark m
     * @param i the field number (see NUMBERING)
     * @param m the mark to be placed
     */
    public void setField(int i, Mark m) {
    	assert isField(i);
        fields[i] = m;
    }

    /**
     * Sets the content of the field represented by the (row,col) pair to the
     * mark m.
     * @requires (row, col) to be a valid field
     * @ensures field (row, col) to be set to Mark m
     * @param row the field's row
     * @param col the field's column
     * @param m the mark to be placed
     */
    public void setField(int row, int col, Mark m) {
    	assert isField(row, col);
        int ind = index(row, col);
        fields[ind] = m;
    }
}
