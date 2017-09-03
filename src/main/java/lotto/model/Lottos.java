package lotto.model;

import java.util.List;

public class Lottos {
    private List<UserLotto> lottos;

    public Lottos(List<UserLotto> lottos) {
        this.lottos = lottos;
    }

    public int count() {
        return lottos.size();
    }
    public List<UserLotto> getLottos() {
        return this.lottos;
    }

    public Result match(WinningLotto winningLotto, int bonus) {
        Result result = new Result(lottos.size());
        for (UserLotto userLotto : lottos) {
            result.add(userLotto.countOfMatch(winningLotto, bonus));
        }
        return result;
    }
    
    @Override
    public String toString() {
        return "Lottos [lottos=" + lottos + "]";
    }
}
