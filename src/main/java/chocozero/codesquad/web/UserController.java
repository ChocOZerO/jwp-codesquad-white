package chocozero.codesquad.web;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import chocozero.codesquad.domain.User;
import chocozero.codesquad.domain.UserRepository;

@Controller
public class UserController {
//	ArrayList<User> users = new ArrayList<>();
	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/users/{id}")
	public ModelAndView show(@PathVariable Long id) {
		User user = userRepository.findOne(id);
		ModelAndView mav = new ModelAndView("user/profile");
		mav.addObject("user", user);
		return mav;
	}
	@GetMapping("/users/form")
	public ModelAndView form() {
		return new ModelAndView("user/form");
	}
	
	@PostMapping("/users")
	public ModelAndView create(User user) {
		userRepository.save(user);
		return new ModelAndView("redirect:/users");
	}
	
	@GetMapping("/users")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView("user/list");
		mav.addObject("users", userRepository.findAll());
		return mav;
	}
	
	@GetMapping("/users/login")
	public ModelAndView login() {
		return new ModelAndView("user/login");
	}
	
	@GetMapping("/users/{id}/form")
	public ModelAndView getUserDetail(@PathVariable Long id) {
		ModelAndView mav = new ModelAndView("user/updateForm");
		mav.addObject("user", userRepository.findOne(id));
		return mav;
	}
	
	@PostMapping("/users/{id}/update")
	public ModelAndView update(@PathVariable Long id, User user) {
		User userTmp = userRepository.findOne(id);
		userTmp.setName(user.getName());
		userTmp.setPassword(user.getPassword());
		userTmp.setEmail(user.getEmail());
		userRepository.save(userTmp);
		return new ModelAndView("redirect:/users");
	}
}
