#Definindo as variáveis de conclusão do Relatório
espacoTotal = 0;
espacoMedio = 0;
arqEntrada = open('entrada.txt', 'r') #Abrindo o arquivo de entrada
for linha in arqEntrada: #Percorrendo linha a lina
    colunas = linha.split() #Separando as colunas em um array [colunas] pelo espaço
    espacoTotal = espacoTotal + int(colunas[1])
    espacoMedio = espacoMedio + 1
espacoMedio = float(int(espacoTotal / espacoMedio) / (1024*1024)) #Calculando a média
espacoTotal = espacoTotal / (1024*1024) #Calculando o espaço total em MB
arqEntrada.close() #Fechando o arquivo de entrada

arqEntrada = open('entrada.txt', 'r') #Abrindo novamente o arquivo de entrada
arqSaida = open('relatório.txt', 'w', encoding="utf8") #Abrindo o arquivo de saida para gravação
arqSaida.write("ACME Inc.               Uso do espaço em disco pelos usuários \n")
arqSaida.write("------------------------------------------------------------------------\n")
arqSaida.write("Nr.  Usuário        Espaço utilizado     % do uso\n\n")
nro = 0
for linha in arqEntrada:
    nro =  nro + 1
    arqSaida.write(str(nro)+"    ") #Escreve o número e acrescenta espaços
    colunas = linha.split() #Novamente divide as colunas pelos espaços
    arqSaida.write(colunas[0]) #Escreve o nome
    megaByte = int(colunas[1])/(1024*1024)
    arqSaida.write(" %.2f" % megaByte)
    arqSaida.write(" MB ")
    porcentagem = float(megaByte/espacoTotal*100)
    arqSaida.write(" %.2f" % porcentagem)
    arqSaida.write("% \n")
arqEntrada.close()
arqSaida.write("\nEspaço total ocupado: %.2f MB\n" % espacoTotal)
arqSaida.write("Espaço médio ocupado: %.2f MB\n" % espacoMedio)
arqSaida.close()
print("Relatório gerado com sucesso!");