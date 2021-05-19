#Exemplo de arquivo de entrada
#5
#50 20 13 80 14
entrada = open("entrada.txt","r")
quantidade = entrada.readline()
linha2 = entrada.readline()
vetor = linha2.split()

#Ordenação Decrescente
for i in range(int(quantidade)):
  for j in range(i - 1):
    if(vetor[i] > vetor[j]):
      #Algoritmo de troca
      aux = vetor[i]
      vetor[i] = vetor[j]
      vetor[j] = aux
#Mostra Ordenado
for n in range(int(quantidade)):
  print("Posicao "+str(n)+" = "+vetor[n])