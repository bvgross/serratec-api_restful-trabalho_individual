package org.serratec.api.trabalho.trabalhoIndividual.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.serratec.api.trabalho.trabalhoIndividual.enums.Estado;

@Embeddable
public class Endereco {

    @Column(nullable = false, length = 200)
    @NotBlank(message = "É necessário informar o nome da rua.")
    @Size(max = 200)
    private String rua;

    @Column(nullable = false, length = 100)
    @NotBlank(message = "É necessário informar o nome da cidade.")
    @Size(max = 100)
    private String cidade;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    Estado estado;

    @Column(nullable = false, length = 8)
    @NotBlank(message = "É necessário informar o CEP.")
    @Size(min = 8, max = 8, message = "O cep deve conter 8 números.")
    private String cep;

    public Endereco(String rua, String cidade, Estado estado, String cep) {
        this.rua = rua;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
    }

    public Endereco() {
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}
