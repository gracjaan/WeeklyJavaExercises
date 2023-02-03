package ss.week3.bill;

public interface Printer {
    default String format(String text,  double price){
        String s = "";
        if (price>=10) {
            s = String.format("%s                       %.2f", text, price);
        }
        else {
            s = String.format("%s                        %.2f", text, price);
        }
        return s;
    }
    public void printLine(String text, double price);

    public String getResult();
}
