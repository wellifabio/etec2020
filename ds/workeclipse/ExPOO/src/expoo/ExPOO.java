package expoo;

import java.util.Scanner;

public class ExPOO {

    public static void main(String[] args) {
        
        Scanner leia = new Scanner(System.in);
        Aluno[] aluno = new Aluno[5];
        System.out.println("Nome, disciplina, nota, sexo:");
        for(int i = 0; i < 5; i++){
            aluno[i] = new Aluno();
            aluno[i].nome = leia.next();
            aluno[i].disciplina = leia.next();
            aluno[i].nota = leia.nextFloat();
            aluno[i].sexo = leia.next().charAt(0);
        }
        for(Aluno a: aluno){
            System.out.println(a.avaliacao());
        }
        
    }
    
}
