package ua.org.dancegrouptracker.model;

/**
 * Created by SeVlad on 28.03.2017.
 */
public enum RoleType {
    ROLE_USER("ROLE_USER"),
    ROLE_ADMIN("ROLE_ADMIN");

    private final String roleType;

    private RoleType(final String roleType){
        this.roleType = roleType;
    }

    @Override
    public String toString() {
        return roleType;
    }
}
