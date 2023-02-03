package ss.week3.hotel;


public class Safe {
    /**
     * Constructor
     * @ensures active is set to false
     * @ensures open is set to false
     * */
    public Safe() {
        active = false;
        open = false;
    }
    private boolean active;
    private boolean open;

    /**
     * Activates safe
     * @ensures safe is activated
     * */
    public void activate() {
        this.active = true;
    }

    /**
     * Deactivates safe
     * @ensures safe is deactivated
     * */
    public void deactivate() {
        this.active = false;
    }

    /**
     * Opens safe
     * @require safe is activated
     * @ensures safe is opened
     * */
    public void open() {
        if (this.active) {
            this.open = true;
        }
    }

    /**
     * Closes safe
     * @require safe is active
     * @ensures safe is closed
     * */
    public void close() {
        if (this.active == true) {
            this.open = false;
        }
    }

    /**
     * @return true if safe is opened and false when safe is closed
     * */
    public boolean isOpen() {
        return open;
    }

    /**
     * @return true if safe is activated and false when safe is deactivated
     * */
    public boolean isActive() {
        return active;
    }


}

