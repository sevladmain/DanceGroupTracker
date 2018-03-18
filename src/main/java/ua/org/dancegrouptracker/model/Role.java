package ua.org.dancegrouptracker.model;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by SeVlad on 08.03.2017.
 */
@Data
@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "role_name")
    @Enumerated(EnumType.STRING)
    private RoleType roleName;

}
