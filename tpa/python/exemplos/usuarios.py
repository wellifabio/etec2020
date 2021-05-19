numFuncionarios = int(input('Quantos funcionáios você vai cadastrar? '))
arquivo = open('usuario.txt', 'w')

for i in range(0, numFuncionarios):
    nome = ''
    while (len(nome) == 0) or (len(nome) > 15):
        nome = input('Nome ') #recebe o nome do funcionario
        if len(nome) == 0:
            print('Escreva alguma coisa. ')
        elif len(nome) > 15:
            print('Escreva um nome de até 15 letras. ')
        else:
            arquivo.write(nome)  # grava o nome do funcionario no arquivo
            arquivo.write(' ')

    quantidade = input('Quantidade ') #recebe a quantidade de bytes que o funcionario utiliza
    arquivo.write(quantidade) #grava a quantidade de bytes que o funcionario utiliza no arquivo
    arquivo.write('\n')
arquivo.close()