package com.controle.financas.pessoal.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum TipoTransacao {
    RECEITA,
    DESPESA;

    @JsonCreator
    public static TipoTransacao fromString(String valor){
        return TipoTransacao.valueOf(valor.toUpperCase());
    }

    public boolean isReceita(){
        return this == RECEITA;
    }
    public boolean isDespesa(){
        return this == DESPESA;
    }
}
