package ss.week3.bill;

public class SysoutPrinter implements Printer{
    /**
     * Prints string formatted with text and price
     * */
    @Override
    public void printLine(String text, double price) {
        System.out.println(format(text, price));
    }

    /**
     * Never executed
     * @return null
     * */
    @Override
    public String getResult() {
        return null;
    }

    public static void main(String[] args) {
        Printer printer = new SysoutPrinter();
        printer.printLine("Text1", 1.0);
        printer.printLine("Coffee", -31.04);
        printer.printLine("Tea", 11.023);
    }
}
