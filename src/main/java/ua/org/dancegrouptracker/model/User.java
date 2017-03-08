package ua.org.dancegrouptracker.model;

import java.sql.Date;
import java.util.List;

/**
 * Created by SeVlad on 08.03.2017.
 */
public class User {
    private String username;

    private String password;

    private Authorities authority;

    private boolean enabled;

    private String email;

    private Date dateRegister;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Authorities getAuthority() {
        return authority;
    }

    public void setAuthority(Authorities authority) {
        this.authority = authority;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateRegister() {
        return dateRegister;
    }

    public void setDateRegister(Date dateRegister) {
        this.dateRegister = dateRegister;
    }

    // TODO: Database support
    // TODO: password encoding
}
