package io.odero.auther.auth;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;

public class ApplicationUser implements UserDetails {
    private final String password;
    private final String username;
    private final Set<? extends GrantedAuthority> grantedAuthorities;
    private final boolean isAccountNonExpired;
    private final boolean isCredentialsNonExpired;
    private final boolean isAccountNonLocked;
    private final boolean isEnabled;

    public ApplicationUser(
            String username,
            String password,
            Set<? extends GrantedAuthority> grantedAuthorities,
            boolean isAccountNonExpired,
            boolean isCredentialsNonExpired,
            boolean isAccountNonLocked, boolean isEnabled) {
        this.password = password;
        this.username = username;
        this.grantedAuthorities = grantedAuthorities;
        this.isAccountNonExpired = isAccountNonExpired;
        this.isCredentialsNonExpired = isCredentialsNonExpired;
        this.isAccountNonLocked = isAccountNonLocked;
        this.isEnabled = isEnabled;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return isAccountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isAccountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isCredentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }
}