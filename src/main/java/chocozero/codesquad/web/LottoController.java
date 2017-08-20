package chocozero.codesquad.web;

import java.util.ArrayList;
import java.util.Scanner;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public ModelAndView getLottos(String money, String auto) {
        lottoUser = new LottoUser(Integer.parseInt(money));
        this.setAutoLottoCount(auto);
        int manualCount = lottoUser.getManualLottoCount();
        if (manualCount > 0) {
            ModelAndView mav = new ModelAndView("lotto/manuals");
            for (int i = 0; i < manualCount; i++) {
                String[] manual = new String[6];
                manuals.add(manual);
            }
            mav.addObject("manuals", manuals);
            return mav;
        }
        return new ModelAndView("redirect:/lotto/show");
    }
    
    private void setAutoLottoCount(String auto) {
        if (!"".equals(auto)) {
            lottoUser.setAutoLottoCount(Integer.parseInt(auto));
        } else {
            lottoUser.setAutoLottoCount(lottoUser.getLottoCount());
        }
    }
    
    @GetMapping("")
    public String lottoForm() {
        return "lotto/form";
    }
    
    @PostMapping("/manuals")
    public String getManuals(@RequestParam(value="manual") String[] manualArray) {
        for (int i = 0; i < manualArray.length; i++) {
            manuals.set(i, manualArray[i].split(" "));
        }
        lottoUser.setManuals(manuals);
        return "redirect:/lotto/show";
    }
    
    @GetMapping("/show")
    public ModelAndView show() {
        ModelAndView mav = new ModelAndView("lotto/show");
        lottoUser.buyLottos();
        lottoUser.printLottos();
        mav.addObject("lottos", lottoUser.getLottos());
        return mav;
    }
    
    @GetMapping("/result")
    public ModelAndView result() {
        ModelAndView mav = new ModelAndView("lotto/result");
        Win win = new Win("lottery");
        LottoChecker lottoChecker = new LottoChecker(lottoUser, win);
        lottoChecker.matchUp();
        
        mav.addObject("lottos", lottoUser.getLottos());
        mav.addObject("win", win.getWin().getLotto());
        mav.addObject("bonus", win.getBonus());
        
        mav.addObject("match3", lottoChecker.getMatch3());
        mav.addObject("match4", lottoChecker.getMatch4());
        mav.addObject("match5", lottoChecker.getMatch5());
        mav.addObject("match5Bonus", lottoChecker.getMatch5Bonus());
        mav.addObject("match6", lottoChecker.getMatch6());
        
        Rewards rewards = new Rewards(lottoChecker.getMatch3()
                , lottoChecker.getMatch4(), lottoChecker.getMatch5()
                , lottoChecker.getMatch5Bonus(), lottoChecker.getMatch6());
        mav.addObject("refundRate", rewards.getRefundRate(lottoUser.getMoney()));
        
        return mav;
    }
}
