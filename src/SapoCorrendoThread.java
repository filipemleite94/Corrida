import java.util.Scanner;
import java.io.Console;

/* Classe usando Thread que simula a corrida de um carro */
class carroCorrendoThread extends Thread {

	String nome;					// nome do carro
	int distanciaCorrida = 0;		// dist�ncia j� corrida pelo carro
	int distanciaTotalCorrida;	// dist�ncia a ser corrida pelo carro
	int pulo = 0;					// pulo do carro em cm
	int pulos = 0;					// quantidades de pulos dados na corrida
	static int colocacao = 0;		// coloca��o do carro ao final da corrida
	final static int PULO_MAXIMO = 50; // pulo m�ximo em cm que um carro pode dar

	/** Construtor da classe. Par�mtros : Nome do carro e Dist�ncia da Corrida */
	public carroCorrendoThread (String nome, int distanciaTotalCorrida) {
		/* chamando o construtor de Thread passando o nome do carro como par�metro */
		super(nome);
		this.distanciaTotalCorrida = distanciaTotalCorrida;
		this.nome = nome;
	}
	/** Imprime o �ltimo pulo do carro e a dist�ncia percorrida */
	public void carroImprimindoSituacao () {
		System.out.println("O " + nome +  " pulou " + pulo + "cm \t e j� percorreu " +
							distanciaCorrida + "cm");
	}
	/** Faz o carro pular */
	public void carroPulando() {
		pulos++;
		pulo = (int) (PULO_MAXIMO/10);
		distanciaCorrida += pulo;
		if (distanciaCorrida > distanciaTotalCorrida) {
			distanciaCorrida = distanciaTotalCorrida;
		}
	}
	/** Representando o descanso do carro */
	public void carroDescansando () {
		/* M�todo que passa vez a outras threads */
		yield();
	}
	/** Imprime a coloca��o do carro ao final da corrida */
	public void colocacaocarro () {
		colocacao++;
		System.out.println(nome + " foi o " + colocacao + 
							"� colocado com " + pulos + " pulos");
	}
	/** M�todo run da thread Corrida de carros */
	public void run () {
		Scanner t = new Scanner(System.in);
		int c = ((int)nome.charAt(5)-(int)'0')*3;
		while (distanciaCorrida < distanciaTotalCorrida) {
			if(c == t.nextInt()) carroPulando();
			carroImprimindoSituacao();
			carroDescansando();
		}
		colocacaocarro();
		t.close();
	}
}
