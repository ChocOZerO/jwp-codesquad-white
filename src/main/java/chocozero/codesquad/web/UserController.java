package chocozero.codesquad.web;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import chocozero.codesquad.domain.User;

@Controller
public class UserController {
	ArrayList<User> users = new ArrayList<>();
	
	@PostMapping("/users")
	public ModelAndView create(String userId, String password, String name, String email) {
		System.out.println(String.format("userId : %s, password : %s, name : %s, email : %s", userId, password, name, email));
		
		User user = new User();
		user.setUserId(userId);
		user.setPassword(password);
		user.setName(name);
		user.setEmail(email);
		
		users.add(user);
		System.out.println("size : " + users.size());
		
		ModelAndView mav = new ModelAndView("user/list");
		mav.addObject("users", users);
		return mav;
	}
}
