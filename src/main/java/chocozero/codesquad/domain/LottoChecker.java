package chocozero.codesquad.domain;

public class LottoChecker {
    private LottoUser lottoUser;
    private Win win;
    
    private int matchUp = 0;
    
    private int match3 = 0;
    private int match4 = 0;
    private int match5 = 0;
    private int match5Bonus = 0;
    private int match6 = 0;
    
    public LottoChecker(LottoUser lottoUser, Win win) {
        this.lottoUser = lottoUser;
        this.win = win;
    }
    
    public void matchUp() {
        for (int i = 0; i < lottoUser.getLottoCount(); i++) {
            checkLotto(lottoUser.getLotto(i));
        }
    }
    
    private void checkLotto(Lotto lotto) {
        boolean bonusFlag = false;
        for (int i = 0; i < lotto.getLottoNumCount(); i++) {
            int checkNum = lotto.getLottoNum(i);
            this.isContains(win.getWin().isContains(checkNum));
            bonusFlag = this.isBonusContains(checkNum);
        }
        this.countUpMatches(matchUp, bonusFlag);
        matchUp = 0;
    }
    
    private void isContains(Boolean check) {
        if(check) matchUp++;
    }
    private void countUpMatches(int matchUp, boolean bonusFlag) {
        switch (matchUp) {
            case 3:
                match3++;
                break;
            case 4:
                match4++;
                break;
            case 5:
                this.checkBonus(bonusFlag);
                break;
            case 6:
                match6++;
                break;
        }
    }
    private void checkBonus(boolean bonusFlag) {
        if (bonusFlag) match5Bonus++;
        match5++;
    }
    private boolean isBonusContains(int num) {
        if (win.getBonus() == num) {
            return true;
        }
        return false;
    }
    
    public int getMatch3() {
        return match3;
    }
    public int getMatch4() {
        return match4;
    }
    public int getMatch5() {
        return match5;
    }
    public int getMatch5Bonus() {
        return match5Bonus;
    }
    public int getMatch6() {
        return match6;
    }
}
