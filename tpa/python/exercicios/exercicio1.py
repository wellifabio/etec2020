entrada = open('entrada.txt', 'r')
linha = entrada.readlines()
entrada.close()
saida = open('saida.txt', 'w')
for coluna in linha:
  coluna = coluna.split()
  nome = coluna[0]
  idade = int(coluna[1])
  if idade < 13:
    fase = 'criança'  
  elif idade < 18:
    fase = 'jovem'
  elif idade < 40:
    fase = 'adulto'
  elif idade < 65:
    fase = 'meia idade'
  else:
    fase = 'idoso'
  saida.write(nome + ' | ' + fase + '\n')
saida.close()
