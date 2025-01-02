package jay.springbootadmintrainingjournal.ProjectManagement.Controller;

import jay.springbootadmintrainingjournal.ProjectManagement.Model.Project;
import jay.springbootadmintrainingjournal.ProjectManagement.Service.ProjectService;
import jay.springbootadmintrainingjournal.ProjectManagement.Service.TaskService;
import jay.springbootadmintrainingjournal.ProjectManagement.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private UserService userService;

    @GetMapping("/projects")
    public String listProjects(Model model) {
        List<Project> projects = projectService.getAllProjects();
        model.addAttribute("projects", projects);
        return "views/backend/project-management/project-list";
    }

    @GetMapping("/create")
    public String createProjectForm(Model model) {
        model.addAttribute("project", new Project());
        model.addAttribute("tasks", taskService.getAllTasks());
        model.addAttribute("managers", userService.getAllUsers());
        return "views/backend/project-management/project-create";
    }

    @PostMapping("/projects/save")
    public String createProject(@ModelAttribute Project project, RedirectAttributes redirectAttributes) {
        // Save the project
        projectService.createProject(project);

        // Add a flash attribute for SweetAlert
        redirectAttributes.addFlashAttribute("message", "Project saved successfully!");
        redirectAttributes.addFlashAttribute("alertType", "success");

        return "redirect:/projects";
    }


    @GetMapping("/edit/{id}")
    public String editProjectForm(@PathVariable Long id, Model model) {
        model.addAttribute("project", projectService.getProjectById(id).orElse(new Project()));
        model.addAttribute("managers", userService.getAllUsers());
        return "views/backend/project-management/project-edit";
    }

    @PostMapping("/edit/{id}")
    public String updateProject(@PathVariable Long id, @ModelAttribute Project project) {
        projectService.updateProject(id, project);
        return "redirect:/projects";
    }

    @GetMapping("/delete/{id}")
    public String deleteProject(@PathVariable Long id) {
        projectService.deleteProject(id);
        return "redirect:/projects";
    }

    @GetMapping("/search")
    public String searchProjects(@RequestParam String searchTerm, Model model) {
        List<Project> projects = projectService.searchProjects(searchTerm);
        model.addAttribute("projects", projects);
        return "views/backend/project-management/project-list";
    }
}
