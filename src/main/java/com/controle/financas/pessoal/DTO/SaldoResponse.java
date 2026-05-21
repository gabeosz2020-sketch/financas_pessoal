package com.controle.financas.pessoal.DTO;

import java.math.BigDecimal;

public class SaldoResponse {

    private BigDecimal saldo;
    private String saldoFormatado;
    private String moeda;

    public SaldoResponse (BigDecimal saldo, String saldoFormatado, String moeda){
        this.saldo = saldo;
        this.saldoFormatado = saldoFormatado;
        this.moeda = moeda;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public String getSaldoFormatado() {
        return saldoFormatado;
    }

    public String getMoeda() {
        return moeda;
    }
}
