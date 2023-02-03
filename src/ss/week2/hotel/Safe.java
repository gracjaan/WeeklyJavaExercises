package ss.week2.hotel;

/**
 * @author tomhansult
 *
 */
public class Safe {
    public Safe() {
        active = false;
        open = false;
    }
  private boolean active;
  private boolean open;

    public void activate() {
        this.active = true;
    }
    public void deactivate() {
        this.active = false;
    }
    public void open() {
        if (this.active) {
            this.open = true;
        }
    }
    public void close() {
        if (this.active == true) {
            this.open = false;
        }
    }

    public boolean isOpen() {
        return open;
    }


    public boolean isActive() {
        return active;
    }


}
