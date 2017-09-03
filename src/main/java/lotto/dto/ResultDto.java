package lotto.dto;

import lotto.model.Result;
import lotto.model.Result.Match;

public class ResultDto {
    
    private double profits;
    private int countOfLotto;
    private Object countOfMatch3;
    private Object countOfMatch4;
    private Object countOfMatch5;
    private Object countOfMatch5Bonus;
    private Object countOfMatch6;

    public double getProfits() {
        return profits;
    }

    public int getCountOfLotto() {
        return countOfLotto;
    }

    public Object getCountOfMatch3() {
        return countOfMatch3;
    }

    public Object getCountOfMatch4() {
        return countOfMatch4;
    }

    public Object getCountOfMatch5() {
        return countOfMatch5;
    }
    
    public Object getCountOfMatch5Bonus() {
        return countOfMatch5Bonus;
    }
    
    public Object getCountOfMatch6() {
        return countOfMatch6;
    }

    public static ResultDto fromResult(Result result) {
        ResultDto resultDto = new ResultDto();
        resultDto.profits = result.getProfit();
        resultDto.countOfLotto = result.getCountOfLotto();
        resultDto.countOfMatch3 = result.getCountOfMatchingLotto(Match.MATCH3);
        resultDto.countOfMatch4 = result.getCountOfMatchingLotto(Match.MATCH4);
        resultDto.countOfMatch5 = result.getCountOfMatchingLotto(Match.MATCH5);
        resultDto.countOfMatch5Bonus = result.getCountOfMatchingLotto(Match.MATCH5BONUS);
        resultDto.countOfMatch6 = result.getCountOfMatchingLotto(Match.MATCH6);
        return resultDto;
      }
}
