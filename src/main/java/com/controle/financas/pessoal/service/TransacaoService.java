package com.controle.financas.pessoal.service;

import com.controle.financas.pessoal.enums.TipoTransacao;
import com.controle.financas.pessoal.model.Transacao;
import com.controle.financas.pessoal.repository.TransacaoRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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

    public BigDecimal calcularSaldo(){
        BigDecimal saldo = BigDecimal.ZERO;

        for (Transacao t : repository.findAll()) {

            if (t.getTipo() == TipoTransacao.RECEITA ){
                saldo = saldo.add(t.getValor());

            } else if (t.getTipo() == TipoTransacao.DESPESA) {
                saldo = saldo.subtract(t.getValor());
            }
        }
        return saldo;
    }

    public Transacao buscarPorId(Long id){
        return repository.findById(id).orElse(null);
    }

    public Transacao atualizarTransacao(Long id, Transacao novaTransacao){
       Transacao transacaoExistente = repository.findById(id)
               .orElseThrow(()->
                       new RuntimeException("Transação não encontrada"));

       transacaoExistente.setDescricao(novaTransacao.getDescricao());
       transacaoExistente.setValor(novaTransacao.getValor());
       transacaoExistente.setTipo(novaTransacao.getTipo());
       return repository.save(transacaoExistente);
    }

    public Transacao deletarTransacao(Long id){
        Transacao transacao = repository.findById(id)
                        .orElseThrow(()->
                                new RuntimeException("Transação não encontrada"));

        repository.deleteById(id);

        return transacao;
    }
}