package org.serratec.api.trabalho.trabalhoIndividual.domain;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    @NotBlank(message = "Campo necessário de nome vazio.")
    @Size(max = 150)
    private String nome;

    @Valid
    @Embedded
    Endereco endereco;

    public Funcionario(Long id, String nome, Endereco endereco) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
    }

    public Funcionario() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
