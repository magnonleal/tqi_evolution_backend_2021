package com.magnon.tqifinanceira.repository;

import com.magnon.tqifinanceira.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    public Optional<Cliente> findByEmail(String email);

    @Override
    List<Cliente> findAll();

    @Override
    Optional<Cliente> findById(Long id);

    @Query(value = "SELECT id, valor, num_parcelas FROM emprestimo e WHERE e.id_cliente=?", nativeQuery = true)
    List empPorCliente(@Param("id") Long id);

    @Query(value = "SELECT c.email, c.renda, e.id, e.valor, e.num_parcelas, e.pri_parcela " +
            "FROM cliente c " +
            "INNER JOIN emprestimo e " +
            "ON c.id = e.id_cliente " +
            "WHERE c.id=?", nativeQuery = true)
    List detalheEmpCli(@Param("id") Long id);

    @Override
    void deleteById(Long id);
}
