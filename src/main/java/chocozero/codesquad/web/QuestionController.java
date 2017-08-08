package chocozero.codesquad.web;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import chocozero.codesquad.domain.Question;

@Controller
public class QuestionController {
	ArrayList<Question> questions = new ArrayList<>();
	
	@PostMapping("/qna")
	ModelAndView ask(Question question) {
		questions.add(question);
		return new ModelAndView("redirect:/");
	}
	@GetMapping("/qna")
	ModelAndView form() {
		return new ModelAndView("qna/form");
	}
	
	@GetMapping("/")
	ModelAndView getQuestions() {
		ModelAndView mav = new ModelAndView("qna/list");
		mav.addObject("questions", questions);
		return mav;
	}
	
	@GetMapping("/questions/{index}")
	ModelAndView showQuestionDetail(@PathVariable int index) {
		Question question = questions.get(index);
		ModelAndView mav = new ModelAndView("qna/show");
		mav.addObject("question", question);
		return mav;
	}
}
