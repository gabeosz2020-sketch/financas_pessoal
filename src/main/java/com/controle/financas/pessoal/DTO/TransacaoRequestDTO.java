package com.controle.financas.pessoal.DTO;

import com.controle.financas.pessoal.enums.TipoTransacao;

import java.math.BigDecimal;

public class TransacaoRequestDTO {

    private String descricao;
    private BigDecimal valor;
    private TipoTransacao tipo;

    public TransacaoRequestDTO(BigDecimal valor, String descricao, TipoTransacao tipo) {
        this.valor = valor;
        this.descricao = descricao;
        this.tipo = tipo;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public TipoTransacao getTipo() {
        return tipo;
    }

    public void setTipo(TipoTransacao tipo) {
        this.tipo = tipo;
    }
}
