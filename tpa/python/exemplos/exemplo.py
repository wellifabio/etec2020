#Le um arquivo de entrada linha a linha e grava em um arquivo de saída linha + 10%
entrada = open("entrada.txt","r")
saida = open("saida.txt","w")

for linha in entrada:
  dado = int(linha)
  dado = dado + (dado * 10 / 100)
  saida.write(str(dado)+"\n")

entrada.close()
saida.close()
print("fim")