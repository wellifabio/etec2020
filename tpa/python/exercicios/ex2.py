salarioHora = float(input("Digite o salário por hora:"))
horas = float(input("Digite quantas horas:"))
salarioBase = salarioHora * horas
inss = salarioBase * 8 / 100
irrf = salarioBase * 11 / 100
sindicato = salarioBase * 5 / 100
salarioLiquido = salarioBase - inss - irrf - sindicato
print("Salário Bruto : {}",format(salarioBase))
print("IRRF : {}".format(irrf))
print("INSS : {}".format(inss))
print("Sindicato : {}".format(sindicato))
print("Salário Líquido : {}".format(salarioLiquido))