package com.example.cadastro.Usuarios.usuariosmodel.controllerusuarios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cadastro.Usuarios.atividades.MissoesRepo;
import com.example.cadastro.Usuarios.usuariosmodel.Missoes;

@RestController
@RequestMapping("/missoes")

public class ContMissoes {

@Autowired
private MissoesRepo missoesRepository;

@GetMapping
public List<Missoes> listarMissoes(){
return missoesRepository.findAll();
}
@PostMapping
public Missoes postarMissoes(@RequestBody Missoes missao){
return missoesRepository.save(missao);
}
@DeleteMapping("/{id}")
public void deletarMissao(@PathVariable Long id){
    
    missoesRepository.deleteById(id);
        System.out.println("Houve um erro ao extinguir missão");
    
}


}
