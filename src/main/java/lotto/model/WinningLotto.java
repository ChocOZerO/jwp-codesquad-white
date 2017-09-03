package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lotto.model.Result.Match;

public class WinningLotto {
    private List<Integer> lotto;
    private int bonus;

    public WinningLotto(String lottoNo, String bonus) {
        if (lottoNo.length() < 1 || lottoNo.isEmpty()) throw new InvalidInputException("당첨번호를 입력하지 않았습니다.");
        if (bonus.isEmpty()) throw new InvalidInputException("보너스 번호가 입력되지 않았습니다.");
        try {
            this.bonus = Integer.parseInt(bonus);
        } catch (NumberFormatException e) {
            e.getStackTrace();
            throw new InvalidInputException("보너스 번호가 올바르지 않습니다.");
        }
        
        if (this.bonus < 0 || this.bonus > 45) throw new InvalidInputException("보너스 번호가 올바르지 않습니다.");
        
        String[] values = lottoNo.split(",");
        
        if (values.length != 6) throw new InvalidInputException("당첨번호 6개 입력이 정상적이지 않습니다.");
        
        this.lotto = new ArrayList<>();
        for (String value : values) {
            int tmp = 0;
            try {
                tmp = Integer.parseInt(value.trim());
                if (tmp < 0 || tmp > 45) throw new InvalidInputException("입력 번호가 올바르지 않습니다.");
            } catch (NumberFormatException e) {
                e.getStackTrace();
                throw new InvalidInputException("입력 숫자를 확인하세요.");
            }
            if (this.lotto.contains(tmp)) throw new InvalidInputException("입력값이 중복됩니다.");
            this.lotto.add(tmp);
        }
        if (this.lotto.contains(this.bonus)) throw new InvalidInputException("보너스 입력값이 중복됩니다.");
        Collections.sort(lotto);
    }
    
    public int getBonus() {
        return this.bonus;
    }
    
    public Match countOfMatch(List<Integer> lotto, int bonus) {
        List<Integer> result = new ArrayList<>(lotto);
        result.retainAll(this.lotto);

        if (result.size() < 3) {
            return null;
        }
        return Match.valueOf(result.size(), lotto.contains(bonus));
    }
}
