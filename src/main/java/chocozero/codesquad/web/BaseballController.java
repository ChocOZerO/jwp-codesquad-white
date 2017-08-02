package chocozero.codesquad.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import baseball.Baseball;
import chocozero.codesquad.JwpCodesquadJakeApplication;

import java.util.ArrayList;

@Controller
public class BaseballController {

	@GetMapping("/baseball")
	public ModelAndView input(String inputValue) {

//		ArrayList<Integer> computerBalls = Baseball.generateComputerBalls();

		int strike = 0;
		int ball = 0;
		ArrayList<Integer> userBalls = Baseball.inputUserBalls(inputValue);
		JwpCodesquadJakeApplication.userBallsList.add(userBalls);
		for (int i = 0; i < userBalls.size(); i++) {
			int result = Baseball.calculateBall(JwpCodesquadJakeApplication.COMPUTER_BALLS, userBalls.get(i), i);
			if (result == 2) {
				strike++;
			} else if (result == 1) {
				ball++;
			}
		}
		
		System.out.println(String.format("결과 : %d strike, %d ball", strike, ball));

		if (strike == 3) {
			System.out.println("게임 종료");
		}
		ModelAndView mav = new ModelAndView("baseball/result");
		mav.addObject("strike", strike);
		mav.addObject("ball", ball);
		mav.addObject("userBalls", userBalls);
		mav.addObject("computerBalls", JwpCodesquadJakeApplication.COMPUTER_BALLS);
		mav.addObject("userBallsList", JwpCodesquadJakeApplication.userBallsList);
		return mav;
	}
}