entrada = open('entrada.txt', 'r')
linha = entrada.readlines()
entrada.close() 
saida = open('saida.txt', 'w') 
for coluna in linha:
  coluna = coluna.split()
  nome = coluna[0]
  peso = float (coluna[1])
  altura = float(coluna[2])
  imc= peso / (altura * altura)
  if imc < 20:
    fisico = 'Fitness'
  elif imc < 28:
    fisico = 'Sarado'
  else:
    fisico = 'Fofinho'
  saida.write(nome + ' ' + fisico + '\n')
saida.close()