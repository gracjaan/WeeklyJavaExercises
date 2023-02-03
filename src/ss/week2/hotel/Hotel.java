package ss.week2.hotel;

public class Hotel {
    private String name;
    private final Room room1;
    private final Room room2;

    /**
     *
     * @param name of the hotel
     * creates a hotel with Room 101, and Room 102
     */
    public Hotel(String name) {
        this.name = name;
        this.room1 = new Room(101);
        this.room2 = new Room(102);
    }

    /**
     *
     * @param name of the guest
     * @return the room the guest was checked into
     */
    public Room checkIn(String name) {
        assert name != null;
        Room room = getRoom(name);
        if (room==null) {
            room = getFreeRoom();
            if (room!=null) {
                Guest guest = new Guest(name);
                guest.checkin(room);
            }
        }
        return room;
    }
    /**
     *
     * @param name of the guest
     *
     */
    public void checkOut(String name) {
        assert name != null;
        Room room = getRoom(name);
        if (room!=null) {
            room.getGuest().checkout();
            room.getSafe().deactivate();
        }
    }

    /**
     *
     * @return a free Room in the hotel
     */
    public Room getFreeRoom() {
        Room noRoom = null;
        if(this.room1.getGuest()==null) {
            noRoom = this.room1;
        }
        else if (this.room2.getGuest()==null) {
           noRoom = this.room2;
        }
        return noRoom;
    }

    /**
     *
     * @param name of the guest
     * @return the room the guest stays in
     */
    public Room getRoom(String name) {
        if (this.room1.getGuest()!=null && room1.getGuest().getName().equals(name)) {
            return room1;
        }
        else if ( this.room2.getGuest()!=null && room2.getGuest().getName().equals(name)) {
            return room2;
        }
        return null;
    }

    @Override
    public String toString() {
        String s = "";
        if (room1.getGuest() == null&&room2.getGuest()!=null) {
            s+=room1.getNumber()+ " is free";
            s += room2.getNumber() + " " + room2.getGuest().getName() + room2.getSafe().isActive();
        }
        else if (room2.getGuest() == null&&room1.getGuest()!=null) {
            s += room1.getNumber() + " " + room1.getGuest().getName() + room1.getSafe().isActive();
            s+=room2.getNumber()+ " is free";
        }
        else if(room1.getGuest()==null&&room2.getGuest()==null) {
            s+=room1.getNumber()+ " is free";
            s+=room2.getNumber()+ " is free";
        }
        else {
            s += room1.getNumber() + " " + room1.getGuest().getName() + room1.getSafe().isActive();
            s += room2.getNumber() + " " + room2.getGuest().getName() + room2.getSafe().isActive();
        }
        return s;
    }

// getters and setters


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Room getRoom1() {
        return room1;
    }

    public Room getRoom2() {
        return room2;
    }
}
