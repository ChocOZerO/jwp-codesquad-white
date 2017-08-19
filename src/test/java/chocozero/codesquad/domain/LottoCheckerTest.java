package chocozero.codesquad.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class LottoCheckerTest {

    @Test
    public void testInputWinLotto() {
        LottoUser lottoUser = new LottoUser(15000);
        lottoUser.setAutoLottoCount(lottoUser.getLottoCount());
        lottoUser.buyLottos();
        lottoUser.printLottos();
        System.out.println("-------------");
        Win win = new Win("1, 2, 3, 4, 5, 6");
        
        win.getWin().printLotto();
        System.out.println(" 보너스번호 : [" + win.getBonus() + "]");
        System.out.println();
        
        LottoChecker lc = new LottoChecker(lottoUser, win);
        
        lc.matchUp();
        
        assertEquals(0, lc.getMatch3());
        assertEquals(0, lc.getMatch4());
        assertEquals(0, lc.getMatch5());
        assertEquals(0, lc.getMatch5Bonus());
        assertEquals(0, lc.getMatch6());
        
    }
    @Test
    public void testAutoWinLotto() throws Exception {
        LottoUser lottoUser = new LottoUser(15000);
        lottoUser.setAutoLottoCount(lottoUser.getLottoCount());
        lottoUser.buyLottos();
        lottoUser.printLottos();
        System.out.println("-------------");
        
        Win win2 = new Win("lottery");
        
        System.out.println();
        win2.getWin().printLotto();
        System.out.println(" 보너스번호 : [" + win2.getBonus() + "]");
        
        LottoChecker lc2 = new LottoChecker(lottoUser, win2);
        lc2.matchUp();
        
        assertEquals(0, lc2.getMatch3());
        assertEquals(0, lc2.getMatch4());
        assertEquals(0, lc2.getMatch5());
        assertEquals(0, lc2.getMatch5Bonus());
        assertEquals(0, lc2.getMatch6());
    }

}
