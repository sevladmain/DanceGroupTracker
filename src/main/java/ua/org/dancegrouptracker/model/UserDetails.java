package ua.org.dancegrouptracker.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;

/**
 * Created by SeVlad on 14.04.2017.
 */
@Data
@Entity
@Table(name = "userdetails")
public class UserDetails {

    @Id
    @Column(name = "username")
    private String username;

    @Column(name = "firstname")
    @Size(min=2, max=15)
    @Pattern(regexp="\\w{2,}$")
    private String firstName;

    @Column(name = "lastname")
    @Size(min=2, max=15)
    @Pattern(regexp="\\w{2,}$")
    private String lastName;

    @Column(name = "dateofbirth")
    @DateTimeFormat(iso= DateTimeFormat.ISO.DATE)
    private LocalDate dateOfBirth;

}
