arquivo = open('usuario.txt', 'r')
#print (arquivo.read())
for linha in arquivo:
    print(linha) #lendo linha a linha
arquivo.close()