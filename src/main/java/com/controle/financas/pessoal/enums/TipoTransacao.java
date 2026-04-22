package com.controle.financas.pessoal.enums;

public enum TipoTransacao {
    RECEITA,
    DESPESA;

    public boolean isReceita(){
        return this == RECEITA;
    }
    public boolean isDespesa(){
        return this == DESPESA;
    }
}
