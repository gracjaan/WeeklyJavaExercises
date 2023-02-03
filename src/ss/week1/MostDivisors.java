package ss.week1;

public class MostDivisors {
    public static void main(String[] args) {
        int most_divisors = 1;
        int number = 1;
        for (int i = 0; i<=10000; i++){
            int divisors = 0;
            for (int j = 1; j<=i; j++){
                if (i%j == 0){
                    divisors++;
                }
            }
            if (divisors>most_divisors){
                most_divisors = divisors;
                number = i;
            }

        }
        System.out.println(number);
        System.out.println(most_divisors);
    }
}
