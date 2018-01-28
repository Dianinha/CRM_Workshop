package pl.coderslab.controllers;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.coderslab.entities.Activity;
import pl.coderslab.entities.Project;
import pl.coderslab.entities.Status;
import pl.coderslab.entities.Task;
import pl.coderslab.entities.User;
import pl.coderslab.repositories.ActivityRepository;
import pl.coderslab.repositories.PriorityRepository;
import pl.coderslab.repositories.ProjectRepository;
import pl.coderslab.repositories.StatusRepository;
import pl.coderslab.repositories.TaskRepository;
import pl.coderslab.repositories.UserRepository;

@Controller
@RequestMapping(path = "/task")
public class TaskController {

	@Autowired
	private TaskRepository taskRepo;
	
	@Autowired
	private ProjectRepository projectRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private PriorityRepository priorityRepo;
	
	@Autowired
	private StatusRepository statusRepo;
	
	@Autowired
	private ActivityRepository activityRepo;
	
	
	@GetMapping(path = "")
	public String mainTask(Model model, @RequestParam(name="par", required=false) String msg) {
		model.addAttribute("tasks", taskRepo.findAll());
		if (msg!=null) {
			if (msg.equals("succ")) {
				model.addAttribute("message", "You have successfully edited a task!");
			} 
			if (msg.equals("stachan")){
				model.addAttribute("message", "You have successfully changed task's status!");
			}
			if (msg.equals("adds")){
				model.addAttribute("message","You have successfully created a new task!");
			}
		}
		return "task/main";
	}
	
	@GetMapping(path = "/add")
	public String addNewTask(Model model) {
		model.addAttribute("task", new Task());
		model.addAttribute("projects", projectRepo.findAll());
		model.addAttribute("users", userRepo.findAll());
		model.addAttribute("statuses", statusRepo.findAll());
		model.addAttribute("priorities", priorityRepo.findAll());
		return "task/add";
	}

	@PostMapping(path = "/add")
	public String addNewTaskPost(@ModelAttribute Task task, Model model, HttpSession session) {
		model.addAttribute("par", "adds");
		task.setCreated(LocalDateTime.now());
		taskRepo.save(task);
		Project project = projectRepo.findOne(task.getProject().getId());
		Set<User> projectUsers = project.getUsers();
		projectUsers.add(task.getActiveUser());
		projectRepo.save(project);
		
		try {
			User user = userRepo.findOne((Long) session.getAttribute("loggedUser"));
			Activity activity = new Activity();
			activity.setCreated(LocalDateTime.now());
			activity.setUser(user);
			String msg = activity.getInformation(project, task);
			activity.setContent(msg);
			activityRepo.save(activity);
			
		} catch (Exception e) {
			System.out.println("No logged user ERRO ERROR ERROR");
		}
		
		return "redirect:/task";
	}
	
	@GetMapping(path = "/details/{id}")
	public String deleteTask(Model model, @PathVariable("id") long id) {
		Task task = taskRepo.findOne(id);
		model.addAttribute("task", task);
		return "task/details";
	}
	
	@GetMapping(path = "/edit/{id}")
	public String editTask(Model model, @PathVariable("id") long id) {
		model.addAttribute("myTask", taskRepo.findOne(id));
		model.addAttribute("projects", projectRepo.findAll());
		model.addAttribute("users", userRepo.findAll());
		model.addAttribute("statuses", statusRepo.findAll());
		model.addAttribute("priorities", priorityRepo.findAll());
		return "task/edit";
	}

	@PostMapping(path = "/edit/{id}")
	public String editTaskPost(@ModelAttribute Task myTask, Model model) {
		model.addAttribute("par", "succ");
		taskRepo.save(myTask);
		Project project = projectRepo.findOne(myTask.getProject().getId());
		Set<User> projectUsers = project.getUsers();
		projectUsers.add(myTask.getActiveUser());
		projectRepo.save(project);
		return "redirect:/task";
	}
	
	@GetMapping(path = "/changeStatus/{id}")
	public String changeTaskStatus(Model model, @PathVariable("id") long id) {
		model.addAttribute("statuses", statusRepo.findAll());
		return "task/changeStatus";
	}

	@PostMapping(path = "/changeStatus/{id}")
	public String changeTaskStatusPost(@RequestParam("newStatus") long newStatusId, Model model, @PathVariable("id") long id, HttpSession session) {
		model.addAttribute("par", "stachan");
		Status newStatus = statusRepo.findOne(newStatusId);
		Task myTask = taskRepo.findOne(id);
		myTask.setStatus(newStatus);
		taskRepo.save(myTask);
		try {
			User user = userRepo.findOne((Long) session.getAttribute("loggedUser"));
			Activity activity = new Activity();
			activity.setCreated(LocalDateTime.now());
			activity.setUser(user);
			String msg = activity.getInformation(myTask, newStatus);
			activity.setContent(msg);
			activityRepo.save(activity);
			
		} catch (Exception e) {
			System.out.println("No logged user ERRO ERROR ERROR");
		}
		
		return "redirect:/task";
	}
}
