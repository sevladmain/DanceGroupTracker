package ua.org.dancegrouptracker.model;

import java.sql.Date;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (enabled != user.enabled) return false;
        if (username != null ? !username.equals(user.username) : user.username != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (authority != null ? !authority.equals(user.authority) : user.authority != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        return dateRegister != null ? dateRegister.equals(user.dateRegister) : user.dateRegister == null;

    }

    @Override
    public int hashCode() {
        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (authority != null ? authority.hashCode() : 0);
        result = 31 * result + (enabled ? 1 : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (dateRegister != null ? dateRegister.hashCode() : 0);
        return result;
    }
// TODO: Database support
    // TODO: password encoding
}
