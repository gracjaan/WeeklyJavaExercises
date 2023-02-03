package ss.week1;

public class RollTheDice {
    public static void main(String[] args) {
        int one = (int)(Math.random()*6) + 1;
        int two = (int)(Math.random()*6) + 1;
        int result = one+two;
        System.out.println("The first die comes up " + one);
        System.out.println("The first die comes up " + two);
        System.out.println("Your final result is " + result);
    }
}
