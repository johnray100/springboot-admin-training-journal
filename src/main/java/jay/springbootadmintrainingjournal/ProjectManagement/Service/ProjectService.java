package jay.springbootadmintrainingjournal.ProjectManagement.Service;

import jay.springbootadmintrainingjournal.ProjectManagement.Model.Project;
import jay.springbootadmintrainingjournal.ProjectManagement.Repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public Optional<Project> getProjectById(Long id) {
        return projectRepository.findById(id);
    }

    public Project createProject(Project project) {
        return projectRepository.save(project);
    }

    public Project updateProject(Long id, Project project) {
        project.setId(id);
        return projectRepository.save(project);
    }

    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }

    public List<Project> searchProjects(String searchTerm) {
        // Assuming search based on name or description
        return projectRepository.findAll().stream()
                .filter(project -> project.getName().contains(searchTerm) || project.getDescription().contains(searchTerm))
                .collect(Collectors.toList());
    }
}
