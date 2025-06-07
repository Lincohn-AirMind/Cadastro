package com.example.cadastro.Usuarios.usuariosmodel.controllerusuarios;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @PostMapping("/{missaoId}")
    public UsuarioModel criarUsuarioMissao(
        @PathVariable Long missaoId,
        @RequestBody UsuarioModel usuario){
            
            Missoes missao = missoesRepository.findById(missaoId).orElse(null);
  
  usuario.setMissoes(missao);

  return usuarioRepository.save(usuario);
        }
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
    }

}
