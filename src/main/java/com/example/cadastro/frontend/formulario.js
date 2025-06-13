//ligar os dados do frontend com o backend através de mecanismos que repassem
//os dados do input para as requisições do spring.
document.getElementById("enviar").onclick = function(){
const email=document.getElementById("email");
const nome=document.getElementById("nome");
const idade=document.getElementById("idade");

//em obras
const barraId=document.getElementById("inserirId");
const id=document.getElementById("inserirId").value;
const idMissoes = document.getElementById("duracao");
if(barraId.value !== "" && nome.value !== "" && email.value !== "" && idade.value !==""){
    fetch(`http://localhost:8080/usuarios/${id}`,
        {method:"PUT",
            headers:{"Content-Type":"application/json"},
            body:JSON.stringify({
                id:barraId.value,
                nome:nome.value,
                email:email.value,
                idade:idade.value
            })}
       ).then(response => {if(response.ok){alert("Usuario atualizado")}
       else{
alert("Deu ruim");

       }}) }
    //em obras
if(nome.value !== "" && email.value !=="" && idade.value !== "" && barraId.value === ""){
fetch("http://localhost:8080/usuarios",{
    method:"POST",
    headers:{
        "Content-Type":"application/json"
    },
    body: JSON.stringify({
        nome:nome.value,
        email:email.value,
        idade:idade.value
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
}
document.getElementById("registros").onclick = function(){
    fetch(`http://localhost:8080/usuarios`)
    .then(response => response.json())
    .then( data => {
        const campo=document.getElementById("retornoLista");
        campo.innerHTML="";
        
        data.forEach(user =>{
const campinho=document.createElement("div");
campinho.id="campinho";
campinho.innerHTML=`
<br>
<strong>Id:</strong> ${user.id}<br>
<strong>Nome</strong> ${user.nome}<br>
<strong>Email</strong> ${user.email}<br>
<strong>Idade</strong> ${user.idade}<br>
<strong>Missao</strong> ${user.missoes ? user.missoes.nome : "Nenhuma"}`;
campo.appendChild(campinho);
        })
    }
    ).catch(erro => {alert("Deu pau" + erro)});
        
}
document.getElementById("apag").onclick= function(){
    document.getElementById("retornoLista").innerText = "";
    document.getElementById("idUser").innerHTML = "";
}
document.getElementById("buscarUser").onclick= function(){
    let id=document.getElementById("inserirId").value;
    const valorId=document.getElementById("idUser");
fetch(`http://localhost:8080/usuarios/${id}`)
   .then(response =>{
if(response.ok){
    alert("Usuario encotrado, deu bom");
    return response.json(); 
}else{
    alert("Usuario não encontrado")
}
}).then(usuario =>{

valorId.innerHTML=`
<strong>ID</strong> : ${usuario.id} <br>
<strong>Nome</strong> : ${usuario.nome} <br>
<strong>Email</strong> : ${usuario.email} <br>
<strong>Idade</strong> : ${usuario.idade} <br>
<strong>Missao</strong> : ${usuario.missoes ? usuario.missoes.nome : "Nenhuma"} `;
})
.catch(error =>{ alert("Deu ruim" + error);})
}
document.getElementById("apagUser").onclick = function(){
   let id= document.getElementById("inserirId").value ;
   let array = id.split(";");
   array.forEach(item => {
    fetch(`http://localhost:8080/usuarios/${item}`,{
        method : "DELETE"
    }).then( response => {if(response.ok){
        alert("usuario deletado");
    }else{alert("erro ao deletar");}})

   })
}
       document.getElementById("admitirMissao").onclick = function(){
         let duracao= document.getElementById("duracao").value;
       let nome= document.getElementById("criarMissao").value;
       if(nome !== "" && duracao !== ""){ fetch('http://localhost:8080/missoes',{
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
    }).catch(erro => {alert("Deu ruim no cadastro" + erro)})}
    
    //em obras, put dinãmico
/*
    let idMissoes = document.getElementById("duracao").value;
    let idUser= document.getElementById("inserirId").value;
    const criarMissao=document.getElementById("criarMissao").value;
if(duracao !== "" && criarMissao == ""){
fetch(`http://localhost:8080/juncao/usuarios/${idUser}/missoes/${idMissoes}`,
{method : "PUT"
})
.then( response =>{if(response.ok){alert("cdastro atribuido")}else{alert("atribuicao não feita")}})
.catch(erro => alert("erro    " + erro))}
*/
}//em obras
        
        document.getElementById("findMissao").onclick = function(){
        idMissao= document.getElementById("duracao").value;
        mostrarMissao=document.getElementById("mostrarMissao");
        fetch(`http://localhost:8080/missoes/${idMissao}`)
        .then(response => {
            if(response.status===404){
                alert("missao inexistente")
                throw new error("Deu muito ruim");
            }if(response.ok){
                return response.json();
            }else{ 
                alert("Deu ruim")
            };
        })
        .then(data => { mostrarMissao.innerText=JSON.stringify(data,null,2)
        })
    .catch(erro => {alert("Deu ruim =>" + erro)});
    if(document.getElementById("duracao").value===""){
    fetch(`http://localhost:8080/missoes`)
    .then( response => response.json())
    .then( data => { document.getElementById("mostrarMissao").innerText=JSON.stringify(data,null,2)})
    .catch(erro => {
        alert("houve um errinho nos registros" + erro);
    })    
}
//delete em obras
//sistema de delete multiplo por ;
document.getElementById("deletar").onclick = function(){
valor=document.getElementById("criarMissao").value;

array=valor.split(";");
array.forEach(item =>{

fetch(`http://localhost:8080/missoes/${item}`,{
method:"DELETE"})
.then(response =>{
    if(response.ok){
        document.getElementById("mostrarMissao").innerText="usuario deletado";
    }else{alert("Erro ao deletar")}}
 )
.catch(erro =>{
    alert("Deu ruim ao deletar fiote " + erro)
})
})
}}

//junção dinamica
let rodar=false;
document.getElementById("stop").onclick = function(){
    console.log(rodar);
    rodar=false;
console.log(rodar);}

    document.getElementById("juncao").onclick = function(){
        rodar=true;
    loopJuncao();}
    
    function loopJuncao(){
        if(!rodar) return;
fetch(`http://localhost:8080/juncao/usuarios/lista-ids`)
.then(response => {
    if(response.ok){console.log("deu bom os ids");
         return response.json();
    }else{alert("deu ruim");
        }
}).then(ids => {

arrayUsers=ids;
   console.log(arrayUsers);
let execucoes=0;

    fetch(`http://localhost:8080/juncao/missoes/margem-ids`)
    .then(response => {
        if(response.ok){
            console.log("missoes deu certo");
        return response.json();}else{alert("missoes deu errado");}
    })
    .then(data => {
     arrayMissoes= data;
    t= Math.floor(Math.random() * arrayUsers.length);
  
document.getElementById("brega").classList.replace("none","bonito");    
document.getElementById("brega").innerHTML="";

arrayUsers.forEach( idU => {
     s= Math.floor(Math.random() * arrayMissoes.length);
let idM= arrayMissoes[s];

let maccher=idM;
 fetch(`http://localhost:8080/juncao/missoes/duracao/${maccher}`,{
        method:"GET"
    }) 
    .then(responder => responder.json())
    .then( dataia => { 

 
          setTimeout(() => { fetch(`http://localhost:8080/juncao/usuarios/${idU}/missoes/${idM}/juncao`,{
                method:"PUT",
                headers:{
                    "Content-Type":"application/json"}
    }).then(response => {if(response.ok){
        response.json().then(usuarAtua =>{
execucoes++;

        console.log("o processo dinamico deu certo");
        console.log("user " + idU);
        console.log("missao " + idM);
       let paragJuncao= document.createElement("div");
       paragJuncao.id="brega1";

if(rodar && execucoes == arrayUsers.length) loopJuncao(); 

paragJuncao.innerHTML=`
<strong>Id</strong> : ${usuarAtua .id}<br>
<strong>Nome</strong> : ${usuarAtua .nome}<br>
<strong>Email</strong> : ${usuarAtua .email}<br>
<strong>Idade</strong> : ${usuarAtua.idade} <br>
<strong>Missao</strong> : ${usuarAtua.missoes ? usuarAtua.missoes.nome:"Nenhuma"} <br>
`; document.getElementById("brega").appendChild(paragJuncao);
})
    }else{alert("deu bem ruim");}
});   }, dataia * 1000   ); /* -> esses dois sao caguetas do dataia*/})

    })}).catch(erro => {alert("erro " + erro )}) });

}
document.getElementById("teste").addEventListener("click", () =>{
    const brega=document.getElementById("brega");
    const posicoes=window.getComputedStyle(brega);
    console.log(posicoes.width);
    console.log(posicoes.height);
})
document.getElementById("menu").addEventListener("click",()=>{
    document.getElementById("abaMenu").classList.remove("none");

 document.getElementById("abaMenu").addEventListener("mouseleave",()=>{
    
    document.getElementById("abaMenu").classList.add("none");
    
})


   
})


       


