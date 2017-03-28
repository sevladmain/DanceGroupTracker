package ua.org.dancegrouptracker.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.sql.Date;
import java.time.LocalDate;

/**
 * Created by SeVlad on 08.03.2017.
 */
@Entity
@Table(name="users")
public class User {

    @NotBlank
    @Size(min=4, max=15)
    @Pattern(regexp="\\w{4,}$")
    @Id
    @Column(name = "username")
    private String username;

    @NotBlank
    @Size(min=8, max=15)
    @Pattern(regexp = "^\\S+$")
    @Column(name = "password")
    private String password;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(name = "userroles", joinColumns = @JoinColumn (name = "username"),
                inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Role authority;

    @Column(name = "enabled")
    private boolean enabled;

    //TODO: Implement own ValidEmail check not Hibernate
    @Email(message="Email.user.email")
    @Column(name = "email")
    private String email;

    @Column(name = "dateregister")
    private LocalDate dateRegister;

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

    public Role getAuthority() {
        return authority;
    }

    public void setAuthority(Role authority) {
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

    public LocalDate getDateRegister() {
        return dateRegister;
    }

    public void setDateRegister(LocalDate dateRegister) {
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

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", authority=" + authority +
                ", enabled=" + enabled +
                ", email='" + email + '\'' +
                ", dateRegister=" + dateRegister +
                '}';
    }
// TODO: Database support
    // TODO: password encoding
}
