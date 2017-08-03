package chocozero.codesquad.web;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import chocozero.codesquad.domain.User;

@Controller
public class UserController {
	ArrayList<User> users = new ArrayList<>();
	
	@GetMapping("/users/{index}")
	public ModelAndView show(@PathVariable int index) {
		User user = users.get(index);
		ModelAndView mav = new ModelAndView("user/profile");
		mav.addObject("user", user);
		return mav;
	}
	
	@PostMapping("/users")
	public ModelAndView create(User user) {
		users.add(user);
		return new ModelAndView("redirect:/users");
	}
	
	@GetMapping("/users")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView("user/list");
		mav.addObject("users", users);
		return mav;
	}
	
	@GetMapping("/users/{id}/form")
	public ModelAndView getUserDetail(@PathVariable String id) {
		ModelAndView mav = new ModelAndView("user/updateForm");
		for (User user: users) {
			if (user.getUserId().equals(id)) {
				mav.addObject("user", user);
			}
		}
		return mav;
	}
	
	@PostMapping("/users/{id}/update")
	public ModelAndView update(@PathVariable String id, User user) {
		 
		for (int i = 0; i < users.size(); i++) {
			if(users.get(i).getUserId().equals(id)) {
				users.get(i).setUserId(user.getUserId());
				users.get(i).setPassword(user.getPassword());
				users.get(i).setName(user.getName());
				users.get(i).setEmail(user.getEmail());
			}
		}
		System.out.println(user);
		System.out.println(users);
		return new ModelAndView("redirect:/users");
	}
}
