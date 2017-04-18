package ua.org.dancegrouptracker.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import ua.org.dancegrouptracker.dao.UserDetailsDao;
import ua.org.dancegrouptracker.model.UserDetails;

import java.util.List;

/**
 * Created by SeVlad on 18.04.2017.
 */
public class UserDetailsService {

    @Autowired
    private UserDetailsDao userDetailsDao;

    @Transactional
    public UserDetails getUserDetailsByUsername(String username){
        return userDetailsDao.read(username);
    }

    @Transactional
    public List<UserDetails> getAllUserDetails(){
        return userDetailsDao.getAll();
    }

    @Transactional
    public String saveOrUpdateUserDetails(UserDetails userDetails){
        return userDetailsDao.saveOrUpdate(userDetails);
    }

    @Transactional
    public void deleteUserDetails(UserDetails userDetails){
        userDetailsDao.delete(userDetails);
    }

}
