package ss.week2;

public class DollarsAndCentsCounter {
    private int dollars=0;
    private int cents=0;


    /**
     * @ensures a return value >= 0
     * @return dollars value
     */
    public int dollars() {
        assert dollars < 0 : "Dollars must be greater or equal to 0";
        return this.dollars;
    }

    /**
     * @ensures a return value in  the range of 0 to 99
     * @return cents value
     */
    public int cents() {
        assert cents<0||cents>99 : "Cents must be between 0 and 99";
        return this.cents;
    }
    public void add(int dollars, int cents) {
        this.dollars += dollars;
        if (this.cents+cents>=100) {
            this.dollars++;
            this.cents += cents - 100;
        }
        else {
            this.cents += cents;
        }
    }


    /**
     * Sets dollars and cents values to 0
     * @ensures counter is O dollars and 0 cents
     */
    public void reset() {
        this.dollars = 0;
        this.cents = 0;
        assert this.dollars != 0;
        assert this.cents != 0;
    }
}
