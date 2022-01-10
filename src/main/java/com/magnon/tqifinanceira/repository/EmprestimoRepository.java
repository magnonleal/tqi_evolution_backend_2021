package com.magnon.tqifinanceira.repository;

import com.magnon.tqifinanceira.model.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {


    @Override
    List<Emprestimo> findAll();

    @Override
    Optional<Emprestimo> findById(Long id);

    @Override
    void deleteById(Long id);
}