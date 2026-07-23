package com.controle.financas.pessoal.model;

import com.controle.financas.pessoal.enums.TipoTransacao;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;


@Entity
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Descrição não pode ser vazia")
    private String descricao;

    @NotNull(message = "Valor não pode ser nulo")
    @Positive(message = "Valor deve ser maior que zero")
    private BigDecimal valor;

    @NotNull(message = "Tipo não pode ser nulo")
    @Enumerated(EnumType.STRING)
    private TipoTransacao tipo;

    public Transacao() {
    }

    // Construtor
    public Transacao(String descricao, BigDecimal valor, TipoTransacao tipo) {
        this.descricao = descricao;
        this.valor = valor;
        this.tipo = tipo;
    }

    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public TipoTransacao getTipo() {
        return tipo;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setTipo(TipoTransacao tipo) {
        this.tipo = tipo;
    }

    public void setId(Long id) {
        this.id = id;

    }

}
