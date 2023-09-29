package com.rgbmovie.config;

import com.rgbmovie.model.RoleModel;
import com.rgbmovie.model.UserModel;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serial;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class CustomUserDetailService extends UserModel implements UserDetails {

    @Serial
    private static final long serialVersionUID = -8214062200052083773L;

    private UserModel userModel = new UserModel();

    public CustomUserDetailService(UserModel userModel) {
        super();
        this.userModel = userModel;
    }

    public CustomUserDetailService() {
		// TODO Auto-generated constructor stub
	}

	@Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for (RoleModel role : userModel.getRoles()) {
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

    public String getEmail(){
        return  userModel.getEmail();
    }
    public String getImage(){
        return userModel.getImages();
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
        return userModel.getEnabled();
    }
}
