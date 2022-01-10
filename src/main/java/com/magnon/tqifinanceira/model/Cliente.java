package com.magnon.tqifinanceira.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "cliente")
@NoArgsConstructor
@AllArgsConstructor
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private Long cpf;

    @Column(nullable = false)
    private String rg;

    @Column(nullable = false)
    private double renda;

    @Column(nullable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String senha;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="id_endereco")
     private Endereco endereco;

    @OneToMany(mappedBy = "cliente", cascade=CascadeType.ALL)
    private List<Emprestimo> emprestimo;

}

