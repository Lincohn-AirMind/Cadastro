package com.example.cadastro.Usuarios.usuariosmodel.controllerusuarios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cadastro.Usuarios.UsuariosRepository;
import com.example.cadastro.Usuarios.usuariosmodel.Missoes;
import com.example.cadastro.Usuarios.usuariosmodel.UsuarioModel;

@RestController
@RequestMapping

public class ContUserRepo {
    
    @Autowired
    private UsuariosRepository usuarioRepository;
@Autowired
private Missoes missoesRepository;


public void salvarUsuario(@RequestBody UsuarioModel usuario){
   //entender como buscar missoes existente
    // Cria um novo usuário
   

    usuarioRepository.save(usuario);
   // usuario.setusuarioRepository.findAll();
 // associa a missão
    // Salva no banco de dados  
}
@GetMapping
public List<UsuarioModel> listarUsuarios(){
    return usuarioRepository.findAll();
}
@DeleteMapping("/{id}")
public void deletarUsuario(@PathVariable Long id){
    usuarioRepository.deleteById(id);
}



}

