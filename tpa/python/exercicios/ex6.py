valor = int(input("Digite o valor do saque de 10 a 600 Reais: "))

notasCem = 0
while valor >= 100:
  valor = valor - 100
  notasCem = notasCem + 1

notasCinquenta = 0
while valor >= 50:
  valor = valor - 50
  notasCinquenta = notasCinquenta + 1

notasDez = 0
while valor >= 10:
  valor = valor - 10
  notasDez = notasDez + 1

notasCinco = 0
while valor >= 5:
  valor = valor - 5
  notasCinco = notasCinco + 1

notasUm = 0
while valor >= 1:
  valor = valor - 1
  notasUm = notasUm + 1

if notasCem != 0:
  print("{} notas de R$ 100,00".format(notasCem))
if notasCinquenta != 0:
  print("{} notas de R$ 50,00".format(notasCinquenta))
if notasDez != 0:
  print("{} notas de R$ 10,00".format(notasDez))
if notasCinco != 0:
  print("{} notas de R$ 5,00".format(notasCinco))
if notasUm != 0:
  print("{} notas de R$ 1,00".format(notasUm))
