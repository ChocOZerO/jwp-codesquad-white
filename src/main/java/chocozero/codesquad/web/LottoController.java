package chocozero.codesquad.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import lotto.dto.ResultDto;
import lotto.model.InvalidInputException;
import lotto.model.LottoGenerator;
import lotto.model.Lottos;
import lotto.model.Result;
import lotto.model.WinningLotto;

@Controller
@RequestMapping("/lotto")
public class LottoController {
    static final String NEWLINE = System.getProperty("line.separator");
    
    Lottos lottos = null;
    
    @GetMapping("")
    public String home() {
        return "lotto/index";
    }
    
    @PostMapping("/buyLotto")
    public String buyLotto(String inputMoney, String manualNumber, Model model) {
        String[] manuals = manualNumber.split(NEWLINE);
        try {
            this.lottos = LottoGenerator.generateByMoney(inputMoney, manuals);
        } catch (InvalidInputException e) {
            e.printStackTrace();
            model.addAttribute("err", e.getMessage());
            return "lotto/input_failed";
        }
        model.addAttribute("volume", this.lottos.count());
        model.addAttribute("lottos", this.lottos.getLottos());
        return "lotto/show";
    }
    @GetMapping("/buyLotto")
    public ModelAndView getWinngLotto(Model model) {
        ModelAndView mav = new ModelAndView("lotto/show");
        
        return mav;
    }
    
    @PostMapping("/matchLotto")
    public String matchLotto(String winningNumber, String bonusNumber, Model model) {
        WinningLotto winningLotto = null;
        try {
            winningLotto = new WinningLotto(winningNumber, bonusNumber);
        } catch (InvalidInputException e) {
            e.printStackTrace();
            model.addAttribute("err", e.getMessage());
            model.addAttribute("volume", this.lottos.count());
            model.addAttribute("lottos", this.lottos.getLottos());
            return "lotto/show_failed";
        }
        
        Result result = this.lottos.match(winningLotto, winningLotto.getBonus());
        ResultDto resultDto = ResultDto.fromResult(result);
        model.addAttribute("result", resultDto);
        return "lotto/result";
    }
}
