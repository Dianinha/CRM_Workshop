package pl.coderslab.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.coderslab.entities.User;
import pl.coderslab.repositories.ActivityRepository;
import pl.coderslab.repositories.ProjectRepository;
import pl.coderslab.repositories.UserRepository;
import pl.coderslab.repositories.UserRoleRepository;

@Controller
public class HomeController {

	@Autowired
	private ProjectRepository projectRepo;

	@Autowired
	private ActivityRepository activityRepo;

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private UserRoleRepository userRoleRepo;

	@GetMapping(path = "/")
	public String homepage(Model model) {
		model.addAttribute("activities", activityRepo.findAll());
		// model.addAttribute("projects", projectRepo.findAll());
		model.addAttribute("projects", projectRepo.findTop5ByOrderByCreatedDesc());

		return "index";
	}

	@GetMapping(path = "/logout")
	public String logout(Model model, HttpSession session) {
		model.addAttribute("activities", activityRepo.findAll());
		model.addAttribute("projects", projectRepo.findAll());
		User userLoggingOut = userRepo.findOne((Long) session.getAttribute("loggedUser"));
		model.addAttribute("message", "Goodbye " + userLoggingOut.getName() + " " + userLoggingOut.getSurname() + "!");
		session.setAttribute("loggedUser", null);
		if (session.getAttribute("isAdmin") != null && session.getAttribute("isAdmin").equals("yes")) {
			session.setAttribute("isAdmin", null);
		}
		return "index";
	}

	@GetMapping(path = "/admin/nope")
	public String homepageAdmin(Model model) {
		model.addAttribute("activities", activityRepo.findAll());
		model.addAttribute("projects", projectRepo.findAll());

		return "index";
	}

	@GetMapping(path = "/login")
	public String login(Model model) {

		return "/login/login";
	}

	@GetMapping(path = "/accessDenied")
	public String accessDenied(Model model) {

		return "/login/accessDenied";
	}

	@PostMapping(path = "/login")
	public String loginPost(Model model, @RequestParam("username") String username,
			@RequestParam("password") String password, HttpSession session) {
		if (username.equals("") || password.equals("")) {
			model.addAttribute("message", "Not sufficient data to log in.");
			return "/login/login";
		}

		User user = userRepo.findByLogin(username);
		if (user != null) {

			if (BCrypt.checkpw(password, user.getPassword())) {
				model.addAttribute("message", "You have successfully logged in.");
				session.setAttribute("loggedUser", user.getId());
				return "index";
			} else {
				model.addAttribute("message", "Login attempt failed");
				return "/login/login";
			}
		} else {
			model.addAttribute("message", "Login attempt failed");
			return "/login/login";
		}

	}

	@GetMapping(path = "/register")
	public String register(Model model) {
		model.addAttribute("user", new User());
		return "user/add";
	}

	@PostMapping(path = "/register")
	public String registerPost(@Valid User user, BindingResult result, Model model, HttpSession session) {
		if (result.hasErrors()) {
			model.addAttribute("message", "Your register attempt have not worked. Please try again.");
			return "/user/add";
		}
		if (BCrypt.checkpw("", user.getPassword())) {
			model.addAttribute("message", "Error. Your password is empty!");
			return "/user/add";
		}
		try {
			model.addAttribute("message", "You have successfully registered!");
			user.setUserRole(userRoleRepo.findByRole("ROLE_USER"));
			User savedUser = userRepo.save(user);
			session.setAttribute("loggedUser", savedUser.getId());
			return "index";
		} catch (Exception e) {
			model.addAttribute("message", "Error. This username is already in use. Pick another one!");
			return "/user/add";
		}

	}

}
