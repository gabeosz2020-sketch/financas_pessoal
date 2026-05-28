package com.controle.financas.pessoal.controller;

import com.controle.financas.pessoal.DTO.SaldoResponse;
import com.controle.financas.pessoal.model.Transacao;
import com.controle.financas.pessoal.service.TransacaoService;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/transacoes")
public class TransacaoControler {

    private final TransacaoService service;

    public TransacaoControler(TransacaoService service){
        this.service = service;
    }

    @PostMapping
    public Transacao criarTransacao(@RequestBody Transacao transacao) {
        return service.criarTransacao(transacao);
    }

    @GetMapping
    public List<Transacao> listarTransacoes(){
        return service.listarTransacoes();
    }

    @GetMapping("/saldo")
    public SaldoResponse obterSaldo() {
        BigDecimal saldo = service.calcularSaldo();

        NumberFormat format = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

        String saldoFormatado = format.format(saldo);

        return new SaldoResponse(
                saldo,
                "BRL",
                saldoFormatado
        );
    }

    @GetMapping("/{id}")
    public Transacao pesquisarPorId(@PathVariable("id") Long id ){
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Transacao atualizar(@PathVariable Long id, @RequestBody Transacao transacao){
        return service.atualizarTransacao(id, transacao);
    }
}
