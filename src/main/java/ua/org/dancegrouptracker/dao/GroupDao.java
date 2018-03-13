package ua.org.dancegrouptracker.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.org.dancegrouptracker.model.Group;

import java.util.List;

/**
 * Created by SeVlad on 02.05.2017.
 */
@Repository
public interface GroupDao extends JpaRepository<Group,Long> {
    List<Group> getGroupByNameLike(String name);
}
