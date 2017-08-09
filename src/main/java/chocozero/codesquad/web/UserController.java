package chocozero.codesquad.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import chocozero.codesquad.domain.User;
import chocozero.codesquad.domain.UserRepository;

@Controller
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/{id}")
	public ModelAndView show(@PathVariable Long id) {
		User user = userRepository.findOne(id);
		ModelAndView mav = new ModelAndView("user/profile");
		mav.addObject("user", user);
		return mav;
	}
	
	@PostMapping("/{id}")
	public String update(@PathVariable Long id, User user) {
		User dbUser = userRepository.findOne(id);
		
		if (dbUser.update(user)) {
		    userRepository.save(dbUser);
		}
		return "redirect:/users";
	}
	
	@GetMapping("/form")
	public String form() {
		return "user/form";
	}
	
	@PostMapping("")
	public String create(User user) {
		userRepository.save(user);
		return "redirect:/users";
	}
	
	@GetMapping("")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView("user/list");
		mav.addObject("users", userRepository.findAll());
		return mav;
	}
	
	@GetMapping("/login")
	public String loginForm() {
		return "user/login";
	}
	
	@PostMapping("/login")
	public String login(String userId, String password, HttpSession session) {
		System.out.println("userId : " + userId + " password : " + password);
		User dbUser = userRepository.findByUserId(userId);
		if (dbUser == null) {
			return "user/login_failed";
		}
		if (!dbUser.matchPassword(password)) {
			return "user/login_failed";
		}
		session.setAttribute("loginedUser", dbUser);
		return "redirect:/";
	}
	
	@GetMapping("/{id}/form")
	public ModelAndView getUserDetail(@PathVariable Long id) {
		ModelAndView mav = new ModelAndView("user/updateForm");
		mav.addObject("user", userRepository.findOne(id));
		return mav;
	}
	
}
