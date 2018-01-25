package pl.coderslab.controllers;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.coderslab.entities.Project;
import pl.coderslab.repositories.ProjectRepository;

@Controller
@RequestMapping(path = "/project")
public class ProjectController {

	@Autowired
	private ProjectRepository projectRepo;
	
	@GetMapping(path = "")
	public String mainProject(Model model, @RequestParam(name="par", required=false) String msg) {
		model.addAttribute("projects", projectRepo.findAllByActive(true));
		if (msg!=null) {
			if (msg.equals("succ")) {
				model.addAttribute("message", "You have successfully edited a project!");
			} 
			if (msg.equals("del")){
				model.addAttribute("message", "You have successfully deleted a project!");
			}
			if (msg.equals("adds")){
				model.addAttribute("message","You have successfully created a new project!");
			}
		}
		return "project/main";
	}
	
	@GetMapping(path = "/add")
	public String addNewProject(Model model) {
		model.addAttribute("project", new Project());
		return "project/add";
	}

	@PostMapping(path = "/add")
	public String addNewProjectPost(@ModelAttribute Project project, Model model) {
		model.addAttribute("par", "adds");
		project.setActive(true);
		project.setCreated(LocalDateTime.now());
		project.setIdentifier();
		projectRepo.save(project);
		return "redirect:/project";
	}
	
	@GetMapping(path = "/delete/{id}")
	public String deleteProject(Model model, @PathVariable("id") long id) {
		model.addAttribute("par", "del");
		Project project = projectRepo.findOne(id);
		project.setActive(false);
		projectRepo.save(project);
		return "redirect:/project";
	}
	@GetMapping(path = "/edit/{id}")
	public String editProject(Model model, @PathVariable("id") long id) {
		model.addAttribute("myProject", projectRepo.findOne(id));
		return "project/edit";
	}

	@PostMapping(path = "/edit/{id}")
	public String editProjectPost(@ModelAttribute Project myProject, Model model) {
		model.addAttribute("par", "succ");
		myProject.setActive(true);
		myProject.setIdentifier();
		projectRepo.save(myProject);
		return "redirect:/project";
	}
}