package ua.org.dancegrouptracker.model;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Created by SeVlad on 09.05.2017.
 */
@Entity
@Table(name = "usergrouprole")
public class UserGroupRole {


    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(name = "users", joinColumns = @JoinColumn (name = "username"),
            inverseJoinColumns = @JoinColumn(name = "username"))
    private User user;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(name = "groups", joinColumns = @JoinColumn (name = "groupid"),
            inverseJoinColumns = @JoinColumn(name = "id"))
    private Group group;

    @Column(name = "datefrom")
    private LocalDate dateFrom;

    @Column(name = "dateto")
    private LocalDate dateTo;

    @Column(name = "grouprole")
    @Enumerated(EnumType.STRING)
    private GroupRole groupRole;

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

    public GroupRole getGroupRole() {
        return groupRole;
    }

    public void setGroupRole(GroupRole groupRole) {
        this.groupRole = groupRole;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserGroupRole that = (UserGroupRole) o;

        if (user != null ? !user.equals(that.user) : that.user != null) return false;
        if (group != null ? !group.equals(that.group) : that.group != null) return false;
        if (dateFrom != null ? !dateFrom.equals(that.dateFrom) : that.dateFrom != null) return false;
        if (dateTo != null ? !dateTo.equals(that.dateTo) : that.dateTo != null) return false;
        return groupRole == that.groupRole;

    }

    @Override
    public int hashCode() {
        int result = user != null ? user.hashCode() : 0;
        result = 31 * result + (group != null ? group.hashCode() : 0);
        result = 31 * result + (dateFrom != null ? dateFrom.hashCode() : 0);
        result = 31 * result + (dateTo != null ? dateTo.hashCode() : 0);
        result = 31 * result + (groupRole != null ? groupRole.hashCode() : 0);
        return result;
    }
}
