package com.controle.financas.pessoal.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TesteController {

    @GetMapping("/v1")
    public String teste(){
     return "API esta funcionando!";
    }

}
