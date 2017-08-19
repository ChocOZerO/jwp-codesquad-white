package chocozero.codesquad.domain;

public class Rewards {
    private int match3;
    private int match4;
    private int match5;
    private int match6;
    
    public Rewards(int match3, int match4, int match5, int match6) {
        this.match3 = match3;
        this.match4 = match4;
        this.match5 = match5;
        this.match6 = match6;
    }
    
    private int getMatch3Amount() {
        return this.match3 * 5000;
    }
    private int getMatch4Amount() {
        return this.match4 * 50000;
    }
    private int getMatch5Amount() {
        return this.match5 * 1500000;
    }
    private int getMatch6Amount() {
        return this.match6 * 2000000000;
    }
    
    private int getTotalAmount() {
        return this.getMatch3Amount() + this.getMatch4Amount() + this.getMatch5Amount() + this.getMatch6Amount();
    }
    
    public int getRefundRate(int money) {
        return (int)((this.getTotalAmount() / (double)money) * 100);
    }
}
