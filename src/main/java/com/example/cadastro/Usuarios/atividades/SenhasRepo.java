package com.example.cadastro.Usuarios.atividades;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.cadastro.Usuarios.usuariosmodel.Admin;

public interface SenhasRepo extends JpaRepository<Admin, Long> {
    boolean existsByNomeAdmin(String nomeAdmin);
    Optional <Admin> findByNomeAdminAndSenha(String nomeAdmin, String senha);
}
