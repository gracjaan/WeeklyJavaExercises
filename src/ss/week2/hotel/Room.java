package ss.week2.hotel;



public class Room {
    private int number;
    private Guest guest;
    private Safe safe;

    /**
    * Creates a <code>Room</code> with the given number, without a guest.
    * @param number of the new <code>Room</code>
    */
    public Room(int number, Safe safe) {
    	this.number = number;
        this.safe = safe;
    }
    public Room(int number) {
        this(number,new Safe());
    }
    /**
     * Returns the number of this Room
     */
    public int getNumber() {
    	return this.number;
    }
    /**
     * Returns the current guest living in this Room
     * @return the guest of this Room, null if not rented
     */
    public Guest getGuest() {
    	return this.guest;
    }
    /**
     * Assigns a Guest to this Room.
     * @param guest the new guest renting this Room, if null is given, Room is empty afterwards
     */
    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    @Override
    public String toString() {
        String s = "Room ";
        s+=this.number;
        return s;
    }

    public Safe getSafe() {
        return safe;
    }

    public void setSafe(Safe safe) {
        this.safe = safe;
    }


}
