package ua.org.dancegrouptracker.model;

/**
 * Created by SeVlad on 08.03.2017.
 */
public class Authorities {
    private String roleName;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Authorities that = (Authorities) o;

        return roleName != null ? roleName.equals(that.roleName) : that.roleName == null;

    }

    @Override
    public int hashCode() {
        return roleName != null ? roleName.hashCode() : 0;
    }
}
