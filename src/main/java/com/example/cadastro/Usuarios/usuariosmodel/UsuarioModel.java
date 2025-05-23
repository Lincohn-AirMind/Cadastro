package com.example.cadastro.Usuarios.usuariosmodel;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

//vms transformar isso em uma tabela = entity(entidade) pro banco de dados
@Entity//transfrma classe em entidade do banco de daddos
// tem q baixar a dependdencia de banc de dados, spring jpa


@Table(name = "Cadastro_Usuario")
@NoArgsConstructor // cria constructor invisiveis
@AllArgsConstructor// a mesma coisa do de cima porém com todos os atributos.
@Data
public class UsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //o generated cria um parametro par air incrementando entidades no banco de dados em forma d enumeros

   private Long id;
   private String nome; 
   private String email; 
     private int idade; 

     @ManyToOne// o atributo abaixo em relação à classe la de cima 1 missao para varios usuarios
     @JoinColumn(
        name = "missoes_id" //missoes_id é a chave estrangeira

     )
     //puxa as missoes para que esta classe altere e tenha missoes
     //no futuro
     private Missoes missoes;
    
}
