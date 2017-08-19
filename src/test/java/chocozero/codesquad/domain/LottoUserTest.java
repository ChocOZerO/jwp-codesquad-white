package chocozero.codesquad.domain;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class LottoUserTest {

    @Test
    public void test() {
        LottoUser lu = new LottoUser(15000);
        assertEquals(15000, lu.getMoney());
        lu.setAutoLottoCount(10);
        ArrayList<String[]> manuals = new ArrayList<>();
        String[] manual = new String[6];
        for (int i = 1; i <= 5; i++) { 
            manual[0] = String.valueOf(2 * i);
            manual[1] = String.valueOf(3 * i);
            manual[2] = String.valueOf(4 * i);
            manual[3] = String.valueOf(5 * i);
            manual[4] = String.valueOf(6 * i);
            manual[5] = String.valueOf(7 * i);
            manuals.add(manual);
        }
        
        lu.setManuals(manuals);
        lu.buyLottos();
        assertEquals(15, lu.getLottos().size());
        assertEquals(6, lu.getLottos().get(0).getLottoNumCount());
        assertEquals(35, lu.getLottos().get(14).getLottoNum(5));
    }

}
