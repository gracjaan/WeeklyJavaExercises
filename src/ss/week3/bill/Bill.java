package ss.week3.bill;

import ss.week3.hotel.PricedRoom;

import java.text.DecimalFormat;

public class Bill {
    public interface Item {
        double getAmount();
        String toString();
    }
    public Bill(Printer printer) {
    assert printer != null;
    this.printer = printer;
    }

    private Printer printer;
    private double sum;


    /**
     * Prints item and its price
     * @param item new item
     * @ensures this.getSum() == \old(getSum()) + item.getAmount();
     * */
    public void addItem(Item item) {
        assert item != null;
        sum += item.getAmount();
        this.printer.printLine(item.toString(), item.getAmount());

    }

    /**
     * Prints total price of the bill
     * */
    public void close() {
       this.printer.printLine("Total ", getSum());
    }

    //____________________________Getters and setters__________________________________________

    /**
     * @return the current sum total of the Bill.
     * */
    public double getSum () {
        return sum;
    }

    /**
     * @return printer
     * */
    public Printer getPrinter() {
        return printer;
    }
}
