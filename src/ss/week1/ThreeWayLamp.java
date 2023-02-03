package ss.week1;

import ss.utils.TextIO;

public class ThreeWayLamp {
    public enum Options  {
            OFF,LOW,MEDIUM,HIGH
    }
    public static Options change (Options cs){
        switch (cs){
            case OFF:
                return Options.LOW;
            case LOW:
                return Options.MEDIUM;
            case MEDIUM:
                return Options.HIGH;
            case HIGH:
                return Options.OFF;
            default:
                return Options.HIGH;
        }
    }
    public static void main(String[] args) {
        String menu = "Type OFF: lamp sets to off\nType LOW: lamp sets to low\nType MEDIUM: lamp sets to medium\nType HIGH: lamp sets to high\nType STATE: display current state\nType NEXT: change to the next setting, observing the order OFF → LOW → MEDIUM → HIGH →OFF\nType HELP: display menu\nType EXIT: quit program\n";
        String input;
        Options currentState = Options.OFF;
        boolean ex = false;
        while (!ex) {
            input = TextIO.getln();
            switch (input) {
                case "OFF":
                    currentState = Options.OFF;
                    System.out.println(currentState);
                    break;
                case "LOW":
                    currentState = Options.LOW;
                    System.out.println(currentState);
                    break;
                case "MEDIUM":
                    currentState = Options.MEDIUM;
                    System.out.println(currentState);
                    break;
                case "HIGH":
                    currentState = Options.HIGH;
                    System.out.println(currentState);
                    break;
                case "HELP":
                    System.out.println(menu);
                    break;
                case "EXIT":
                    ex = true;
                    break;
                case "NEXT":
                    Options temp = currentState;
                    currentState = ThreeWayLamp.change(temp);
                    System.out.println(currentState);
                    break;
                case "STATE":
                    System.out.println(currentState);
                    break;
                default:
                    System.out.println("Wrong input");
            }
        }
    }
}
