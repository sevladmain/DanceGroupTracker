package ua.org.dancegrouptracker.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import ua.org.dancegrouptracker.dao.UserDao;
import ua.org.dancegrouptracker.exceptions.EmailExistsException;
import ua.org.dancegrouptracker.model.User;

import java.util.List;

/**
 * Created by SeVlad on 14.03.2017.
 */
public class UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    PasswordEncoder passwordEncoder;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    public User getUserByUsername(String username) {
        return userDao.read(username);
    }

    @Transactional
    public String saveOrUpdateUser(User user) throws EmailExistsException {
        String password = user.getPassword();
        if (password != null) {
            user.setEncodedPassword(passwordEncoder.encode(password));
        }
        if (userDao.getUserByEmail(user.getEmail()) != null)
            throw new EmailExistsException();
        else
            return userDao.saveOrUpdate(user);
    }

    @Transactional
    public List<User> getAllUsers() {
        return userDao.getAll();
    }

    @Transactional
    public void deleteUser(User user) {
        userDao.delete(user);
    }
}
