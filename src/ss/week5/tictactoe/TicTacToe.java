package ss.week5.tictactoe;

import ss.utils.TextIO;
import ss.week5.tictactoe.Game;
import ss.week5.tictactoe.HumanPlayer;
import ss.week4.tictactoe.Mark;

import java.util.Scanner;

public class TicTacToe {
    /**
     * Main that runs the TicTacToe game by taking input from the user and creating a new game and starting it.
     */
    public static void main(String[] args) {
        if (args.length==2) {
//            Game game = new Game(new HumanPlayer(args[0], Mark.XX), new HumanPlayer(args[1], Mark.OO));
//            game.start();
//            if (args[1].equals("-N")){
//                game = new Game(new HumanPlayer(args[0], Mark.XX), new ComputerPlayer(Mark.OO));
//                game.start();
//            }
//            else if (args[0].equals("-N")){
//                game = new Game(new HumanPlayer(args[1], Mark.XX), new ComputerPlayer(Mark.OO));
//                game.start();
            Player p1 = null;
            Player p2 = null;
            Mark mark = Mark.OO;
            switch (args[0]){
                case "-N":
                    p1 = new ComputerPlayer(mark);
                    break;
                case "-S":
                    p1 = new ComputerPlayer(mark, new SmartStrategy());
                    break;
                default:
                    p1 = new HumanPlayer(args[0], mark);

            }
            mark = Mark.XX;
            switch (args[1]){
                case "-N":
                    p2 = new ComputerPlayer(mark);
                    break;
                case "-S":
                    p2 = new ComputerPlayer(mark, new SmartStrategy());
                    break;
                default:
                    p2 = new HumanPlayer(args[1], mark);

            }
            Game game = new Game(p1, p2);
            game.start();

        }else {
//            String input = TextIO.getln();
//            String[] splitted = input.split(" ");
//            if (splitted.length == 1) {
//                Game game = new Game(new HumanPlayer(splitted[0], Mark.XX), new ComputerPlayer(Mark.OO));
//                game.start();
//            } else if (splitted.length == 2) {
//                Game game = new Game(new HumanPlayer(splitted[0], Mark.XX), new HumanPlayer(splitted[1], Mark.OO));
//                game.start();
//            }
            Scanner scan = new Scanner(System.in);
            String input = scan.next();
            String [] splitted = input.split(" ");
            Player p1 = null;
            Player p2 = null;
            Mark mark = Mark.OO;
            switch (splitted[0]){
                case "-N":
                    p1 = new ComputerPlayer(mark);
                    break;
                case "-S":
                    p1 = new ComputerPlayer(mark, new SmartStrategy());
                    break;
                default:
                    p1 = new HumanPlayer(splitted[0], mark);

            }
            mark = Mark.XX;
            switch (splitted[1]){
                case "-N":
                    p2 = new ComputerPlayer(mark);
                    break;
                case "-S":
                    p2 = new ComputerPlayer(mark, new SmartStrategy());
                    break;
                default:
                    p2 = new HumanPlayer(splitted[1], mark);

            }
            Game game = new Game(p1, p2);
            game.start();
        }
    }
}
