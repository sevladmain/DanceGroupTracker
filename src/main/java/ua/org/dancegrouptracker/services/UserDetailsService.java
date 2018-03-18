package ua.org.dancegrouptracker.services;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.org.dancegrouptracker.dao.UserDetailsDao;
import ua.org.dancegrouptracker.model.UserDetails;

import java.util.List;

/**
 * Created by SeVlad on 18.04.2017.
 */
@Service
@Setter
public class UserDetailsService {

    @Autowired
    private UserDetailsDao userDetailsDao;

    @Transactional
    public UserDetails getUserDetailsByUsername(String username){
        return userDetailsDao.findOne(username);
    }

    @Transactional
    public List<UserDetails> getAllUserDetails(){
        return userDetailsDao.findAll();
    }

    @Transactional
    public String saveOrUpdateUserDetails(UserDetails userDetails){
        userDetailsDao.save(userDetails);
        return userDetails.getUsername();
    }

    @Transactional
    public void deleteUserDetails(UserDetails userDetails){
        userDetailsDao.delete(userDetails);
    }

}
