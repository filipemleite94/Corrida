import java.util.Scanner;
import java.io.Console;

/* Classe usando Thread que simula a corrida de um carro */
class carroCorrendoThread extends Thread {

	String nome;					// nome do carro
	int distanciaCorrida = 0;		// distância já corrida pelo carro
	int distanciaTotalCorrida;	// distância a ser corrida pelo carro
	int pulo = 0;					// pulo do carro em cm
	int pulos = 0;					// quantidades de pulos dados na corrida
	static int colocacao = 0;		// colocação do carro ao final da corrida
	final static int PULO_MAXIMO = 50; // pulo máximo em cm que um carro pode dar

	/** Construtor da classe. Parâmtros : Nome do carro e Distância da Corrida */
	public carroCorrendoThread (String nome, int distanciaTotalCorrida) {
		/* chamando o construtor de Thread passando o nome do carro como parâmetro */
		super(nome);
		this.distanciaTotalCorrida = distanciaTotalCorrida;
		this.nome = nome;
	}
	/** Imprime o último pulo do carro e a distância percorrida */
	public void carroImprimindoSituacao () {
		System.out.println("O " + nome +  " pulou " + pulo + "cm \t e já percorreu " +
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
		/* Método que passa vez a outras threads */
		yield();
	}
	/** Imprime a colocação do carro ao final da corrida */
	public void colocacaocarro () {
		colocacao++;
		System.out.println(nome + " foi o " + colocacao + 
							"º colocado com " + pulos + " pulos");
	}
	/** Método run da thread Corrida de carros */
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
