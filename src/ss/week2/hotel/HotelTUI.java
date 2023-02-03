package ss.week2.hotel;

import ss.utils.TextIO;

public class HotelTUI {
    public HotelTUI(String hotelName) {
        this.hotel = new Hotel("U Parkhotel");
    }
    private Hotel hotel;
    public static void main(String[] args) {
        HotelTUI hotelTUI = new HotelTUI("U Parkhotel");
        hotelTUI.start();
    }

    private final char IN = 'i';
    private final char OUT = 'o';
    private final char REQUEST = 'r';
    private final char ACTIVATE = 'a';
    private final char HELP = 'h';
    private final char STATE = 'p';
    private final char EXIT = 'x';
    /**
     * @descr starts the TUI application, it receives commands from the command line, check the menu for information about the commands.
     */
    public void start() {
        String guestName = null;
        Room room = null;
        Safe safe = new Safe();

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
                else if (command.charAt(0) == ACTIVATE){
                    if (safe.isActive()){
                        if (safe.isOpen()){
                            safe.close();
                        }
                        else{
                            safe.open();
                        }
                    }
                    else{
                        System.out.println("Safe is deactivated");
                    }
                }
                else if (command.charAt(0) == STATE){
                    hotel.toString();
                   // System.out.println(hotelName);System.out.println("> Room 101: " +status);
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

    /**
     * Prints menu
     * */
    public void printHelpMenu() {
        String menu = "Welcome to the Hotel booking system of the U Parkhotel Commands:\n" +
                "i name ........... check in guest with name \no name ........... check out guest with name" +
                "\nr name ........... request room of guest\n" +
                "a name ..............activate safe\n" +
                "h ................ help (this menu)\n" +
                "p ................ print state\n" +
                "x ................ exit";
    }


}
