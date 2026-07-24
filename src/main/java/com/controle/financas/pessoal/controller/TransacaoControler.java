package com.controle.financas.pessoal.controller;

import com.controle.financas.pessoal.DTO.SaldoResponse;
import com.controle.financas.pessoal.model.Transacao;
import com.controle.financas.pessoal.service.TransacaoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.math.BigDecimal;
import java.net.URI;
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
    public ResponseEntity <Transacao> criarTransacao(@RequestBody @Valid Transacao transacao) {
        Transacao novaTransacao = service.criarTransacao(transacao);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(novaTransacao.getId())
                .toUri();

        return ResponseEntity.created(location).body(novaTransacao);

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

    @DeleteMapping("/{id}")
    public Transacao deletar(@PathVariable Long id){
       return service.deletarTransacao(id);
    }
}
