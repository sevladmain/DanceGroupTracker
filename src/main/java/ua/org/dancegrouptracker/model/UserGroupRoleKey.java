package ua.org.dancegrouptracker.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * Created by SeVlad on 11.05.2017.
 */
@Embeddable
public class UserGroupRoleKey implements Serializable {
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private User user;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private Group group;

    @Column(name = "datefrom")
    private LocalDate dateFrom;

    @Column(name = "dateto")
    private LocalDate dateTo;

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

        UserGroupRoleKey that = (UserGroupRoleKey) o;

        if (user != null ? !user.equals(that.user) : that.user != null) return false;
        if (group != null ? !group.equals(that.group) : that.group != null) return false;
        if (dateFrom != null ? !dateFrom.equals(that.dateFrom) : that.dateFrom != null) return false;
        return dateTo != null ? dateTo.equals(that.dateTo) : that.dateTo == null;

    }

    @Override
    public int hashCode() {
        int result = user != null ? user.hashCode() : 0;
        result = 31 * result + (group != null ? group.hashCode() : 0);
        result = 31 * result + (dateFrom != null ? dateFrom.hashCode() : 0);
        result = 31 * result + (dateTo != null ? dateTo.hashCode() : 0);
        return result;
    }
}
