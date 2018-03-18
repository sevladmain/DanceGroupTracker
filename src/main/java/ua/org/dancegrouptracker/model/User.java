package ua.org.dancegrouptracker.model;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;
import ua.org.dancegrouptracker.model.validation.TransientValidationGroup;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;

/**
 * Created by SeVlad on 08.03.2017.
 */
@Data
@Entity
@Table(name="users")
public class User {

    @NotBlank
    @Size(min=4, max=15)
    @Pattern(regexp="\\w{4,}$")
    @Id
    @Column(name = "username")
    private String username;

    @NotBlank(groups = TransientValidationGroup.class)
    @Size(min=8, max=15)
    @Pattern(regexp = "^\\S+$")
    @Transient
    private String password;

    @Column(name = "password")
    private String encodedPassword;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(name = "userroles", joinColumns = @JoinColumn (name = "username"),
                inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Role authority;

    @Column(name = "enabled")
    private boolean enabled;

    //@Email(message="Email.user.email")
    @Pattern(regexp = "(?=[a-z0-9@.!#$%&'*+/=?^_`{|}~-]{6,254})(?=[a-z0-9.!#$%&'*+/=?^_`{|}~-]{1,64}@)[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:(?=[a-z0-9-]{1,63}\\.)[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+(?=[a-z0-9-]{1,63})[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message = "Email.user.email")
    @Column(name = "email")
    private String email;

    @Column(name = "dateregister")
    private LocalDate dateRegister;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "userdetails", joinColumns = @JoinColumn(name = "username"),
                inverseJoinColumns = @JoinColumn(name = "username"))
    private UserDetails userDetails;

}
