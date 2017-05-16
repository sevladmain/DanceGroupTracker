package ua.org.dancegrouptracker.model;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Created by SeVlad on 09.05.2017.
 */
@Entity
@Table(name = "usergrouprole")
@AssociationOverrides({
        @AssociationOverride(name = "key.user", joinColumns = @JoinColumn(name = "username")),
        @AssociationOverride(name = "key.group", joinColumns = @JoinColumn(name = "groupid"))
})
public class UserGroupRole {

    @EmbeddedId
    private UserGroupRoleKey key = new UserGroupRoleKey();

    @Column(name = "grouprole")
    @Enumerated(EnumType.STRING)
    private GroupRole groupRole;


    public GroupRole getGroupRole() {
        return groupRole;
    }

    public void setGroupRole(GroupRole groupRole) {
        this.groupRole = groupRole;
    }

    public UserGroupRoleKey getKey() {
        return key;
    }

    public void setKey(UserGroupRoleKey key) {
        this.key = key;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserGroupRole that = (UserGroupRole) o;

        if (key != null ? !key.equals(that.key) : that.key != null) return false;
        return groupRole == that.groupRole;

    }

    @Override
    public int hashCode() {
        int result = key != null ? key.hashCode() : 0;
        result = 31 * result + (groupRole != null ? groupRole.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UserGroupRole{" +
                "key=" + key +
                ", groupRole=" + groupRole +
                '}';
    }
}
