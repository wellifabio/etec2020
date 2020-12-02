#include <iostream>

/* Exercício1 */

int main(int argc, char** argv) {
	float peso;
	printf("Digite o Peso:");
	scanf("%f",&peso);
	if(peso > 50){
		float excesso = peso - 50;
		float multa = excesso * 4;
		printf("O peso é %f \n",peso);
		printf("O excesso é %f \n",excesso);
		printf("O multa é %f \n",multa);
	}
	return 0;
}
