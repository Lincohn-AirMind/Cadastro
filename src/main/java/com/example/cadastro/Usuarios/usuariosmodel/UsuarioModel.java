package com.example.cadastro;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

//vms transformar isso em uma tabela = entity(entidade) pro banco de dados
@Entity//transfrma classe em entidade do banco de daddos
// tem q baixar a dependdencia de banc de dados, spring jpa


@Table(name = "Cadastro_Usuario")
public class UsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //o generated cria um parametro par air incrementando entidades no banco de dados em forma d enumeros

   private Long id;
   private String nome; 
   private String email; 
     private int idade; 
      
    public UsuarioModel(String nome, String email, int idade) {
        this.nome = nome;
        this.email = email;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
  
    
}
