package ss.week3.hotel;

import ss.week3.bill.Bill;

import java.text.DecimalFormat;

public class PricedRoom extends Room implements Bill.Item{

    public PricedRoom(int number, double roomPrice, double safePrice) {
        super(number, new PricedSafe(safePrice));
        this.price = roomPrice;
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
        String s;
        if (price>=10) {
            s = String.format("%s                       %.2f", "Safe", price);
        }
        else {
            s = String.format("%s                        %.2f", "Safe", price);
        }
        s+=this.getNumber()+ "";
        s+=this.price;
        return s;
    }
    private double price;
}
