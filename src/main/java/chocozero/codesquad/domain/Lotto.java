package chocozero.codesquad.domain;

import java.util.List;

public class Lotto {
    private List<Integer> lotto;
    public Lotto(List<Integer> lotto) {
        this.lotto = lotto;
    }
    
    public int getLottoNumCount() {
        return this.lotto.size();
    }
    
    public int getLottoNum(int index) {
        return this.lotto.get(index);
    }
    
    boolean isContains(int num) {
        return this.lotto.contains(num);
    }
    
    public void printLotto() {
        System.out.print("[");
        for (int i = 0; i < this.getLottoNumCount(); i++) {
            if (i != 0) System.out.print(", ");
            System.out.print(this.lotto.get(i));
        }
        System.out.print("]");
    }
}
