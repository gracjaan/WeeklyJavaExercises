package ss.week2;


public class ThreeWayLamp {
    public enum Options  {
        OFF,LOW,MEDIUM,HIGH
    }
    private static Options currentState = Options.OFF;




    // Getters and Setters

    public Options getCurrentState() {
        return currentState;
    }

    public void setCurrentState(Options currentState) {
        this.currentState = currentState;
    }

}
