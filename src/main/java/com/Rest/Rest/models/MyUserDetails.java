package com.Rest.Rest.models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MyUserDetails implements UserDetails {
    //Tener atributos con estos nombres
    private String username;
    private String password;
    private List<GrantedAuthority> autorities;
    //Adaptamos el usuario q tenemos
    public MyUserDetails(Usuario usuario){
        this.password =usuario.getPassword();
        this.username=usuario.getNameUser();
        this.autorities=new ArrayList<>();

        for(Rol rol: usuario.getRoles()){
            this.autorities.add(new SimpleGrantedAuthority(rol.name()));
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.autorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
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
