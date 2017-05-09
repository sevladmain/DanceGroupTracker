package ua.org.dancegrouptracker.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import ua.org.dancegrouptracker.dao.GroupDao;
import ua.org.dancegrouptracker.model.Group;

import java.util.List;

/**
 * Created by SeVlad on 02.05.2017.
 */
public class GroupService {
    @Autowired
    private GroupDao groupDao;

    @Transactional
    public Long saveOrUpdateGroup(Group group) {
        return groupDao.saveOrUpdate(group);
    }

    @Transactional
    public void deleteGroup(Group group) {
        groupDao.delete(group);
    }

    @Transactional
    public Group findGroupById(Long id) {
        return groupDao.read(id);
    }

    @Transactional
    public List<Group> getAllGroups() {
        return groupDao.getAll();
    }

    @Transactional
    public List<Group> findGroupByName(String name) {
        return groupDao.getGroupByName(name);
    }
}
