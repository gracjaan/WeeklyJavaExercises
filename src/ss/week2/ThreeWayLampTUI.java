package ss.week2;

import ss.utils.TextIO;

public class ThreeWayLampTUI {
    private ThreeWayLamp lamp = new ThreeWayLamp();

    private static boolean exit = false;
    private static String input;


    private static final String MENU = "Type OFF: lamp sets to off\nType LOW: lamp sets to low\nType MEDIUM: lamp sets to medium\nType HIGH: lamp sets to high\nType STATE: display current state\nType NEXT: change to the next setting, observing the order OFF → LOW → MEDIUM → HIGH →OFF\\nType HELP: display menu\\nType EXIT: quit program\\n";
    public static ThreeWayLamp.Options change (ThreeWayLamp.Options cs){
        switch (cs){
            case OFF:
                return ThreeWayLamp.Options.LOW;
            case LOW:
                return ThreeWayLamp.Options.MEDIUM;
            case MEDIUM:
                return ThreeWayLamp.Options.HIGH;
            case HIGH:
                return ThreeWayLamp.Options.OFF;
            default:
                return ThreeWayLamp.Options.HIGH;
        }
    }


    /**
     * ensures following the sequence OFF-LOW-MEDIUM-HIGH-OFF
     */
    public void evaluateInput() {
        switch (input) {
            case "OFF":
                /**
                 * @requires current state to be HIGH
                 */
                assert lamp.getCurrentState() != ThreeWayLamp.Options.HIGH;
                lamp.setCurrentState(ThreeWayLamp.Options.OFF);
                System.out.println(lamp.getCurrentState());
                break;
            case "LOW":
                /**
                 * @requires current state to be OFF
                 */
                assert lamp.getCurrentState() != ThreeWayLamp.Options.OFF;
                lamp.setCurrentState(ThreeWayLamp.Options.LOW);
                System.out.println(lamp.getCurrentState());
                break;
            case "MEDIUM":
                /**
                 * @requires current state to be LOW
                 */
                assert lamp.getCurrentState() != ThreeWayLamp.Options.LOW;
                lamp.setCurrentState(ThreeWayLamp.Options.MEDIUM);
                System.out.println(lamp.getCurrentState());
                break;
            case "HIGH":
                /**
                 * @requires current state to be MEDIUM
                 */
                assert lamp.getCurrentState() != ThreeWayLamp.Options.MEDIUM;
                lamp.setCurrentState(ThreeWayLamp.Options.HIGH);
                System.out.println(lamp.getCurrentState());
                break;
            case "HELP":
                System.out.println(MENU);
                break;
            case "EXIT":
                exit = true;
                break;
            case "NEXT":
                ThreeWayLamp.Options temp = lamp.getCurrentState();
                lamp.setCurrentState(change(temp));
                System.out.println(lamp.getCurrentState());
                break;
            case "STATE":
                System.out.println(lamp.getCurrentState());
                break;
            default:
                System.out.println("Wrong input");
        }
    }


    // the class ThreeWayLamp has all the necessary functionality added to its originally stub implementation
    public void run() {
        ThreeWayLamp lamp = new ThreeWayLamp();
        while (!isExit()) {
            this.input = TextIO.getln();
            this.evaluateInput();
        }
    }

    //get set
    public boolean isExit() {
        return exit;
    }

    public void setExit(boolean exit) {
        this.exit = exit;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public ThreeWayLamp getLamp() {
        return lamp;
    }
}
