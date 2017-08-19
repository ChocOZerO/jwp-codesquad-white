package chocozero.codesquad.domain;

import java.util.ArrayList;

public class LottoUser {
    private int money;
    private ArrayList<Lotto> lottos = new ArrayList<>();
    private int lottoCount;
    private int autoLottoCount;
    private int manualLottoCount;
    private ArrayList<String[]> manuals = new ArrayList<>();
    
    public LottoUser(int money) {
        this.money = money;
        this.lottoCount = (int)(this.money / 1000);
    }
    
    public void setAutoLottoCount(int autoLottoCount) {
        this.autoLottoCount = autoLottoCount;
        this.manualLottoCount = this.lottoCount - this.autoLottoCount;
    }
    public void setManuals(ArrayList<String[]> manuals) {
        this.manuals = manuals;
    }
    
    public int getMoney() {
        return this.money;
    }
    
    public int getLottoCount() {
        return this.lottoCount;
    }
    public int getAutoLottoCount() {
        return this.autoLottoCount;
    }
    public int getManualLottoCount() {
        return this.manualLottoCount;
    }
    
    public void buyLottos() {
        LottoGame lottoGame = new LottoGame(this.autoLottoCount);
        lottoGame.generateAutoLottos();
        if (this.manualLottoCount > 0 && this.manuals != null)
            lottoGame.generateManualLottos(this.manuals); 
        this.lottos = lottoGame.getLottos();
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
    
    Lotto getLotto(int index) {
        return lottos.get(index);
    }
}
