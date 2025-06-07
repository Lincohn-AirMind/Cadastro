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
    }).catch(erro => {alert("Deu ruim no cadastro" + erro)})}//em obras

    let idMissoes = document.getElementById("duracao").value;
    let idUser= document.getElementById("inserirId").value;
    const criarMissao=document.getElementById("criarMissao").value;
if(duracao !== "" && criarMissao == ""){
fetch(`http://localhost:8080/juncao/usuarios/${idUser}/missoes/${idMissoes}`,
{method : "PUT"
})
.then( response =>{if(response.ok){alert("cdastro atribuido")}else{alert("atribuicao não feita")}})
.catch(erro => alert("erro    " + erro))}

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
}
        }


       


