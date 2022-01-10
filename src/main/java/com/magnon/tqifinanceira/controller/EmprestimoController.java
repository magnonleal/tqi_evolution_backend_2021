package com.magnon.tqifinanceira.controller;

import com.magnon.tqifinanceira.model.Emprestimo;
import com.magnon.tqifinanceira.repository.EmprestimoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emprestimo")
public class EmprestimoController {

    @Autowired
    private EmprestimoRepository emprestimoRepository;
    @Autowired
    private PasswordEncoder encoder;

    @GetMapping("/listarEmp")
    public List<Emprestimo> listarEmp() {
        return emprestimoRepository.findAll();
    }

    @PostMapping("/salvar")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Emprestimo> salvar(@RequestBody Emprestimo emprestimo) {
        return ResponseEntity.ok(emprestimoRepository.save(emprestimo));
    }

    @PostMapping("/apagar/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void apagarEmp(@PathVariable(value = "id") Long id){
        emprestimoRepository.deleteById(id);
    }
}
