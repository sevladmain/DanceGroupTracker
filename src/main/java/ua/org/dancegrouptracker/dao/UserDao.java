package ua.org.dancegrouptracker.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.org.dancegrouptracker.model.User;

import java.util.List;

/**
 * Created by SeVlad on 08.03.2017.
 */
@Repository
public interface UserDao extends JpaRepository<User, String> {

    List<User> getUserByEmail(String email);
}
