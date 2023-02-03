package ss.week3.hotel;

import ss.week3.bill.Bill;
import ss.week3.password.BasicPassword;
import ss.week3.password.Password;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;


public class PricedSafe extends Safe implements Bill.Item {
    private double price;
    private Password password;

    public PricedSafe(double price) {
        this.password = new Password();
        this.price = price;
    }

    /**
     * @return current room price
     */
    @Override
    public double getAmount() {
        return this.price;
    }

    @Override
    public String toString() {
        return "Safe "+this.price;
    }

    /**
     * Activates safe using given password
     * @param passw given password
     * @return true if activated, otherwise false
     * */
    public boolean activate(String passw) {
        if (passw.equals(this.password.getCurrentPassword())) {
            super.activate();
            return true;
        }
        return false;
    }

    /**
     * Prints Warning since you can't activate safe without password
     * */
    @Override
    public void activate() {
        System.out.println("WARNING: You need a password to open the safe");
    }

    /**
     * Closes and deactivates safe
     * */
    public void deactivate() {
        super.close();
        super.deactivate();
    }

    /**
     * Opens safe using given password provided that
     * @param passw given password
     * */
    public void open(String passw) {
        if (passw.equals(this.password.getCurrentPassword())) {
            super.open();
        }
    }

    /**
     * Prints Warning since you can't open safe without password
     * */
    @Override
    public void open() {
        System.out.println("WARNING: You need a password to open the safe");
    }

    /**
     * Closes safe
     * */
    public void close() {
        super.close();
    }

    public Password getPassword() {
        return password;
    }
}
