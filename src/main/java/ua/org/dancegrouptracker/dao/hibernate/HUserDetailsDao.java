package ua.org.dancegrouptracker.dao.hibernate;

import ua.org.dancegrouptracker.dao.UserDetailsDao;
import ua.org.dancegrouptracker.model.UserDetails;

import java.util.List;

/**
 * Created by SeVlad on 14.04.2017.
 */
public class HUserDetailsDao implements UserDetailsDao {
    @Override
    public UserDetails read(String id) {
        return null;
    }

    @Override
    public String saveOrUpdate(UserDetails userDetails) {
        return userDetails.getUsername();
    }

    @Override
    public void delete(UserDetails persistentObject) {

    }

    @Override
    public List<UserDetails> getAll() {
        return null;
    }
}
