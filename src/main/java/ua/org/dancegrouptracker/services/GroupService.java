package ua.org.dancegrouptracker.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.org.dancegrouptracker.dao.GroupDao;
import ua.org.dancegrouptracker.model.Group;

import java.util.List;

/**
 * Created by SeVlad on 02.05.2017.
 */
@Service
public class GroupService {
    @Autowired
    private GroupDao groupDao;

    @Transactional
    public Long saveOrUpdateGroup(Group group) {
        groupDao.save(group);
        return group.getId();
    }

    @Transactional
    public void deleteGroup(Group group) {
        groupDao.delete(group);
    }

    @Transactional
    public Group findGroupById(Long id) {
        return groupDao.findOne(id);
    }

    @Transactional
    public List<Group> getAllGroups() {
        return groupDao.findAll();
    }

    @Transactional
    public List<Group> findGroupByName(String name) {
        return groupDao.getGroupByNameLike(name);
    }
}
