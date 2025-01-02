package jay.springbootadmintrainingjournal.ProjectManagement.Repository;

import jay.springbootadmintrainingjournal.ProjectManagement.Model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
}
