package ua.org.dancegrouptracker.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.org.dancegrouptracker.model.UserDetails;

/**
 * Created by SeVlad on 14.04.2017.
 */
@Repository
public interface UserDetailsDao extends JpaRepository<UserDetails, String> {
}
