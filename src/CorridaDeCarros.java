/* Aplicação que simula uma corrida de sapos usando threads */
public class CorridaDeCarros {
	final static int NUM_CARROS = 2;	// QTE. de sapos na corrida
	final static int DISTANCIA = 500; // Distância da corrida em cm
	public static void main (String[] args) {
		/* colocando sapos na corrida */
		for (int i = 1; i <= NUM_CARROS; i++) {
			new SapoCorrendoThread("CARRO_" + i, DISTANCIA).start();
		}
	}
}
