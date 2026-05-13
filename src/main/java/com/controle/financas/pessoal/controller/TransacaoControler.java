package com.controle.financas.pessoal.controller;

import com.controle.financas.pessoal.model.Transacao;
import com.controle.financas.pessoal.service.TransacaoService;
import org.springframework.web.bind.annotation.*;

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

}
