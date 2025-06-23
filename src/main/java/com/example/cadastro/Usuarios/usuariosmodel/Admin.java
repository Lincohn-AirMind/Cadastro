package com.example.cadastro.Usuarios.usuariosmodel;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
 @AllArgsConstructor
 @Data
 @Getter
 @Setter
 @Entity
@RequestMapping("/admin")
public class Admin {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
   private Long id;
   @Column(unique = true)
    private String nomeAdmin;
    private String senha;
    private String modoNoturno="false";
    //entidades jpa não injetam dependencias,ou seja, não precisam do autowired
}
