package com.magnon.tqifinanceira.data;

import com.magnon.tqifinanceira.model.Cliente;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

public class ClienteData implements UserDetails {

    @Autowired
    private Optional<Cliente> cliente;

    public ClienteData(Optional<Cliente> cliente) {
        this.cliente = cliente;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new ArrayList<>();
    }

    @Override
    public String getPassword() {
        return cliente.orElse(new Cliente()).getSenha();
    }

    @Override
    public String getUsername() {
        return cliente.orElse(new Cliente()).getEmail();
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
