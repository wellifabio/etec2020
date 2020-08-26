package model;

public class Nota {

	private String aluno;
	private float nota1, nota2, nota3;
	
	public String getAluno() {
		return aluno;
	}
	public void setAluno(String aluno) {
		this.aluno = aluno;
	}
	public float getNota1() {
		return nota1;
	}
	public void setNota1(float nota1) {
		this.nota1 = nota1;
	}
	public float getNota2() {
		return nota2;
	}
	public void setNota2(float nota2) {
		this.nota2 = nota2;
	}
	public float getNota3() {
		return nota3;
	}
	public void setNota3(float nota3) {
		this.nota3 = nota3;
	}
	
	public String toTXT() {
		return aluno + " media " + (int)((nota1+nota2+nota3)/3) +"\r\n";
	}
	
}
