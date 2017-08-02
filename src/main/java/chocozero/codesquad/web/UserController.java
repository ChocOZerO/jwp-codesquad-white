package chocozero.codesquad.web;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import chocozero.codesquad.domain.User;

@Controller
public class UserController {
	ArrayList<User> users = new ArrayList<>();
	
	@PostMapping("/users")
	public ModelAndView create(User user) {
		users.add(user);
		System.out.println("size : " + users.size());
		return new ModelAndView("redirect:/users");
	}
	
	@GetMapping("/users")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView("user/list");
		mav.addObject("users", users);
		return mav;
	}
}
