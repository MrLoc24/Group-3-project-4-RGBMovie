package com.rgbmovie.config;

import com.rgbmovie.model.RoleModel;
import com.rgbmovie.model.UserModel;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serial;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CustomUserDetails implements UserDetails {

    @Serial
    private static final long serialVersionUID = -8214062200052083773L;

    private UserModel userModel;

    public CustomUserDetails(UserModel userModel) {
        super();
        this.userModel = userModel;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        Collection<RoleModel> roles = userModel.getRoles();
        for (RoleModel role : roles) {
            SimpleGrantedAuthority simple = new SimpleGrantedAuthority(role.getName());
            authorities.add(simple);
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return userModel.getPassword();
    }

    @Override
    public String getUsername() {
        return userModel.getUsername();
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
        return true;
    }
}
