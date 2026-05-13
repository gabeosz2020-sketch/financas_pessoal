package com.controle.financas.pessoal.repository;

import com.controle.financas.pessoal.model.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
}
