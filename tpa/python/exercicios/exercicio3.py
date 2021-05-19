entrada = open('entrada.txt', 'r')
linha = entrada.readlines()
entrada.close()
saida = open('saida.txt', 'w')
for coluna in linha:
    coluna = coluna.split()
    ladoA = int(coluna[0])
    ladoB = int(coluna[1])
    ladoC = int(coluna[2])

    if ladoA != ladoB and ladoA != ladoC and ladoB != ladoC:
        tipo = "Escaleno"
    elif ladoA == ladoB  == ladoC:
        tipo = "Equilatero"
    else:
        tipo = "Isosceles"

    saida.write(tipo + '\n')
saida.close()