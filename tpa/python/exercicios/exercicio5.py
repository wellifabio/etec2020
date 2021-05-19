entrada = open("entrada.txt","r")
linhas = [] 
for linha in entrada:
  coluna = linha.split()
  coluna[1] = str(int(coluna[1])+1)
  linhas.append(coluna[0]+" "+coluna[1]+"\n")
entrada.close()
saida = open("entrada.txt","w")
for linha in linhas:
  saida.write(linha)
saida.close()