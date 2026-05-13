package com.controle.financas.pessoal.service;

import com.controle.financas.pessoal.model.Transacao;
import com.controle.financas.pessoal.repository.TransacaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransacaoService {

    private final TransacaoRepository repository;

    public TransacaoService(TransacaoRepository repository) {
        this.repository = repository;
    }

    public Transacao criarTransacao(Transacao transacao){
        System.out.println(transacao);
        return repository.save(transacao);
    }

    public List<Transacao> listarTransacoes(){
    return repository.findAll();
    }
}