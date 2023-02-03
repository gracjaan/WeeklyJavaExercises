package ss.week1;

import ss.utils.TextIO;

public class BabylonianAlgorithm {
    public static void main(String[] args) {
        double n = TextIO.getDouble();
        double x = n;
        double y = 1;
        double e = 0.01; /* e decides the accuracy level*/
        while (x - y > e) {
            x = (x + y) / 2;
            y = n / x;
        }
        System.out.println(x);
    }
}
