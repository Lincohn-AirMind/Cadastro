document.getElementById("enviar1").onclick= function(){
    fetch(`https://localhost:443/adm/logar`,{
        method:"POST",
        headers:{"Content-Type":"application/json"},
        body:JSON.stringify({
            nomeAdmin : document.getElementById("nome1").value,
            senha : document.getElementById("senha1").value
        })
    })
    .then(response =>{
        if(response.ok){
            console.log("conta presente.");
            DocumentTimeline.getElementById("nome1").value="";
            DocumentTimeline.getElementById("senha1").value="";
            document.getElementById("telaInicial").classList.add("none");
            document.getElementById("display").classList.remove("none");

            return response.json();
        }else{console.log("conta não presente.")
            return response.text();}
    })
    .catch(erro =>{
        console.log(erro);})
    }
    document.getElementById("ntemconta").onclick=function(){
document.getElementById("telaInicial").classList.add("none");
document.getElementById("telaCriarConta").classList.remove("none");               
    }
document.getElementById("submit2").onclick = function(){
    fetch(`https://localhost:443/adm`,
        {method:"POST",
            headers:{"Content-Type":"application/json"},
            body:JSON.stringify({
                nomeAdmin:document.getElementById("nome2").value,
                senha:document.getElementById("senha2").value,
                modoNoturno:"false"
            })
        }).then(response =>{
            if(response.ok){alert("conta criada");
                  document.getElementById("nome2").value="";
                    document.getElementById("senha2").value="";
            }else{
                return response.json().then(data =>{
                    alert(Object.values(data).join('\n') || "Erro ao criar conta.");
                    document.getElementById("nome2").value="";
                    document.getElementById("senha2").value="";
                })
            }
        }).catch(erro =>{
            console.log(erro);
        })}


