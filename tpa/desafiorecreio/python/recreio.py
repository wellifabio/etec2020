#https://repl.it/languages/python3
entrada = open("entrada.txt", "r")
saida = open("saida.txt", "w")
n_turmas = int(entrada.readline())#lê a primeira linha, total de turmas
for linhas in range(n_turmas):
  n_alunos = int(entrada.readline())
  notas = entrada.readline()#Le a próxima linha com as notas
  chegada = notas.split()#Coloca as notas em cada aluno
  aluno = [] #Vetor que será reorganizado
  for ordem in chegada:
    aluno.append(ordem)
  print("Total de alunos = "+str(n_alunos))
  print("Chegada Aluno N")
  #Ordenar a lista em ordem decrescente de nota
  for i in range(n_alunos - 1):
    for j in range(i + 1,n_alunos):
      if(int(aluno[i]) < int(aluno[j])):
        aux = aluno[i]
        aluno[i] = aluno[j]
        aluno[j] = aux
  #Imprimir na tela a lista de chegada e ordenada
  for i in range(n_alunos):
    print(str(chegada[i])+" "+str(aluno[i])+" "+str(i+1))
  #Gravar no arquivo de saída o total de alunos que não trocaram
  naoTrocaram = 0;
  for i in range(n_alunos):
    if(chegada[i] == aluno[i]):
      naoTrocaram = naoTrocaram +1
  saida.write(str(naoTrocaram)+"\n")
#Fecha os dois arquivos
entrada.close()
saida.close()