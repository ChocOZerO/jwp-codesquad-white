package chocozero.codesquad.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class RewardsTest {

    @Test
    public void test() {
        Rewards rwd = new Rewards(1, 0, 0, 0, 0);
        
        assertEquals(33, rwd.getRefundRate(15000));
    }

}
