
public class RedeMLP {

	public static void main(String[] args) {
		// Normalizar as entradas para estarem entre 0 e 1.
		// entradas que devem ser normalizadas: fixed acidity, residual sugar, free sulfur dioxide, total sulfur dioxide, pH, sulphates, alcohol
		//densidade vem bugada no excel e no libreoffice
		// a saída do programa é a quality
		
		//na propagação, o v saí do neuronio, a partir dele é calculado o y através da função de ativação Q
		
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
		
		//System.out.println("--- TREINAMENTO");
		neuronioSaida.zeraV();
		
		neuronioSaida.setW(11, 1);
		
		y = neuronioSaida.calculaVoculta(1, 11, 0.465408805);
		y = neuronioSaida.calculaVoculta(1, 12, 0.443037975);
		y = neuronioSaida.calculaVoculta(1, 13, 0.122580645);
		
		y = neuronioSaida.calculaVoculta(2, 21, 0.465408805);
		y = neuronioSaida.calculaVoculta(2, 22, 0.443037975);
		y = neuronioSaida.calculaVoculta(2, 23, 0.122580645);
		
		System.out.println("--- V1 = "+neuronioSaida.getVoculta(1));
		System.out.println("--- V2 = "+neuronioSaida.getVoculta(2));
				
		
		//neuronio.setW0(neuronio.getW0() + eta * erro);
		
		
	}

}
