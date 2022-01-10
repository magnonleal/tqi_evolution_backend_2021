package com.magnon.tqifinanceira.service;

import com.magnon.tqifinanceira.data.ClienteData;
import com.magnon.tqifinanceira.model.Cliente;
import com.magnon.tqifinanceira.repository.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ClienteServiceImpl implements UserDetailsService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Optional<Cliente> clienteModel = clienteRepository.findByEmail(email);
        if (clienteModel.isEmpty()){
            throw new UsernameNotFoundException("email [" + email + "] não encontrado");
        }
        return new ClienteData(clienteModel);
    }

}
