package chocozero.codesquad.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import baseball.Baseball;
import baseball.BaseballResult;

import java.util.ArrayList;

@Controller
public class BaseballController {
	
	ArrayList<BaseballResult> baseballResults = new ArrayList<>();
	final ArrayList<Integer> COMPUTER_BALLS = Baseball.generateComputerBalls();
	
	@GetMapping("/baseball")
	public ModelAndView input(String inputValue) {
		
		BaseballResult baseballResult = new BaseballResult();
		ArrayList<Integer> userBalls = Baseball.inputUserBalls(inputValue);
		baseballResult.setTryNumbers(userBalls);
		
		int strike = 0;
		int ball = 0;
		for (int i = 0; i < userBalls.size(); i++) {
			int result = Baseball.calculateBall(COMPUTER_BALLS, userBalls.get(i), i);
			if (result == 2) {
				strike++;
			} else if (result == 1) {
				ball++;
			}
		}
		baseballResult.setResultPrint(String.format("결과 : %d strike, %d ball", strike, ball));
		baseballResults.add(baseballResult);
		
		System.out.println(String.format("시도횟수 : %d 번", baseballResults.size()));
		System.out.println(baseballResult.getResultPrint());
		
		ModelAndView mav = new ModelAndView("baseball/result");
		mav.addObject("strike", strike);
		mav.addObject("ball", ball);
		mav.addObject("userBalls", userBalls);
		mav.addObject("tryCount", baseballResults.size());
		mav.addObject("results", baseballResults);
		if (strike == 3) {
			System.out.println("게임 종료");
			mav.addObject("computerBalls", COMPUTER_BALLS  + " 축하합니다!! ");
		}
		return mav;
	}
}