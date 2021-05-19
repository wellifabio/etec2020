import math
area = float(input("Digite a área em m2:"))
preferencia = int(input("Preferêcia 1-Galões ou 2-Latas:"))
if preferencia == 1:
  areaGalao = 3.6 * 6
  if area < areaGalao:
    print("Um galão de R$ 25.00")
  else:
    totalGaloes = math.ceil(area / areaGalao) #Arredonta para baixo
    print("Será necessário {} galoes".format(totalGaloes))
    custo = totalGaloes * 25
    print("O custo será de R${}".format(custo))
else:
  areaLata = 18 * 6
  if area < areaLata:
    print("Uma Lata de R$ 80.00")
  else:
    totalLatas = int(area / areaLata)+1
    print("Será necessário {} latas".format(totalLatas))
    custo = totalLatas * 80
    print("O custo será de R${}".format(custo))