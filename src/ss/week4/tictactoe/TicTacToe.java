package ss.week4.tictactoe;

import ss.utils.TextIO;

public class TicTacToe {
    /**
     * Main that runs the TicTacToe game by taking input from the user and creating a new game and starting it.
     *
     */
    public static void main(String[] args) {
        if (args.length==2) {
            Game game = new Game(new HumanPlayer(args[0], Mark.XX), new HumanPlayer(args[1], Mark.OO));
            game.start();
        }else {
            String input = TextIO.getln();
            String[] splitted = input.split(" ");
            if (splitted.length == 1) {
                Game game = new Game(new HumanPlayer(splitted[0], Mark.XX), new HumanPlayer("default", Mark.OO));
                game.start();
            } else if (splitted.length == 2) {
                Game game = new Game(new HumanPlayer(splitted[0], Mark.XX), new HumanPlayer(splitted[1], Mark.OO));
                game.start();
            }
        }
    }
}
