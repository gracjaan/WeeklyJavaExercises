package ss.week3.test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ss.week3.bill.*;
import ss.week3.hotel.Hotel;

public class BillTest {
    private Bill bill;

    @BeforeEach
    public void setUp() {
        bill = new Bill(new StringPrinter());

    }


    @Test
    public void testBeginState() {
        assertTrue(bill.getPrinter() instanceof StringPrinter);
        assertTrue(bill.getSum()==0.0);
    }

    @Test
    public void testInsertion(){
        Bill.Item item1 = new Bill.Item() {
            @Override
            public double getAmount() {
                return 15.0;
            }
            @Override
            public String toString() {
                return "Item 1";
            }
        };
        Bill.Item item2 = new Bill.Item() {
            @Override
            public double getAmount() {
                return 20.0;
            }
            @Override
            public String toString() {
                return "Item 2";
            }
        };
        Bill.Item item3 = new Bill.Item() {
            @Override
            public double getAmount() {
                return 0.50;
            }
            @Override
            public String toString() {
                return "Item 3";
            }
        };
        bill.addItem(item1);
        bill.addItem(item2);
        bill.addItem(item3);
        assertThat(bill.getPrinter().getResult(),
                CoreMatchers.containsString(
                        String.valueOf("15,00")));
        assertThat(bill.getPrinter().getResult(),
                CoreMatchers.containsString(
                        String.valueOf("20,00")));
        assertThat(bill.getPrinter().getResult(),
                CoreMatchers.containsString(
                        String.valueOf("0,50")));
    }

}
