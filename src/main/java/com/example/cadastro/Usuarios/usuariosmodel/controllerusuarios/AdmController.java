package com.example.cadastro.Usuarios.usuariosmodel.controllerusuarios;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cadastro.Usuarios.atividades.SenhasRepo;
import com.example.cadastro.Usuarios.usuariosmodel.Admin;
import com.example.cadastro.Usuarios.usuariosmodel.AdminDTO;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/adm")
public class AdmController {
    @Autowired
    private SenhasRepo admRepository;

    //post, put, get e delete
@PostMapping
    public ResponseEntity<?> salvarAdm(@Valid @RequestBody AdminDTO corpo){
 
if(admRepository.existsByNomeAdmin(corpo.getNomeAdmin())){
    return ResponseEntity.status(400)
    .body(Map.of("NomeAdmin", "Nome de usuário já existe!!!!"));
}else{

Admin admin= new Admin();
admin.setNomeAdmin(corpo.getNomeAdmin());
admin.setSenha(corpo.getSenha());
admin.setModoNoturno(corpo.getModoNoturno());
admRepository.save(admin);
return ResponseEntity.ok(admin);
    }}

    @PostMapping("/logar")
public ResponseEntity <?> verificarLogin(@RequestBody AdminDTO corpo){
Optional <Admin> usuario = admRepository.findByNomeAdminAndSenha(corpo.getNomeAdmin(), corpo.getSenha());
if(usuario.isPresent()){
    return ResponseEntity.ok(usuario.get());
}else{
    return ResponseEntity.status(401).body(Map.of("erro", "cadastro não encontrado"));

}
}

    @GetMapping
    public ResponseEntity <List<Admin>>pegarAdm(){
       return ResponseEntity.ok(admRepository.findAll());
        
    }

    @PutMapping("/admin/{id}")
    public ResponseEntity<Admin>  atualizarAdmin( @PathVariable Long id,@Valid @RequestBody AdminDTO corpo) {
        
         Optional<Admin> adm= admRepository.findById(id);

if(adm.isPresent()){
    Admin admin= adm.get();

    admin.setNomeAdmin(corpo.getNomeAdmin());
    admin.setSenha(corpo.getSenha());
    admin.setModoNoturno(corpo.getModoNoturno());
    admRepository.save(admin);
    return ResponseEntity.ok(admin);
}else{
    return ResponseEntity.notFound().build();
}}

@DeleteMapping("/deleteAdm/{idDelete}")
public ResponseEntity<String>  deletarAdm( @PathVariable Long idDelete){
if(admRepository.findById(idDelete).isPresent()){
    admRepository.deleteById(idDelete);
    return ResponseEntity.ok("Deletado");}else{
    return ResponseEntity.notFound().build();}

}

    
    }

