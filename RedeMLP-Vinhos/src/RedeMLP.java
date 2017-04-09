
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
		
		//testebranch
		//treinamento
		int epocas = 0, i;
		double y, erro, erroGeral;
		double eta = 1d; 
		double entrada1=0;
		
		//System.out.println("--- TREINAMENTO");
		neuronioSaida.zeraV();
		
		neuronioSaida.setW(10, 1);
		neuronioSaida.setW(20, 1);
		neuronioSaida.setW(30, 1);
		neuronioSaida.setW(40, 1);
		
		neuronioSaida.setX(0, 1);
		neuronioSaida.setX(1, 0.465408805);
		neuronioSaida.setX(2, 0.443037975);
		neuronioSaida.setX(3, 0.122580645);		
		neuronioSaida.setX(4, 0.122580645);
		neuronioSaida.setX(5, 0.076000000);
		neuronioSaida.setX(6, 0.152777778);
		neuronioSaida.setX(7, 0.117647059);
		neuronioSaida.setX(8, 0.997800000);
		neuronioSaida.setX(9, 0.877500000);
		neuronioSaida.setX(10, 0.280000000);
		neuronioSaida.setX(11, 0.671428571);		
		neuronioSaida.setD(0.625);
		
		neuronioSaida.calculaVoculta(1);
		neuronioSaida.calculaVoculta(2);
		neuronioSaida.calculaVoculta(3);
		
		neuronioSaida.calculaY(1);
		neuronioSaida.calculaY(2);
		neuronioSaida.calculaY(3);
		
		
		System.out.println("--- V1 = "+neuronioSaida.getV(1));
		System.out.println("--- Y1 = "+neuronioSaida.getY(1));
		System.out.println("--- V2 = "+neuronioSaida.getV(2));
		System.out.println("--- Y2 = "+neuronioSaida.getY(2));
		System.out.println("--- V3 = "+neuronioSaida.getV(3));
		System.out.println("--- Y3 = "+neuronioSaida.getY(3));
		
		
		neuronioSaida.calculaVsaida(4);
		neuronioSaida.calculaY(4);
		
		System.out.println("--- V4 = "+neuronioSaida.getV(4));
		System.out.println("--- Y4 = "+neuronioSaida.getY(4));
		//neuronio.setW0(neuronio.getW0() + eta * erro);
		
		// calcula do erro
		//erro = d[i] - y;
		
		//while(true){
			erro = neuronioSaida.getD() - neuronioSaida.getY(4);
			
			if(erro != 0){
				System.out.println("---- Erro: "+ erro);
				neuronioSaida.calculaGSaida(4, erro);
				System.out.println("---- G4: "+ neuronioSaida.getG(4));
			
				neuronioSaida.calculaDelta(4, eta);
				neuronioSaida.ajusteDePesos(4);
				
				neuronioSaida.calculaDelta(1, eta);
				neuronioSaida.calculaDelta(2, eta);
				neuronioSaida.calculaDelta(3, eta);
				
				neuronioSaida.calculaGoculta(1);
				neuronioSaida.calculaGoculta(2);
				neuronioSaida.calculaGoculta(3);
				
				neuronioSaida.ajusteDePesos(1);
				neuronioSaida.ajusteDePesos(2);
				neuronioSaida.ajusteDePesos(3);
			}
			else if (erro == 0){
				System.out.println("	W10	: 	"	+	neuronioSaida.getW(10));
				System.out.println("	W11	: 	"	+	neuronioSaida.getW(	11	))	;
				System.out.println("	W12	: 	"	+	neuronioSaida.getW(	12	))	;
				System.out.println("	W13	: 	"	+	neuronioSaida.getW(	13	))	;
				System.out.println("	W14	: 	"	+	neuronioSaida.getW(	14	))	;
				System.out.println("	W15	: 	"	+	neuronioSaida.getW(	15	))	;
				System.out.println("	W16	: 	"	+	neuronioSaida.getW(	16	))	;
				System.out.println("	W17	: 	"	+	neuronioSaida.getW(	17	))	;
				System.out.println("	W18	: 	"	+	neuronioSaida.getW(	18	))	;
				System.out.println("	W19	: 	"	+	neuronioSaida.getW(	19	))	;

				
				
				//break;
			}
			
		
		//}
	}

}
