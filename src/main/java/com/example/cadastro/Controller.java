package com.example.cadastro;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping
public class Controller {
   
   
    @GetMapping("/boasvindas")//=localhost:8080/boasVindas
public String boasVindas(){


return "essa é minha primeira mensagem nessa rota";
}

}
