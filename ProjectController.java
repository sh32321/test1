package com.a0521.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.a0521.pma.dao.EmployeeRepository;
import com.a0521.pma.dao.ProjectRepository;
import com.a0521.pma.entity.Employee;
import com.a0521.pma.entity.Project;

@Controller
@RequestMapping("/projects")
public class ProjectController {
	
	@Autowired
	ProjectRepository proRepo;
	
	@Autowired
	EmployeeRepository empRepo;

	@GetMapping
	public String displayProjects(Model model) {
		
		
		
		
		List<Project> projects = proRepo.findAll();
		model.addAttribute("projectList", projects);
		return "projects/list-projects";
	}
	
//	@RequestMapping("/new")
	@GetMapping("/new")
	public String displayProjectForm(Model model) {
		List<Employee> employee = empRepo.findAll();
		model.addAttribute("employeeList",employee);


		model.addAttribute("project", new Project());
		return "projects/new-project";
	}
	
//	@RequestMapping(value="/save", method = RequestMethod.POST)
	@PostMapping("/save")
	public String createProject(Project project, Model model) {
		//this should handle saving to the database
		proRepo.save(project);
		
		return "redirect:/";
	}
}