package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {
    public static Lottos generateByMoney(String money, String[] manuals) {
        System.out.println(money);
        int tempMoney = 0;
        try {
            tempMoney = Integer.parseInt(money);
        } catch (NumberFormatException e) {
            e.getStackTrace();
            throw new InvalidInputException("금액 입력이 올바르지 않습니다.");
        }
        int buyingNo = (tempMoney/UserLotto.MONEY_PER_TICKET);
        ArrayList<UserLotto> lottos = new ArrayList<>();
        if (!manuals[0].isEmpty()) {
            buyingNo -= manuals.length;
            if (buyingNo < 0) throw new InvalidInputException("수동 구매 개수가 금액보다 많습니다.");
            for (int i = 0; i < manuals.length; i++) {
                if (manuals[i].length() > 0) lottos.add(generateManual(manuals[i]));
            }
        }
        
        for (int i = 0; i < buyingNo; i++) {
            lottos.add(generateAuto());
        }
        if (lottos.size() < 1 || lottos.isEmpty()) throw new InvalidInputException("금액이 적어서 로또구입이 이뤄지지 않았습니다.");
        
        return new Lottos(lottos);
    }

    static UserLotto generateAuto() {
        List<Integer> seed = createSeed();
        Collections.shuffle(seed);
        return new UserLotto(seed.subList(0, 6));
    }
    static UserLotto generateManual(String manual) {
        
        String[] values = manual.split(",");
        
        if (values.length != 6) throw new InvalidInputException("당첨번호 6개 입력이 정상적이지 않습니다." + manual + " /");
        
        List<Integer> lotto = new ArrayList<>();
        for (String value : values) {
            int tmp = 0;
            try {
                tmp = Integer.parseInt(value.trim());
            } catch (NumberFormatException e) {
                e.getStackTrace();
                throw new InvalidInputException("입력값이 정상적이지 않습니다.");
            }
            lotto.add(tmp);
        }
        Collections.sort(lotto);
        return new UserLotto(lotto);
    }
    

    private static List<Integer> createSeed() {
        return IntStream.range(1, 46).boxed().collect(Collectors.toList());
    }
}
