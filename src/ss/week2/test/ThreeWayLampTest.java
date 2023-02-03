package ss.week2.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ss.week2.ThreeWayLamp;
import ss.week2.ThreeWayLampTUI;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ThreeWayLampTest {
    public static void main(String[] args) {
        ThreeWayLampTest lampTest = new ThreeWayLampTest();
        lampTest.runTest();
    }
    private static ThreeWayLampTUI lamp;

    @BeforeEach
    public static void setUp() {
        lamp = new ThreeWayLampTUI();
    }
    @Test
    public static void testStateAfterCreation(){
        System.out.println(lamp.getLamp().getCurrentState());
    }
    @Test
    public static void testSequence(){
        for (int i=0;i<4;i++) {
            lamp.setInput("NEXT");
            lamp.evaluateInput();
        }
        assertEquals(ThreeWayLamp.Options.OFF,lamp.getLamp().getCurrentState());
    }
    public static void runTest() {
        setUp();
        testStateAfterCreation();
        testSequence();
    }

}

