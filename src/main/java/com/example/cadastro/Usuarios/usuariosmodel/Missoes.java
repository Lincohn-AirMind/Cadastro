package com.example.cadastro.Usuarios.usuariosmodel;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
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
@Table(name = "mission")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Missoes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

private Long id;
private String nome;
//private int duracao;//dificuldade

@Column(nullable = false)
private Integer duracao;

@OneToMany(mappedBy = "missoes")
@JsonIgnore
private List<UsuarioModel> usuarios;
///mapeia o elemento missao da outra tabela
}


//é uma lista pq varios usuarios vao pegar a mesma missao
//quase all args cosntructor pq falta 