package ua.org.dancegrouptracker.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.org.dancegrouptracker.model.Group;
import ua.org.dancegrouptracker.model.GroupRole;
import ua.org.dancegrouptracker.model.User;
import ua.org.dancegrouptracker.model.UserGroupRole;

import java.util.List;

/**
 * Created by SeVlad on 09.05.2017.
 */
@Repository
public interface UserGroupRoleDao extends JpaRepository<UserGroupRole, Long> {

    List<UserGroupRole> findByGroup(Group group);

    List<UserGroupRole> findByUser(User user);

    List<UserGroupRole> findByGroupRole(GroupRole groupRole);

    List<UserGroupRole> findByUserAndGroupAndGroupRole(User user, Group group, GroupRole groupRole);
}
