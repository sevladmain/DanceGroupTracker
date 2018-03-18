package ua.org.dancegrouptracker.model;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by SeVlad on 02.05.2017.
 */
@Data
@Entity
@Table(name = "groups")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

}
