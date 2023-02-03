package ss.week1.hotel;

public class SimpleBillPrinter {
    public static void main(String[] args) {
        String result1 = "";
        String des = "Hotel night 1x";
        double price = 85.50;
        result1 = String.format("%s               %.2f", des, price);
        System.out.println(result1);

    }
}
