package com.example.cadastro.Usuarios.usuariosmodel.controllerusuarios;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.cadastro.Usuarios.UsuariosRepository;
import com.example.cadastro.Usuarios.atividades.MissoesRepo;
import com.example.cadastro.Usuarios.usuariosmodel.Missoes;
import com.example.cadastro.Usuarios.usuariosmodel.UsuarioModel;

@RestController
@RequestMapping("/juncao")

public class ContJuncao {
    @Autowired
    private UsuariosRepository usuarioRepository;
    @Autowired
    private MissoesRepo missoesRepository;

//em obras, iniciar PUT dinãmico
@GetMapping("/missoes/duracao/{maccher}")
public ResponseEntity<Integer> pegarDuracao(@PathVariable Long maccher){
    return missoesRepository.findById(maccher).map(m -> ResponseEntity.ok(m.getDuracao()))
    .orElse(ResponseEntity.notFound().build());
}

/* 
    @GetMapping("/missoes/duracao")
    public List<Integer> pegarDuracao(){
        return missoesRepository.findAll().stream().map(Missoes::getDuracao)
        .collect(Collectors.toList());
    }*/

@GetMapping("/usuarios/lista-ids")
    public List<Long> pegarIdsTodos(){
        return usuarioRepository.findAll().stream().map(UsuarioModel::getId)
        .collect(Collectors.toList());
    }

    @GetMapping("/missoes/margem-ids")
    public List<Long> pegarIdsMissoes(){
        return missoesRepository.findAll().stream().map(Missoes::getId)
        .collect(Collectors.toList());
    } 

@PutMapping("/usuarios/{idU}/missoes/{idM}/juncao")
public ResponseEntity <UsuarioModel> juncaoDinamica(@PathVariable Long idU,
@PathVariable Long idM){
   Optional<UsuarioModel> usuario = usuarioRepository.findById(idU);
   Optional <Missoes> missaoVeia = missoesRepository.findById(idM);
   if(usuario.isPresent() && missaoVeia.isPresent()){
    UsuarioModel userVeio = usuario.get();
    Missoes missaoVeiaMais = missaoVeia.get();
   userVeio.setMissoes(missaoVeiaMais);
   usuarioRepository.save(userVeio);
   return ResponseEntity.ok(userVeio);
   }else{
    return ResponseEntity.notFound().build();
   }
    }

//em obras
    @PostMapping("/{missaoId}")
    public UsuarioModel criarUsuarioMissao(
        @PathVariable Long missaoId,
        @RequestBody UsuarioModel usuario){
            
            Missoes missao = missoesRepository.findById(missaoId).orElse(null);
  
  usuario.setMissoes(missao);

  return usuarioRepository.save(usuario);
        }

        /* 
    @PutMapping("/usuarios/{idUser}/missoes/{idMissao}")
    public ResponseEntity atribuirMissao(@PathVariable Long idUser,
     @PathVariable Long idMissao
    ){
    Optional <UsuarioModel> usuarioVelho = usuarioRepository.findById(idUser);
    Optional <Missoes> missaoVelha = missoesRepository.findById(idMissao);
    if(missaoVelha.isPresent() && usuarioVelho.isPresent()){
        UsuarioModel usuario = usuarioVelho.get();
        Missoes missao = missaoVelha.get();

        usuario.setMissoes(missao);
        usuarioRepository.save(usuario);
        return ResponseEntity.ok(usuario);
    }else{
        return ResponseEntity.notFound().build();
    }
    }*/
   
}
