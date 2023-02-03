package ss.week3.hotel;

import ss.utils.TextIO;
import ss.week3.bill.StringPrinter;


public class HotelTUI {
    public HotelTUI(String hotelName) {
        this.hotel = new Hotel(hotelName);
    }
    private Hotel hotel;
    public static void main(String[] args) {
        HotelTUI hotelTUI = new HotelTUI("U Parkhotel");
        hotelTUI.start();
    }

    /**
     * @descr starts the TUI application, it receives commands from the command line, check the menu for information about the commands.
     */
    public void start() {
        String guestName = null;
        Room room = null;

        final char IN = 'i';
        final char OUT = 'o';
        final char REQUEST = 'r';
        final char ACTIVATE = 'a';
        final char BILL = 'b';
        final char HELP = 'h';
        final char STATE = 'p';
        final char EXIT = 'x';

        String input;
        String[] spl;
        String command;
        String parm;
        boolean ex = false;
        printHelpMenu();
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
                    assert parm == null;
                    if (hotel.getFreeRoom()!=null){
                        guestName = parm;
                        room = hotel.checkIn(guestName);
                        System.out.println("Guest " + guestName + " is checked into "+room);
                    }
                }
                else if (command.charAt(0) == OUT){
                    assert parm == null;
                    if (!guestName.equals(parm)){
                        System.out.println(parm);
                        System.out.println("error");
                    }
                    else{
                        System.out.println("Guest " + guestName +" successfully checked out.");
                        hotel.checkOut(guestName);
                        guestName = null;
                    }
                }
                else if (command.charAt(0) == REQUEST){
                    assert parm == null;
                    assert guestName == null;
                    if (guestName != null) {
                        System.out.println("Guest "+guestName+" has "+hotel.getRoom(guestName));
                    }
                }
                else if (command.charAt(0) == ACTIVATE) {
                    if (spl.length>2) {
                        hotel.getRoom(parm).getSafe().activate(spl[2]);
                    }
                    else if (hotel.getRoom(parm).getSafe() instanceof Safe) {
                        hotel.getRoom(parm).getSafe().activate();
                    }
                    else {
                        System.out.println("This Safe is Password protected, please enter a password");
                    }
                }
                else if (command.charAt(0) == BILL) {
                    try {
                        String nights = command.charAt(2)+"";
                        int NumberOfNights = Integer.parseInt(nights);
                    }
                    catch (IllegalArgumentException e) {
                        System.out.println("Please specify the number of nights");
                    }
                    int nights = Integer.parseInt(command.charAt(2)+"");
                    System.out.println(hotel.getBill(spl[1], nights,new StringPrinter()));

                }
                else if (command.charAt(0) == STATE){
                    hotel.toString();
                }
                else if (command.charAt(0) == HELP){
                    printHelpMenu();
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

    public void printHelpMenu() {
        String menu = "Welcome to the Hotel booking system of the U Parkhotel Commands:\n" +
                "i name ........... check in guest with name \no name ........... check out guest with name" +
                "\nr name ........... request room of guest\n" + "a name password .. activate safe, password required for PricedSafe\n" +
                "b name nights..... print bill for guest (name) and number of nights\n" +
                "h ................ help (this menu)\n" +
                "p ................ print state\n" +
                "x ................ exit";
    }


}

