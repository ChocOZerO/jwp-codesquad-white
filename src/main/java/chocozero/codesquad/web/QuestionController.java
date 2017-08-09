package chocozero.codesquad.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import chocozero.codesquad.domain.Question;
import chocozero.codesquad.domain.QuestionRepository;
import chocozero.codesquad.domain.User;

@Controller
public class QuestionController {
	@Autowired
	QuestionRepository questionRepository;
	
	@PostMapping("/qna/form")
	ModelAndView ask(Question question, HttpSession session) {
		Object tempSession = session.getAttribute("loginedUser");
		if (tempSession == null) {
			return new ModelAndView("redirect:/");
		}
		User tempUser = (User)tempSession;
		question.setWriter(tempUser.getUserId());
		question.setUserPk(tempUser.getId());
		System.out.println(question);
		questionRepository.save(question);
		return new ModelAndView("redirect:/");
	}
	@GetMapping("/qna/form")
	ModelAndView form(HttpSession session) {
		Object tempSession = session.getAttribute("loginedUser");
		if (tempSession == null) {
			return new ModelAndView("redirect:/");
		}
		return new ModelAndView("qna/form");
	}
	
	@GetMapping("/")
	ModelAndView getQuestions() {
		ModelAndView mav = new ModelAndView("qna/list");
		mav.addObject("questions", questionRepository.findAll());
		return mav;
	}
	
	@GetMapping("/qna/{id}")
	ModelAndView showQuestionDetail(@PathVariable Long id) {
		ModelAndView mav = new ModelAndView("qna/show");
		mav.addObject("question", questionRepository.findOne(id));
		return mav;
	}
	
	@PostMapping("/qna/{id}/form")
	ModelAndView update(@PathVariable Long id, Question question, HttpSession session) {
		Object tempSession = session.getAttribute("loginedUser");
		if (tempSession == null) {
			return new ModelAndView("redirect:/");
		}
		Question dbQuestion = questionRepository.findOne(id);
		User tempUser = (User)tempSession;
		if (!dbQuestion.matchUser(tempUser.getId())) {
			return new ModelAndView("redirect:/qna/{id}");
		}
		
		dbQuestion.setTitle(question.getTitle());
		dbQuestion.setWriter(tempUser.getUserId());
		dbQuestion.setContents(question.getContents());
		
		System.out.println(dbQuestion);
		questionRepository.save(dbQuestion);
		return new ModelAndView("redirect:/");
	}
	@GetMapping("/qna/{id}/form")
	ModelAndView updateForm(@PathVariable Long id, HttpSession session) {
		Object tempSession = session.getAttribute("loginedUser");
		if (tempSession == null) {
			return new ModelAndView("redirect:/");
		}
		User tempUser = (User)tempSession;
		Question dbQuestion = questionRepository.findOne(id);
		if (dbQuestion.getUserPk() != tempUser.getId()) {
			return new ModelAndView("redirect:/");
		}
		ModelAndView mav = new ModelAndView("qna/updateForm");
		mav.addObject("question", dbQuestion);
		return mav;
	}
}
