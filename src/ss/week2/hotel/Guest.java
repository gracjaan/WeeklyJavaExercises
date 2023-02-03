package ss.week2.hotel;

public class Guest {
    /**
     * Creates a Guest with the given name.
     * @param name of the guest
     */
    public Guest(String name) {
        this.name = name;
    }

    private String name;
    private Room room;
    /**
     * Checks the guest into the given room.
     * @param room the guest should be checked into
     * @return true if this.room==null&&room.getGuest()==null, otherwise false
     */
    public boolean checkin(Room room) {
        if (this.room==null&&room.getGuest()==null){
            room.setGuest(this);
            this.room = room;
            return true;
        }
        return false;
    }

    /**
     * Checks the guest out
     * @return true if this.room!=null, otherwise false
     * */
    public boolean checkout() {
        if (this.room!=null) {
            this.room.setGuest(null);
            this.room = null;
            return true;
        }
        return false;
    }
    /**
     * Returns the name of the guest
     * @return the name of the guest.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets name to given parameter
     * @param name given name
     * */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the room of the guest
     * @return the room of the guest, if no room, null.
     */
    public Room getRoom() {
        return this.room;
    }

    /**
     * Sets room to given parameter
     * @param room given room
     * */
    public void setRoom(Room room) {
        this.room = room;
    }

    /**
     * Overrides toString and returns refactored string
     * @return Guest + his/her name
     * */
    @Override
    public String toString() {
        String s = "Guest ";
        s+=this.name;
        return s;
    }
}
