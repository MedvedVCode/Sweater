package medved.java.sweater.entity;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    USER,
    ADMINISTRATOR;

    @Override
    public String getAuthority() {
        return name();
    }
}
