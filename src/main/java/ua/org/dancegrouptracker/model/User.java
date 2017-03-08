package ua.org.dancegrouptracker.model;

import java.sql.Date;

/**
 * Created by SeVlad on 08.03.2017.
 */
public class User {
    private String username;

    private String password;

    private String userRole;

    private boolean enabled;

    private String email;

    private Date dateRegister;
    // TODO: add getters and setters
    // TODO: Database support
    // TODO: password encoding
}
