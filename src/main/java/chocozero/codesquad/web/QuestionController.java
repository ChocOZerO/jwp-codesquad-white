package chocozero.codesquad.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import chocozero.codesquad.domain.Question;
import chocozero.codesquad.domain.QuestionRepository;
import chocozero.codesquad.domain.User;
import chocozero.codesquad.domain.UserRepository;

@Controller
public class QuestionController {
	@Autowired
	QuestionRepository questionRepository;
	@Autowired
	UserRepository userRepository;
	
	@PostMapping("/qna/form")
	ModelAndView ask(Question question, HttpSession session) {
		
		Object tempSession = session.getAttribute("loginedUser");
		if (tempSession == null) {
			return new ModelAndView("redirect:/");
		}
		
		User dbUser = userRepository.findOne(((User)tempSession).getId());
		if (dbUser == null) {
			return new ModelAndView("redirect:/");
		}
		
		question.setWriter(dbUser);
		
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
		User tempUser = (User)tempSession;
		Question dbQuestion = questionRepository.findOne(id);
		if (!dbQuestion.matchUser(tempUser)) {
			return new ModelAndView("redirect:/qna/{id}");
		}
		
		dbQuestion.setTitle(question.getTitle());
		dbQuestion.setWriter(tempUser);
		dbQuestion.setContents(question.getContents());
		
		questionRepository.save(dbQuestion);
		return new ModelAndView("redirect:/");
	}
	
	@GetMapping("/qna/{id}/form")
	ModelAndView updateForm(@PathVariable Long id, HttpSession session) {
		Object tempSession = session.getAttribute("loginedUser");
		if (tempSession == null) {
			return new ModelAndView("redirect:/");
		}
		User dbUser = userRepository.findOne(((User)tempSession).getId());
		if (dbUser == null) {
			return new ModelAndView("redirect:/");
		}
		Question dbQuestion = questionRepository.findOne(id);
		if (dbQuestion.getWriter().getId() != dbUser.getId()) {
			return new ModelAndView("redirect:/");
		}
		
		ModelAndView mav = new ModelAndView("qna/updateForm");
		mav.addObject("question", dbQuestion);
		return mav;
	}
	
	@DeleteMapping("/qna/{id}/delete")
	ModelAndView delete(@PathVariable Long id, Question question, HttpSession session) {
		Object tempSession = session.getAttribute("loginedUser");
		if (tempSession == null) {
			return new ModelAndView("redirect:/");
		}
		User tempUser = (User)tempSession;
		Question dbQuestion = questionRepository.findOne(id);
		if (!dbQuestion.matchUser(tempUser)) {
			return new ModelAndView("redirect:/qna/{id}");
		}
		
		questionRepository.delete(dbQuestion);
		return new ModelAndView("redirect:/");
	}
}
