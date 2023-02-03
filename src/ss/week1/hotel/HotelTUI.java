package ss.week1.hotel;

import ss.utils.TextIO;

public class HotelTUI {

        public static void main(String[] args) {
                String guest = null;
                String hotelName = "Hotel U Parkhotel:";
                String roomName = "101";
                String menu = "Welcome to the Hotel booking system of the U Parkhotel Commands:\n" +
                        "i name ........... check in guest with name \no name ........... check out guest with name" +
                        "\nr name ........... request room of guest\n" +
                        "h ................ help (this menu)\n" +
                        "p ................ print state\n" +
                        "x ................ exit";

                final char IN = 'i';
                final char OUT = 'o';
                final char REQUEST = 'r';
                final char HELP = 'h';
                final char STATE = 'p';
                final char EXIT = 'x';

                String input;
                String[] spl;
                String command;
                String parm;
                String status = "empty";
                boolean ex = false;
                while (!ex){
                        input = TextIO.getln();
                        spl = input.split(" ");
                        command = spl[0];
                        parm = null;
                        if (spl.length > 1){
                                parm = spl[1];
                        }
                        if (command.length()==1){
                                if (command.charAt(0) == IN){
                                        if (parm == null){
                                                System.out.println("error");
                                        }
                                        else if (guest == null){
                                                guest = parm;
                                                System.out.println("Guest " + guest + " is checked into room 101");
                                                status = "taken by "+guest;
                                        }
                                }
                                else if (command.charAt(0) == OUT){
                                        if (parm == null){
                                                System.out.println("error");
                                        }
                                        else if (!guest.equals(parm)){
                                                System.out.println(parm);
                                                System.out.println("error");
                                        }
                                        else{
                                                System.out.println("Guest " + guest +" successfully checked out.");
                                                status = "empty";
                                                guest = null;
                                        }
                                }
                                else if (command.charAt(0) == REQUEST){
                                        if (parm == null){
                                                System.out.println("error");
                                        }
                                        else if (guest == null){
                                                System.out.println("error");
                                        }
                                        else{
                                                System.out.println("Guest "+guest+" has room 101");
                                        }
                                }
                                else if (command.charAt(0) == STATE){
                                        System.out.println(hotelName);
                                        System.out.println("> Room 101: " +status);
                                }
                                else if (command.charAt(0) == HELP){
                                        System.out.println(menu);
                                }
                                else if (command.charAt(0) == EXIT){
                                        ex = true;
                                }
                                else{
                                        System.out.println("error");
                                }
                        }
                        else{
                                System.out.println("error");
                        }
                }
        }
}
