package ua.org.dancegrouptracker.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.org.dancegrouptracker.model.Role;
import ua.org.dancegrouptracker.model.RoleType;

import java.util.List;

/**
 * Created by SeVlad on 08.03.2017.
 */
@Repository
public interface RoleDao extends JpaRepository<Role, Long> {
    List<Role> findByRoleName(RoleType roleName);
}
