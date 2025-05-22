package com.example.cadastro.Usuarios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cadastro.Usuarios.usuariosmodel.UsuarioModel;

public interface UsuariosRepository extends JpaRepository<UsuarioModel, Long>{
    //aqui é onde está o banco de dados armazenando os usuarios.

    
}
