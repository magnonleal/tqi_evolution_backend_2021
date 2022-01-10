package com.magnon.tqifinanceira.repository;

import com.magnon.tqifinanceira.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

    @Override
    List<Endereco> findAll();

}
