<?php
	//Abrindo o arquivo de entrada
	if ($ponteiro = fopen("entrada.txt", "r")){
		//Percorrendo e mostrando o conteúdo na tela
		while(!feof($ponteiro)){
			$linha = fgets($ponteiro);
			echo $linha."<br/>";
		}
		fclose($ponteiro);
		//Abrindo novamente o arquivo de leitura e também o de gravação
		$entrada = fopen("entrada.txt", "r");
		$saida = fopen("saida.txt", "w");
		$nTurmas = intval(fgets($entrada));
		echo "Total de Turmas = ".$nTurmas."<br/>";
		for($x = 0; $x < $nTurmas; $x++){
			$nAlunos = intval(fgets($entrada));
			$arrayChegada = explode(" ",fgets($entrada));
			$arrayReordem = $arrayChegada;
			echo "Total de alunos = ".$nAlunos."<br/>";
			echo "Chegada Aluno N<br/>";
			//Ordenardenar a lista em ordem decrescente de nota
			for($i = 0; $i < $nAlunos - 1; $i++){
				for($j = $i + 1; $j < $nAlunos; $j++){
					if(intval($arrayReordem[$i]) < intval($arrayReordem[$j])){
						$aux = $arrayReordem[$i];
						$arrayReordem[$i] = $arrayReordem[$j];
						$arrayReordem[$j] = $aux;
					}
				}
			}
			//Imprimir na tela a lista de chegada e ordenada
			for($i = 0; $i < $nAlunos; $i++)
				echo "".$arrayChegada[$i]." ".$arrayReordem[$i]." ".$i."<br/>";
			//Gravar no arquivo de saída o total de alunos que não trocaram
			$naoTrocaram = 0;
			for($i = 0; $i < $nAlunos; $i++)
				if(intval($arrayChegada[$i]) == intval($arrayReordem[$i]))
					$naoTrocaram++;
			fwrite($saida, $naoTrocaram."\n");
		}
		//Fecha os dois arquivos
		fclose($saida);
		fclose($entrada);
	} else {
		echo "Erro ao abrir arquivo de leitura";
	}
?>