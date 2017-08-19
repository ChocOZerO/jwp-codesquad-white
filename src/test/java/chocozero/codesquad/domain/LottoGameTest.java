package chocozero.codesquad.domain;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class LottoGameTest {

    @Test
    public void testAutoLottos() {
        LottoGame lg = new LottoGame(15);
        int count = lg.getAutoLottoCount();
        lg.generateAutoLottos();
        assertEquals(15, count);
        lg.printLottos();
//        assertEquals(1, lg.getLottos().get(0).getLottoNum(1)); // 일부러 틀리게 하여 추출되는 값 확인
    }
    
    @Test
    public void testManualLottos() {
        LottoGame lg = new LottoGame(15);
        String[] manual = new String[6];
        manual[0] = "3";
        manual[1] = "7";
        manual[2] = "13";
        manual[3] = "27";
        manual[4] = "35";
        manual[5] = "43";
        
        ArrayList<String[]> manuals = new ArrayList<>();
        manuals.add(manual);
        lg.generateManualLottos(manuals);
        int count = manuals.size();
        assertEquals(1, count);
        lg.printLottos();
        assertEquals(1, lg.getLottos().get(0).getLottoNum(1)); // 일부러 틀리게 하여 추출되는 값 확인
    }
}
