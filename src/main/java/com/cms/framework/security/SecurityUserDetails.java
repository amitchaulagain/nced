package com.cms.framework.security;

import com.cms.model.Role;
import com.cms.model.Status;
import com.cms.model.User;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

public class SecurityUserDetails implements UserDetails {

    @Getter
    private final User user;

    public SecurityUserDetails(final User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        final Collection<GrantedAuthority> authorities = new ArrayList<>();
        final Set<Role> userRoles = user.getRoles();
        if (userRoles != null) {
            for (final Role role : userRoles) {
                final SimpleGrantedAuthority authority = new SimpleGrantedAuthority(
                        role.getRole());
                authorities.add(authority);
            }
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return user.getStatus() == Status.APPROVED;
    }
}
