package chocozero.codesquad.web;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import chocozero.codesquad.domain.Question;
import chocozero.codesquad.domain.QuestionRepository;

@Controller
public class QuestionController {
//	ArrayList<Question> questions = new ArrayList<>();
	@Autowired
	QuestionRepository questionRepository;
	
	@PostMapping("/qna")
	ModelAndView ask(Question question) {
//		questions.add(question);
		questionRepository.save(question);
		return new ModelAndView("redirect:/");
	}
	@GetMapping("/qna")
	ModelAndView form() {
		return new ModelAndView("qna/form");
	}
	
	@GetMapping("/")
	ModelAndView getQuestions() {
		ModelAndView mav = new ModelAndView("qna/list");
		mav.addObject("questions", questionRepository.findAll());
		return mav;
	}
	
	@GetMapping("/questions/{id}")
	ModelAndView showQuestionDetail(@PathVariable Long id) {
//		Question question = questions.get(index);
		ModelAndView mav = new ModelAndView("qna/show");
		mav.addObject("question", questionRepository.findOne(id));
		return mav;
	}
}
