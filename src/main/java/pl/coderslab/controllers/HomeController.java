package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import pl.coderslab.repositories.ActivityRepository;
import pl.coderslab.repositories.ProjectRepository;

@Controller
public class HomeController {

	@Autowired
	private ProjectRepository projectRepo;

	@Autowired
	private ActivityRepository activityRepo;

	@GetMapping(path = "/")
	public String homepage(Model model) {
		model.addAttribute("activities", activityRepo.findAll());
		model.addAttribute("projects", projectRepo.findAll());
		
		return "index";
	}

}
