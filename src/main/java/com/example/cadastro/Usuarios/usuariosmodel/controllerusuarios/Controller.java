package com.example.cadastro.Usuarios.usuariosmodel.controllerusuarios;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping
public class Controller {
   
   
    @GetMapping("/boasvindas")//=localhost:8080/boasVindas
public String boasVindas(){


return "essa é minha primeira mensagem nessa rota";


}

}
