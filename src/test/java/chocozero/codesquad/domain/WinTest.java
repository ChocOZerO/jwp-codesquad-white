package chocozero.codesquad.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class WinTest {

    @Test
    public void winTest() {
        Win win = new Win("1, 2, 3, 4, 5, 6, 10"); // 7개 입력 테스트
        assertEquals(true, win.getWin().isContains(1));
        assertEquals(true, win.getWin().isContains(2));
        assertEquals(10, win.getBonus());
        
        Win win2 = new Win("1, 2, 3, 4, 5, 6");
        assertEquals(true, win2.getWin().isContains(1));
        assertEquals(true, win2.getWin().isContains(2));
        assertEquals(2, win2.getBonus()); // 일부러 틀리게 작성하여 출력값 확인(1,2,3,4,5,6 중 한 숫자가 들어오면 안됨)
    }

}
