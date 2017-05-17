package ua.org.dancegrouptracker.model;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Created by SeVlad on 09.05.2017.
 */
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


    public GroupRole getGroupRole() {
        return groupRole;
    }

    public void setGroupRole(GroupRole groupRole) {
        this.groupRole = groupRole;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(LocalDate dateFrom) {
        this.dateFrom = dateFrom;
    }

    public LocalDate getDateTo() {
        return dateTo;
    }

    public void setDateTo(LocalDate dateTo) {
        this.dateTo = dateTo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserGroupRole that = (UserGroupRole) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (user != null ? !user.equals(that.user) : that.user != null) return false;
        if (group != null ? !group.equals(that.group) : that.group != null) return false;
        if (dateFrom != null ? !dateFrom.equals(that.dateFrom) : that.dateFrom != null) return false;
        if (dateTo != null ? !dateTo.equals(that.dateTo) : that.dateTo != null) return false;
        return groupRole == that.groupRole;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (group != null ? group.hashCode() : 0);
        result = 31 * result + (dateFrom != null ? dateFrom.hashCode() : 0);
        result = 31 * result + (dateTo != null ? dateTo.hashCode() : 0);
        result = 31 * result + (groupRole != null ? groupRole.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UserGroupRole{" +
                "id=" + id +
                ", user=" + user +
                ", group=" + group +
                ", dateFrom=" + dateFrom +
                ", dateTo=" + dateTo +
                ", groupRole=" + groupRole +
                '}';
    }
}
