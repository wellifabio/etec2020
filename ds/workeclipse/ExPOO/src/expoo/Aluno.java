package expoo;

public class Aluno {
   String nome, disciplina;
   float nota;
   char sexo;
   
   public String avaliacao(){
       if(this.sexo == 'F' || this.sexo == 'f'){
            return "A aluna "+this.nome+" tirou "+this.nota+" em "+this.disciplina;
       }else{
           return "O aluno "+this.nome+" tirou "+this.nota+" em "+this.disciplina;
       }
   }
}
