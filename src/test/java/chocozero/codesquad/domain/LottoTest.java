package chocozero.codesquad.domain;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class LottoTest {

    @Test
    public void lottoNum() {
        ArrayList<Integer> arrList = new ArrayList<>();
        arrList.add(1);
        arrList.add(2);
        arrList.add(3);
        arrList.add(4);
        arrList.add(5);
        arrList.add(6);
        Lotto lotto = new Lotto(arrList);
        assertEquals(6, lotto.getLottoNumCount());
        assertEquals(1, lotto.getLottoNum(0));
        assertEquals((new Lotto(arrList)).getLottoNum(0), lotto.getLottoNum(0));
    }

}
