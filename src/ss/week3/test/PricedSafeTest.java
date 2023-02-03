package ss.week3.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ss.week3.bill.Bill;
import ss.week3.hotel.PricedSafe;

public class PricedSafeTest {

    private PricedSafe safe;
    private static final double PRICE = 6.36;
    private static final String PRICE_PATTERN = ".*6[.,]36.*";

    public String CORRECT_PASSWORD;
    public String WRONG_PASSWORD;
    public String TO_STRING;


    @BeforeEach
    public void setUp() throws Exception {
        safe = new PricedSafe(PRICE);
        CORRECT_PASSWORD = safe.getPassword().getFactoryPassword();
        WRONG_PASSWORD = CORRECT_PASSWORD + "WRONG";
        TO_STRING = "Safe";
        assertFalse(safe.isActive());
        assertFalse(safe.isOpen());
    }

    @Test
    public void testIsBillItem() throws Exception {
    	assertTrue(safe instanceof Bill.Item,
    			"safe should be an instance of Bill.Item.");
        assertEquals(PRICE, safe.getAmount(), 0.001,
        		"GetAmount should return the price of the safe.");
    }
    @Test
    public void testToString() throws Exception {
       assertEquals(TO_STRING, safe.toString());
    }
    @Test
    public void testDeActivateCorrect() throws Exception {
        safe.activate(CORRECT_PASSWORD);
        assertTrue(safe.isActive());
        assertFalse(safe.isOpen());
    }
    @Test
    public void testDeActivateWrong() throws Exception {
        safe.activate(WRONG_PASSWORD);
        assertFalse(safe.isActive());
        assertFalse(safe.isOpen());
    }
    @Test
    public void testOpenDeactivatedSafeCorrect() throws Exception {
        safe.deactivate();
        safe.open(CORRECT_PASSWORD);
        assertFalse(safe.isActive());
        assertFalse(safe.isOpen());
    }
    @Test
    public void testOpenDeactivatedSafeWrong() throws Exception {
        safe.deactivate();
        safe.open(WRONG_PASSWORD);
        assertFalse(safe.isActive());
        assertFalse(safe.isOpen());
    }
    @Test
    public void testOpenActiveCorrectIncorrect() {
        safe.activate(CORRECT_PASSWORD);
        safe.open(WRONG_PASSWORD);
        assertTrue(safe.isActive());
        assertFalse(safe.isOpen());
        safe.open(CORRECT_PASSWORD);
        assertTrue(safe.isOpen());
    }
    @Test
    public void testOpenClose() {
        safe.activate(CORRECT_PASSWORD);
        safe.open(CORRECT_PASSWORD);
        safe.close();
        assertTrue(safe.isActive());
        assertFalse(safe.isOpen());
    }
    @Test
    public void testCloseDeactivated() {
        safe.deactivate();
        safe.close();
        assertFalse(safe.isActive());
        assertFalse(safe.isOpen());
    }

}
