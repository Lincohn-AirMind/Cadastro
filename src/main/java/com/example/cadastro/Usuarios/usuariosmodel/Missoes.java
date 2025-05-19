package com.example.cadastro.Usuarios.usuariosmodel;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_missoes")
public class Missoes {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

private Long id;
private String nome;
private String dificuldade;

@OneToMany(mappedBy = "missoes")//mapeia o elemento missao da outra tabela



private List<UsuarioModel> usuario;
//é uma lista pq varios usuarios vao pegar a mesma missao

public Missoes(Long id, String nome, String dificuldade) {
    this.id = id;
    this.nome = nome;
    this.dificuldade = dificuldade;
}
public Long getId() {
    return id;
}
public void setId(Long id) {
    this.id = id;
}
public String getNome() {
    return nome;
}
public void setNome(String nome) {
    this.nome = nome;
}
public String getDificuldade() {
    return dificuldade;
}
public void setDificuldade(String dificuldade) {
    this.dificuldade = dificuldade;
}

}
