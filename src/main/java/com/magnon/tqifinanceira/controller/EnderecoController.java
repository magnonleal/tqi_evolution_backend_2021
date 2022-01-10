package com.magnon.tqifinanceira.controller;

import com.magnon.tqifinanceira.model.Endereco;
import com.magnon.tqifinanceira.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @GetMapping("/listar")
    public List<Endereco> listarEnd() {
        return enderecoRepository.findAll();
    }
}
