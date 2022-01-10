package com.magnon.tqifinanceira.controller;

import com.magnon.tqifinanceira.model.Cliente;
import com.magnon.tqifinanceira.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private PasswordEncoder encoder;

    @PostMapping("/salvar")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Cliente> salvar(@RequestBody Cliente cliente) {
        cliente.setSenha(encoder.encode(cliente.getSenha()));
        return ResponseEntity.ok(clienteRepository.save(cliente));
    }

    @GetMapping("/listarTodos")
    public List<Cliente> listar() {
        return clienteRepository.findAll();
    }

    @GetMapping("/listarCliente/{id}")
    public Optional<Cliente> clienteId(@PathVariable(value = "id") Long id){
        return clienteRepository.findById(id);
    }

    @PostMapping("/apagarCliente/{id}")
    public void apagarCliente(@PathVariable(value = "id") Long id){
        clienteRepository.deleteById(id);
    }


    @GetMapping("/empCliente/{id}")
    public ResponseEntity<List<Cliente>> empCli(@RequestParam("id") Long id) {
        return ResponseEntity.ok(clienteRepository.empPorCliente(id));
    }

    @GetMapping("/empCliente/detalhe/{id}")
    public ResponseEntity<List<Cliente>> detalheEmpCli(@RequestParam("id") Long id) {
        return ResponseEntity.ok(clienteRepository.detalheEmpCli(id));
    }
}



