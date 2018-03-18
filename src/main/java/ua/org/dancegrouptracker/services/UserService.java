package ua.org.dancegrouptracker.services;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.org.dancegrouptracker.dao.UserDao;
import ua.org.dancegrouptracker.exceptions.EmailExistsException;
import ua.org.dancegrouptracker.model.User;

import java.util.List;

/**
 * Created by SeVlad on 14.03.2017.
 */
@Service
@Setter
public class UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Transactional
    public User getUserByUsername(String username) {
        return userDao.findOne(username);
    }

    @Transactional
    public String saveOrUpdateUser(User user) throws EmailExistsException {
        String password = user.getPassword();
        if (password != null) {
            user.setEncodedPassword(passwordEncoder.encode(password));
        }
        if (!userDao.getUserByEmail(user.getEmail()).isEmpty())
            throw new EmailExistsException();
        else {
            userDao.saveAndFlush(user);
            return user.getUsername();
        }
    }

    @Transactional
    public List<User> getAllUsers() {
        return userDao.findAll();
    }

    @Transactional
    public void deleteUser(User user) {
        userDao.delete(user);
    }
}
