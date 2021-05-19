#Gerador de nomes e Números Aleatórios
import random
arquivo = open("nomes.txt","w")
nomes = ["Ana","Bruna","Silvia","Maria","Carla","Alexandro", "Marcos", "Sergio"]
for i in range(1,50):
  nome = random.choice(nomes)
  espaco = random.randrange(100,10000000)
  arquivo.write(nome+"\t\t"+str(espaco)+"\n")
arquivo.close()
