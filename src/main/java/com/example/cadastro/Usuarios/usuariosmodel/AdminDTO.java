package com.example.cadastro.Usuarios.usuariosmodel;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.validation.constraints.Size;


@NoArgsConstructor
 @AllArgsConstructor
 @Getter
 @Setter
 

public class AdminDTO {
    
   @NotBlank(message = "nome não pode ser vazio.")
    private String nomeAdmin;

    @NotBlank(message = "A senha não pode ser menor q 4 dígitos.")

   @Size(min = 4, message = "tem que te rno mínimo 4.")
    private String senha;
    private String modoNoturno="false";

}
