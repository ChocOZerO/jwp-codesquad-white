package chocozero.codesquad.web;

import java.util.ArrayList;
import java.util.Scanner;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import chocozero.codesquad.domain.LottoChecker;
import chocozero.codesquad.domain.LottoUser;
import chocozero.codesquad.domain.Rewards;
import chocozero.codesquad.domain.User;
import chocozero.codesquad.domain.Win;

@Controller
@RequestMapping("/lotto")
public class LottoController {
    LottoUser lottoUser;
    ArrayList<String[]> manuals  = new ArrayList<>();
    
    @PostMapping("")
    public ModelAndView getManuals(String money, String auto) {
        ModelAndView mav = new ModelAndView("lotto/manuals");
        lottoUser = new LottoUser(Integer.parseInt(money));
        if (!"".equals(auto)) {
            lottoUser.setAutoLottoCount(Integer.parseInt(auto));
        } else {
            lottoUser.setAutoLottoCount(lottoUser.getLottoCount());
        }
        int manualCount = lottoUser.getManualLottoCount();
        if (manualCount > 0) {
            for (int i = 0; i < manualCount; i++) {
                String[] manual = new String[6];
                manuals.add(manual);
            }
            mav.addObject("manuals", manuals);
            return mav;
        }
        return new ModelAndView("redirect:/users");
    }
    
    @GetMapping("")
    public String lottoForm() {
        return "lotto/form";
    }
    
    
//    public static void main(String[] args) {
//        System.out.println("구입금액을 입력해 주세요.");
//        
//        Scanner sc = new Scanner(System.in);
//        int money = Integer.parseInt(sc.nextLine());
//        LottoUser lottoUser = new LottoUser(money);
//        int lottoCount = lottoUser.getLottoCount();
//        System.out.println("자동으로 뽑을 로또의 개수를 입력해주세요.");
//        int autoLottoCount = Integer.parseInt(sc.nextLine());
//        lottoUser.setAutoLottoCount(autoLottoCount);
//        if (autoLottoCount != lottoCount) {
//            lottoUser.setManuals(setManuals(lottoUser.getManualLottoCount()));
//        }
//        
//        lottoUser.buyLottos();
//        System.out.println("자동으로 " + lottoUser.getAutoLottoCount() + "개를 구매했습니다.");
//        System.out.println("수동으로 " + lottoUser.getManualLottoCount() + "개를 구매했습니다.");
//        System.out.println("총 " + lottoCount + "개를 구매했습니다.");
//        lottoUser.printLottos();
//        
//        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
//        String winLotto = sc.nextLine();
//        Win win = new Win(winLotto);
//        win.getWin().printLotto();
//        System.out.println(" 보너스번호 : [" + win.getBonus() + "]");
//        System.out.println();
//        LottoChecker lc = new LottoChecker(lottoUser, win);
//        lc.matchUp();
//        System.out.println("당첨 통계");
//        System.out.println("-------");
//        System.out.println("3개 일치 (5000원) : " + lc.getMatch3() + " 개");
//        System.out.println("4개 일치 (50000원) : " + lc.getMatch4() + " 개");
//        System.out.println("5개 일치 (1500000원) : " + lc.getMatch5() + " 개");
//        System.out.println("5개 일치, 보너스 볼 일치 (30000000원) : " + lc.getMatch5() + " 개");
//        System.out.println("6개 일치 (2000000000원) : " + lc.getMatch6() + " 개");
//        Rewards rewards = new Rewards(lc.getMatch3(), lc.getMatch4(), lc.getMatch5(), lc.getMatch6());
//        System.out.println("총 수익률은 " + rewards.getRefundRate(money) + "% 입니다.");
//        
//        sc.close();
//    }
//    private static ArrayList<String[]> setManuals(int manualCount) {
//
//        ArrayList<String[]> manuals = new ArrayList<>();
//        
//        for (int i = 1; i <= manualCount; i++) {
//            String[] manual = new String[6];
//            manual[0] = String.valueOf(((2 * i) % 45) + 1);
//            manual[1] = String.valueOf(((3 * i) % 45) + 1);
//            manual[2] = String.valueOf(((4 * i) % 45) + 1);
//            manual[3] = String.valueOf(((5 * i) % 45) + 1);
//            manual[4] = String.valueOf(((6 * i) % 45) + 1);
//            manual[5] = String.valueOf(((7 * i) % 45) + 1);
//            manuals.add(manual);
//        }
//        
//        return manuals;
//    }
}
