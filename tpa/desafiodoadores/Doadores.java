/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doadores;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author wellington.martins
 * Exercício Exemplo visto em https://www.youtube.com/watch?v=_VuTZj6tcoY&feature=youtu.be 16/10/2018
 * Problema da Doação de Sangue Fonte: Gabriela Rocha/Blog da Saúde publicado em 16/06/2015
 * A descrição complera do problema está no arquivo Descricao.jpg anexo ao projeto
 * 
 */
public class Doadores {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        try{
            Scanner in; //Declara a variável in para ler dados de Arquivo ou Teclado
            in = new Scanner(new FileReader(new File("doadores.in"))); //Define a leitura a partir do arquivo
            FileWriter fw; //Declara a variavel fw para Escrever em um arquivo
            fw = new FileWriter(new File("doadores.out")); //Atribui o arquivo de saída
            while(in.hasNext()){ //Repete enquanto existirem linhas para ler no arquivo
                String genero = in.next(); //Lê a primeira coluna e armazena os dados em gênero
                if(genero.equals("S")) break; //Se for igual a S indica o fim do arquivo
                int dias = in.nextInt(); //Lê a segunda coluna e armazena os dados em dias tipo inteiro
                System.out.print(genero+" "+dias+" "); //Exibe o que foi lido na tela, para conferir
                //OBS: utiliza espaço como separador
                
                //Lógica solicitada no exercício
                //Exibe o resultado na tela e armazena no arquivo de saída através do método append()
                if(genero.equals("F")){
                    if(dias>=90) {System.out.println("A"); fw.append("A\n");}
                    else {System.out.println("N");fw.append("N\n");}
                }else{
                    if(dias>=60) {System.out.println("A"); fw.append("A\n");}
                    else {System.out.println("N"); fw.append("N\n");}
                }
            }
            //Fecha o arquivo aberto para gravação fw
            fw.close();
        } catch(FileNotFoundException e){
            System.out.println("Erro ao ler arquivo, Arquivo não encontrado");
        }
    }
    
}
