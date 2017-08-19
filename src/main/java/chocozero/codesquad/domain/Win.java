package chocozero.codesquad.domain;

import java.util.ArrayList;

public class Win {
    private Lotto win;
    private String winInput;
    private int bonus;
    
    LottoGame lottoGame = new LottoGame(1);
    
    public Win(String winInput) {
        this.winInput = winInput;
        if ("lottery".equals(this.winInput)) this.getAutoLotto();
        else this.getManualLotto();
    }
    
    public Lotto getWin() {
        return this.win;
    }
    
    private void getAutoLotto() {
        lottoGame.generateAutoLottos();
        this.win = lottoGame.getLottos().get(0);
        this.setBonus();
    }
    
    private void getManualLotto() {
        String[] manual = this.winInput.split(", ");
        ArrayList<String[]> manuals = new ArrayList<>();
        manuals.add(manual);
        lottoGame.generateManualLottos(manuals);
        this.win = lottoGame.getLottos().get(0);
        if (manual.length > 6) this.bonus = Integer.parseInt(manual[6]);
        else this.setBonus();
    }
    
    private void setBonus() {
        boolean flag = false;
        while (!flag) {
            int random = (int)(Math.random() * 45);
            if (!this.checkNums(random)) {
                this.bonus = random;
                flag = true;
            }
        }
    }
    
    private boolean checkNums(int random) {
        if (this.win.isContains(random)) return true;
        return false;
    }
    
    public int getBonus() {
        return this.bonus;
    }
    
}
