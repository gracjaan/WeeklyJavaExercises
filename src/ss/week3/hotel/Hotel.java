package ss.week3.hotel;

import ss.week3.bill.Bill;
import ss.week3.bill.Printer;
import ss.week3.bill.StringPrinter;

public class Hotel {
        private String name;
        private final PricedRoom room1;
        private final PricedRoom room2;

        public static final double ROOM_PRICE = 120.0;
        public static final double SAFE_PRICE = 15.0;

        /**
         *
         * @param name of the hotel
         * creates a hotel with Room 101, and Room 102
         */
        public Hotel(String name) {
            this.name = name;
            this.room1 = new PricedRoom(101, ROOM_PRICE, SAFE_PRICE);
            this.room2 = new PricedRoom(102, ROOM_PRICE, SAFE_PRICE);
        }

        /**
         *
         * @param name of the guest
         * @return the room the guest was checked into
         */
        public PricedRoom checkIn(String name) {
            assert name != null;
            PricedRoom room = getRoom(name);
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
        public PricedRoom getFreeRoom() {
            PricedRoom noRoom = null;
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
        public PricedRoom getRoom(String name) {
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

        public String getBill(String guestName, int numberOfNights, Printer printer) {
            Bill bill = new Bill(printer);
            if ( !(getRoom(guestName) instanceof PricedRoom) || getRoom(guestName)==null) {
                return null;
            }
            PricedRoom guestRoom = getRoom(guestName);
            for (int i=0;i<numberOfNights;i++) {
                bill.addItem(guestRoom);
            }
            bill.addItem(guestRoom.getSafe());
            bill.close();
            System.out.println(bill.getPrinter().getResult());
            return bill.getPrinter().getResult();
        }

// getters and setters


        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public PricedRoom getRoom1() {
            return room1;
        }

        public PricedRoom getRoom2() {
            return room2;
        }
    }


