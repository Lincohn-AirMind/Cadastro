package com.example.cadastro.Usuarios.usuariosmodel.controllerusuarios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cadastro.Usuarios.UsuariosRepository;
import com.example.cadastro.Usuarios.atividades.MissoesRepo;
import com.example.cadastro.Usuarios.usuariosmodel.Missoes;
import com.example.cadastro.Usuarios.usuariosmodel.UsuarioModel;

@RestController
@RequestMapping("/usuarios")
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
    

}
