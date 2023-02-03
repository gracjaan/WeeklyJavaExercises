package ss.week3.bill;

public class StringPrinter implements Printer {
    private String result = "";

    /**
     * Prints string formatted with text and price
     * */
    @Override
    public void printLine(String text, double price) {
        this.result = result + format(text, price) + "\n";
    }


    /**
     * @return current result value
     * */
    public String getResult() {
        return result;
    }
}
