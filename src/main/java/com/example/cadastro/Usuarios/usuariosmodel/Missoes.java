package com.example.cadastro.Usuarios.usuariosmodel;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;


import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
 
@Entity
@Table(name = "tb_missoes")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Missoes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

private Long id;
private String nome;
private String dificuldade;


@OneToMany(mappedBy = "missoes")
private List<UsuarioModel> usuarios;
///mapeia o elemento missao da outra tabela


}





//é uma lista pq varios usuarios vao pegar a mesma missao
//quase all args cosntructor pq falta 



