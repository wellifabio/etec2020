entrada = open("entrada.txt", "r")
saida = open("saida.txt","w")
for linha in entrada:
  colunas = linha.split()
  par = 0
  impar = 0
  for i in colunas:
    if(int(i) % 2 == 0):
      par = par + 1
    else:
      impar = impar + 1
  if(par > 0 and impar > 0):
    saida.write(str(impar)+" impar "+str(par)+" par \n")
  elif(par == 0):
    saida.write(str(impar)+" impar \n")
  else:
    saida.write(str(par)+" par \n")
saida.close()
entrada.close()