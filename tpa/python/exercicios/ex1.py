peso = int(input("Digite o peso dos peixes"))
if peso > 50:
  excesso = peso - 50
  multa = excesso * 4
  print("O peso é "+str(peso))
  print("O excesso é "+str(excesso))
  print("A multa é "+str(multa))