package com.controle.financas.pessoal.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(TransacaoNaoEncontradaException.class)
    public ResponseEntity<String> handleTransacaoNaoEncontrada(TransacaoNaoEncontradaException ex ) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> errosValidacao(MethodArgumentNotValidException ex ){
        Map<String, String> erros = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(erro ->
        erros.put(erro.getField(), erro.getDefaultMessage())
    );
    return ResponseEntity.badRequest().body(erros);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Map<String, String>> errosLeituraJson(HttpMessageNotReadableException ex){
        Map<String, String> erro = new HashMap<>();
        erro.put("erro", "Dados invalidos no corpo da requisição. Verifique os tipos e valores enviados.");
        return ResponseEntity.badRequest().body(erro);

    }

}
