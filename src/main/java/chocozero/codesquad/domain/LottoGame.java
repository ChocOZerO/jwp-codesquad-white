package chocozero.codesquad.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGame {
    
    private int autoLottoCount;
    
    private ArrayList<Lotto> lottos = new ArrayList<>();
    List<Integer> lottoArray;
    
    public LottoGame(int autoLottoCount) {
        this.autoLottoCount = autoLottoCount;
    }
    
    public int getAutoLottoCount() {
        return this.autoLottoCount;
    }
    
    public void generateAutoLottos() {
        for (int i = 0; i < this.autoLottoCount; i++) {
            this.lottos.add(this.generateAutoLotto());
        }
    }
    private Lotto generateAutoLotto() {
        this.lottoArray = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            this.lottoArray.add(i);
        }
        Collections.shuffle(this.lottoArray);
        this.lottoArray = this.lottoArray.subList(0,6);
        Collections.sort(this.lottoArray);
        Lotto lotto = new Lotto(Collections.unmodifiableList(this.lottoArray));
        return lotto;
    }
    public void generateManualLottos(ArrayList<String[]> manuals) {
        for (int i = 0; i < manuals.size(); i++) {
            this.lottos.add(this.generateManualLotto(manuals.get(i)));
        }
    }
    private Lotto generateManualLotto(String[] winInput) {
        this.lottoArray = new ArrayList<>();
        for (int i = 0; i < winInput.length; i++) {
            this.lottoArray.add(Integer.parseInt(winInput[i]));
        }
        Collections.sort(lottoArray);
        Lotto lotto = new Lotto(Collections.unmodifiableList(lottoArray));
        return lotto;
    }
    
    public ArrayList<Lotto> getLottos() {
        return this.lottos;
    }

    public void printLottos() {
        for (Lotto lotto : lottos) {
            lotto.printLotto();
            System.out.println();
        }
    }
}
