package ss.week1;

public class MostDivisorsWithArray {
    public static void main(String[] args) {
        int most_divisors = 1;
        int [] arr = new int [10000];
        for (int i = 0; i<10000; i++){
            int divisors = 0;
            for (int j = 1; j<=i; j++){
                if (i%j == 0){
                    divisors++;
                }
            }
            arr[i] = divisors;
            if (divisors>most_divisors){
                most_divisors = divisors;
            }

        }
        System.out.println(most_divisors);

        for (int i = 0; i< arr.length; i++){
            if (arr[i] == most_divisors){
                System.out.println(i);
            }
        }

        }
    }

