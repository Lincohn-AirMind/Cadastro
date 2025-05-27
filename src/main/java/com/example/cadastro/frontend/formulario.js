//ligar os dados do frontend com o backend através de mecanismos que repassem
//os dados do input para as requisições do spring.
document.getElementById("enviar").onclick = function(){
let email=document.getElementById("email").value;
let nome=document.getElementById("nome").value;
let idade=document.getElementById("idade").value;

fetch("http://localhost:8080/usuarios",{
    method:"POST",
    headers:{
        "Content-Type":"application/json"
    },
    body: JSON.stringify({
        nome:nome,
        email:email,
        idade:idade
    })
})
.then(response => {
if(response.ok){
    alert("Cadastro de usuario realizado!");
    document.getElementById("nome").value="";
    document.getElementById("idade").value="";
    document.getElementById("email").value="";
}else{
    alert("Errinho ao cadastrar");}})
}
document.getElementById("registros").onclick= function(){
   fetch("http://localhost:8080/usuarios")
   .then(response => response.json())
   .then(data =>{
    document.getElementById("retornoLista").innerText = JSON.stringify(data,null,2);
   })
   .catch(error =>{
    alert("Deu ruim");
    console.log(error);
})
}
document.getElementById("apag").onclick= function(){
    document.getElementById("retornoLista").innerText = "";
}
document.getElementById("buscarUser").onclick= function(){


    let id=document.getElementById("inserirId").value;
fetch(`http://localhost:8080/usuarios/${id}`)
   .then(response =>{
//falta criar um endpoint no backend para esse método GET ID específico

if(response.ok){
    alert("Usuario encotrado, deu bom");
    return response.json(); 
}else{
    alert("Usuario não encontrado");
}

//catch(error =>{
 // alert("Deu ruim, não achei. Tome o erro" + erro);}
}).then(data =>{
    document.getElementById("idUser").innerText = JSON.stringify(data, null , 2);
})
.catch(error =>{ alert("Deu ruim" + error);})
   
}
document.getElementById("apagUser").onclick = function(){
   let id= document.getElementById("inserirId").value ;
    fetch(`http://localhost:8080/usuarios/${id}`, {
        method:"DELETE"
    }).then(response => {
        if(response.ok){
            alert("Usuario deletado");
        }else alert("Usuario não deletado");
    }).catch(erro => {
        alert("Deu ruim ao deletar" + erro);
    }) //missoes
}
       document.getElementById("admitirMissao").onclick = function(){
         let duracao= document.getElementById("duracao").value;
       let nome= document.getElementById("criarMissao").value;
        fetch('http://localhost:8080/missoes',{
            method:"POST",
            headers:{
                "Content-Type":"application/json"
            },
            body:JSON.stringify({
                nome: nome,
                duracao: duracao
        })
    }).then(response => {
        if(response.ok){
            alert("Missão criada");
        }else{alert("Deu ruim no cadastro");}
    })
        }
       


