package com.magnon.tqifinanceira.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Data
@Entity
@Table(name = "emprestimo")
@NoArgsConstructor
@AllArgsConstructor
public class Emprestimo implements Serializable {

    private static int maxParcelas = 60;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private double valor;

    @Column(name = "pri_parcela", nullable = true)
    private Date dataPrimeiraParcel;

    @Column(name = "num_parcelas", nullable = false)
    private int quantidadeParcelas;

    @ManyToOne
    @JoinColumn(name="id_cliente")
    private Cliente cliente;
    public long getCliente() {
        return cliente.getId();
    }
}
