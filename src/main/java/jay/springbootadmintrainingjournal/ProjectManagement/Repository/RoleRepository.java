package jay.springbootadmintrainingjournal.ProjectManagement.Repository;

import jay.springbootadmintrainingjournal.ProjectManagement.Model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
