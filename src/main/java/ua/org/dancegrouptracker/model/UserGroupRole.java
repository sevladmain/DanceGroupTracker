package ua.org.dancegrouptracker.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Created by SeVlad on 09.05.2017.
 */
@Data
@Entity
@Table(name = "usergrouprole")
public class UserGroupRole {

    @Id
    @Column(name = "id")
    private Long id;

    @JoinColumn(name = "username")
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private User user;

    @JoinColumn(name = "groupid")
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private Group group;

    @Column(name = "datefrom")
    private LocalDate dateFrom;

    @Column(name = "dateto")
    private LocalDate dateTo;

    @Column(name = "grouprole")
    @Enumerated(EnumType.STRING)
    private GroupRole groupRole;


}
