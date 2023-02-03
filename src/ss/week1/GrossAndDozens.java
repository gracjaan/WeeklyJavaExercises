package ss.week1;
import ss.utils.TextIO;

public class GrossAndDozens {
    public static void main(String[] args) {
        int input1 = TextIO.getlnInt();
        int input = input1;
        int dozens = 0;
        int gross = 0;

        while (input > 0){
            if (input - 144 >= 0){
                gross++;
                input = input - 144;
            }
            else if (input - 12 >= 0){
                dozens++;
                input = input - 12;
            }
            else{
                break;
            }
        }

        System.out.println("Your number of eggs is " + gross + " gross, " + dozens + " dozen, and " + input);
    }
}
