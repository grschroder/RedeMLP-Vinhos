
public class rascunho {
/* Retirado da main
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
	double y;
	double erro; 
	double erroGeral;
	double eta = 0.3d; 
	double entrada1=0;
	
	
	//System.out.println("--- TREINAMENTO");
	neuronioSaida.zeraV();
	
	
			
	neuronioSaida.setW(11, 1);
	neuronioSaida.setW(12, 2);
	neuronioSaida.setW(13, 2);
	neuronioSaida.setW(14, 3);
	neuronioSaida.setW(15, 1);
	neuronioSaida.setW(16, 2);
	neuronioSaida.setW(17, 0);
	neuronioSaida.setW(18, 1);
	neuronioSaida.setW(19, 2);
	neuronioSaida.setW(110, 3);
	neuronioSaida.setW(111, 2);
	
	neuronioSaida.setW(21, 0);
	neuronioSaida.setW(22, 1);
	neuronioSaida.setW(23, 0);
	neuronioSaida.setW(24, 2);
	neuronioSaida.setW(25, 3);
	neuronioSaida.setW(26, 1);
	neuronioSaida.setW(27, 1);
	neuronioSaida.setW(28, 2);
	neuronioSaida.setW(29, 2);
	neuronioSaida.setW(210, 0);
	neuronioSaida.setW(211, 1);
	
	neuronioSaida.setW(31, 0);
	neuronioSaida.setW(32, 1);
	neuronioSaida.setW(33, 1);
	neuronioSaida.setW(34, 2);
	neuronioSaida.setW(35, 1);
	neuronioSaida.setW(36, 1);
	neuronioSaida.setW(37, 2);
	neuronioSaida.setW(38, 1);
	neuronioSaida.setW(39, 1);
	neuronioSaida.setW(310, 0);
	neuronioSaida.setW(311, 2);
	
	
	// Entrada 1 //
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

	// Entrada 2 //
	/*
	neuronioSaida.setX(0, 1);
	neuronioSaida.setX(1, 0.490566038);
	neuronioSaida.setX(2, 0.556962025);
	neuronioSaida.setX(3, 0);		
	neuronioSaida.setX(4, 0.167741935);
	neuronioSaida.setX(5, 0.098);
	neuronioSaida.setX(6, 0.347222222);
	neuronioSaida.setX(7, 0.117647059);
	neuronioSaida.setX(8, 0.231833910);
	neuronioSaida.setX(9, 0.8);
	neuronioSaida.setX(10, 0.34);
	neuronioSaida.setX(11, 0.7);		
	neuronioSaida.setD(0.625);
	*/
	
	//URL teste = new URL ("https://raw.githubusercontent.com/grschroder/RedeMLP-Vinhos/master/RedeMLP-Vinhos/Docs/winequality-red.csv");
	//BufferedReader in = new BufferedReader(new InputStreamReader(teste.openStream()));

}
