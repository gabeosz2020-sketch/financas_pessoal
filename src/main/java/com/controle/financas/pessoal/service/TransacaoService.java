package com.controle.financas.pessoal.service;

import com.controle.financas.pessoal.entity.Transacao;
import com.controle.financas.pessoal.repository.TransacaoRepository;
import org.springframework.stereotype.Service;

@Service
public class TransacaoService {

    private final TransacaoRepository repository;


    public TransacaoService(TransacaoRepository repository) {
        this.repository = repository;
    }

    public Transacao criarTransacao(Transacao transacao){


        return repository.save(transacao);
    }
}
