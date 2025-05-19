package com.example.cadastro.Usuarios.atividades;

import java.util.List;

import com.example.cadastro.Usuarios.usuariosmodel.UsuarioModel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Atividades {
    
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String duracao;
    private List<UsuarioModel>  usuario;

    
    public Atividades(int id, String nome, String duracao) {
        this.id = id;
        this.nome = nome;
        this.duracao = duracao;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getDuracao() {
        return duracao;
    }
    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }


}
