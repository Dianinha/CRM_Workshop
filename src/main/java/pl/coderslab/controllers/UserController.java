package pl.coderslab.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.coderslab.entities.Project;
import pl.coderslab.entities.Task;
import pl.coderslab.entities.User;
import pl.coderslab.repositories.TaskRepository;
import pl.coderslab.repositories.UserRepository;

@Controller
@RequestMapping(path = "/user")
public class UserController {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private TaskRepository taskRepo;


	@GetMapping(path = "")
	public String userMainPage(Model model, HttpSession session) {
		long loggedUserId = (long) session.getAttribute("loggedUser");
		User loggedUser = userRepo.findOne(loggedUserId);
		model.addAttribute("currentUser", loggedUser);
		List<Project> userProjects = loggedUser.getProjects();
		model.addAttribute("myProjects", userProjects);
		List<Task> userTasks = taskRepo.findByActiveUserId(loggedUserId);
		model.addAttribute("myTasks", userTasks);
		return "user/main";
	}
	
	@GetMapping(path = "/myProjects")
	public String UserProjects(Model model, HttpSession session) {
		long loggedUserId = (long) session.getAttribute("loggedUser");
		User loggedUser = userRepo.findOne(loggedUserId);
		model.addAttribute("currentUser", loggedUser);
		List<Project> userProjects = loggedUser.getProjects();
		model.addAttribute("myProjects", userProjects);
		return "user/myProjects";
	}
	
	@GetMapping(path = "/myTasks")
	public String UserTask(Model model, HttpSession session) {
		long loggedUserId = (long) session.getAttribute("loggedUser");
		User loggedUser = userRepo.findOne(loggedUserId);
		model.addAttribute("currentUser", loggedUser);
		List<Task> userTasks = taskRepo.findByActiveUserId(loggedUserId);
		model.addAttribute("myTasks", userTasks);
		return "user/myTasks";
	}

	@GetMapping(path = "/edit")
	public String editUser(Model model, HttpSession session) {
		long loggedUserId = (long) session.getAttribute("loggedUser");
		User userToEdit = userRepo.findOne(loggedUserId);
		model.addAttribute("user", userToEdit);
		return "user/edit";
	}

	@PostMapping(path = "/edit")
	public String editUserPost(@ModelAttribute User user, Model model, HttpSession session) {
		model.addAttribute("message", "You have successfully edited user's data!");
		long loggedUserId = (long) session.getAttribute("loggedUser");
		User merged = userRepo.findOne(loggedUserId);
		merged.mergeFromEdit(user);
		userRepo.save(merged);
		return "user/main";
	}

	@GetMapping(path = "/changePassword")
	public String changePassword() {
		return "user/changePassword";
	}

	@PostMapping(path = "/changePassword")
	public String changePasswordPost(@RequestParam("oldPassword") String pass,
			@RequestParam("newPassword") String newPass, @RequestParam("newPassword2") String newPass2, Model model,
			HttpSession session) {

		long loggedUserId = (long) session.getAttribute("loggedUser");
		User activeUser = userRepo.findOne(loggedUserId);
		if (!BCrypt.checkpw(pass, activeUser.getPassword())) {
			model.addAttribute("message", "Wrong password.");
			return "user/changePassword";
		}

		if (!newPass.equals(newPass2)) {
			model.addAttribute("message", "New password does not match");
			return "user/changePassword";
		}
		activeUser.setPassword(newPass);
		userRepo.save(activeUser);
		model.addAttribute("message", "You have successfully changed Your password");
		return "user/main";
	}

}
