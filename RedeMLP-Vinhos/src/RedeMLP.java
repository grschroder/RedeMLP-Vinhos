
public class RedeMLP {

	public static void main(String[] args) {
		// Normalizar as entradas para estarem entre 0 e 1.
		// entradas que devem ser normalizadas: fixed acidity, residual sugar, free sulfur dioxide, total sulfur dioxide, pH, sulphates, alcohol
		//densidade vem bugada no excel e no libreoffice
		// a saída do programa é a quality
		
		Neuronio neuronioSaida = new Neuronio();
		
		//fixed acidity
		double x1[] = new double[2];
		//volatile acidity
		double x2[] = new double[2];
		//citric acid
		double x3[] = new double[2];
		//residual sugar
		double x4[] = new double[2];
		//chlorides
		double x5[] = new double[2];
		//free sulfur dioxide
		double x6[] = new double[2];
		//total sulfur dioxide
		double x7[] = new double[2];
		//density
		double x8[] = new double[2];
		//pH
		double x9[] = new double[2];
		//sulphates
		double x10[] = new double[2];
		//alcohol
		double x11[] = new double[2];
		//quality
		double  d[] = new double[2];
		
		
		//treinamento
		int epocas = 0, i;
		double y, erro, erroGeral;
		double eta = 0.1d; 
		double entrada1=0;
		
		System.out.println("--- TREINAMENTO");
		y = neuronioSaida.calculaVoculta(1, 11, entrada1);
		
		
		
	}

}
