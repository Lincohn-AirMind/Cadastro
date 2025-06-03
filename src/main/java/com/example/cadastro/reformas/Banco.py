import pickle
arquivo = open("C:\\Users\\dener\\OneDrive\\Documentos\\Projeto.java\\reformar\\src\\banco.txt","r")

armario = arquivo.read()

a= armario.replace("\"","")
b=a.replace(" "," ")
c=b.replace(":","")
d=c.replace("[","")
f=d.replace("]","")
g=f.replace("(","")
doflamingo=g.replace(")","")
doflamig=doflamingo.replace("{","")
doflaming=doflamig.replace("}","")
rota=doflaming.replace(",","")
rota2=rota.replace(" ","\n")
arquivao =open("C:\\Users\\dener\\OneDrive\\Documentos\\Projeto.java\\cadastro\\src\\main\\java\\com\\example\\cadastro\\reformas\\bb.txt","r+")

xor = open("C:\\Users\\dener\\OneDrive\\Documentos\\Projeto.java\\cadastro\\src\\main\\java\\com\\example\\cadastro\\reformas\\bancao.txt", "r+")

barganha=arquivao.readlines()
linhas= xor.readlines()

a=2
s=4
d=6
i=8
zip=0
with open("C:\\Users\\dener\\OneDrive\\Documentos\\Projeto.java\\cadastro\\src\\main\\java\\com\\example\\cadastro\\reformas\\bb.txt", "r") as file:
    arquiv=file.read()
    corte=arquiv.split(" ")
    id=corte
    nome=corte
    email=corte
    idade=corte
    print(corte)
    while zip <8:
        iduser=id[a]
        print(iduser)
        nomeuser=nome[s]
        print(nomeuser)
        emailuser=email[d]
        print(emailuser)
        idadeuser=idade[i]
        print(idadeuser)
        a+=11
        d+=11
        s+=11
        i+=11

        zip+=1
        with open("C:\\Users\\dener\\OneDrive\\Documentos\\Projeto.java\\cadastro\\src\\main\\resources\\data.sql", "a+") as bancao:
            bancao.write(str(f" ({iduser},'{nomeuser}','{emailuser}',{idadeuser},1), \n" ))
        
    

