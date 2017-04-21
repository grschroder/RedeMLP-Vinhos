import java.io.*;
import java.net.*;
import java.util.ArrayList;


public class RedeMLP {

	public static void main(String[] args) {
		
		Vinhos csv = new Vinhos();
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
		double y;
		double erro; 
		double erroGeral;
		double eta = 0.3d; 
		double entrada1=0;
		
		
		//System.out.println("--- TREINAMENTO");
		neuronioSaida.zeraV();
		
		// Pesos das entradas padroes //
		neuronioSaida.setW(10, 1);
		neuronioSaida.setW(20, 1);
		neuronioSaida.setW(30, 1);
		neuronioSaida.setW(40, 1);
		// -- //
				
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
		
		int repeat = 0;
		//csv.importCSV();
		
		
    	String csvFile = "E:/GitHubRepository/RedeMLP-Vinhos/Docs/winequality-red.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ";";
        Vinhos vinho = new Vinhos();
        

        try {

            br = new BufferedReader(new FileReader(csvFile));
            ArrayList lista = new ArrayList();
            int quantos=0;
            while ((line = br.readLine()) != null) {
            	String[] linha = line.split(cvsSplitBy);            	
            	vinho.setFixedAcidity(Double.parseDouble(linha[0])/15.9);
            	vinho.setVolatileAcidity(Double.parseDouble(linha[1])/1.58);
            	vinho.setCitricAcid(Double.parseDouble(linha[2]));
            	vinho.setResidualSugar(Double.parseDouble(linha[3])/15.5);
            	vinho.setChlorides(Double.parseDouble(linha[4]));
            	vinho.setFreeSulfurDioxide(Double.parseDouble(linha[5])/72);
            	vinho.setTotalSulfurDioxide(Double.parseDouble(linha[6])/289);
            	vinho.setDensity(Double.parseDouble(linha[7]));
            	vinho.setPh(Double.parseDouble(linha[8])/4);
            	vinho.setSulphates(Double.parseDouble(linha[9])/2);
            	vinho.setAlcohol(Double.parseDouble(linha[10])/14);
            	vinho.setQuality(Double.parseDouble(linha[11])/8);
            	quantos++;
            	lista.add(vinho);
            	
            	if(vinho.getFixedAcidity() > 1 || vinho.getVolatileAcidity() > 1 || vinho.getCitricAcid() > 1 || vinho.getResidualSugar() > 1 || vinho.getChlorides() > 1 || vinho.getFreeSulfurDioxide() > 1 || vinho.getTotalSulfurDioxide() > 1 || vinho.getDensity() > 1 || vinho.getPh() > 1 || vinho.getSulphates() > 1 || vinho.getAlcohol() > 1 || vinho.getQuality() > 1){
            		System.out.println("TEM ALGO ERRADO!!");
            		System.out.println("FixedAcidity: "+vinho.getFixedAcidity());
            		System.out.println("VolatileAcidity: "+vinho.getVolatileAcidity());
            		System.out.println("CitricAcid: "+vinho.getCitricAcid());
            		System.out.println("ResidualSugar: "+vinho.getResidualSugar());
            		System.out.println("Chlorides: "+vinho.getChlorides());
            		System.out.println("SulfurDioxide: "+vinho.getFreeSulfurDioxide());
            		System.out.println("TotalSulfurDioxide: "+vinho.getTotalSulfurDioxide());
            		System.out.println("Density: "+vinho.getDensity());
            		System.out.println("Ph: "+vinho.getPh());
            		System.out.println("Sulphates: "+vinho.getSulphates());
            		System.out.println("Alcohol: "+vinho.getAlcohol());
            		System.out.println("Quality: "+vinho.getQuality());
            	}
            	
            }
            System.out.println("Quantos "+quantos);
            for(i=0; i < lista.size(); i++){
            	//System.out.println(lista.get(i));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        
		System.out.println("Alcool: "+vinho.getAlcohol());
		
		while(repeat<1){
			
			neuronioSaida.calculaVoculta(1);
			neuronioSaida.calculaVoculta(2);
			neuronioSaida.calculaVoculta(3);
			
			neuronioSaida.calculaY(1);
			neuronioSaida.calculaY(2);
			neuronioSaida.calculaY(3);
			
			
			neuronioSaida.calculaVsaida(4);
			neuronioSaida.calculaY(4);
			
			erro = neuronioSaida.getD() - neuronioSaida.getY(4);
			
		
			repeat++;
			if(erro != 0){
				//System.out.println("--------------------------");
				System.out.println("---- Erro: "+ erro);
				//System.out.println("---- ErroFormat: "+ erroFormat.format(erro));
				neuronioSaida.calculaGSaida(4, erro);
				neuronioSaida.calculaDelta(4, eta);
				neuronioSaida.ajusteDePesos(4);
				
				// rever esse
				neuronioSaida.calculaGoculta(0);
				
				neuronioSaida.calculaGoculta(1);
				neuronioSaida.calculaGoculta(2);
				neuronioSaida.calculaGoculta(3);
				
				neuronioSaida.calculaDelta(1, eta);
				neuronioSaida.calculaDelta(2, eta);
				neuronioSaida.calculaDelta(3, eta);
				
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
				
				break;
			}
			
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
			
			// Entrada 4 //
			neuronioSaida.setX(0, 1);
			neuronioSaida.setX(1, 0.7044025157);
			neuronioSaida.setX(2, 0.1772151899);
			neuronioSaida.setX(3, 0.56);		
			neuronioSaida.setX(4, 0.1225806452);
			neuronioSaida.setX(5, 0.075);
			neuronioSaida.setX(6, 0.2361111111);
			neuronioSaida.setX(7, 0.2076124567);
			neuronioSaida.setX(8, 0.998);
			neuronioSaida.setX(9, 0.79);
			neuronioSaida.setX(10, 0.29);
			neuronioSaida.setX(11, 0.7);		
			neuronioSaida.setD(0.75);
			
			/*
			System.out.println("--- V1 = "+neuronioSaida.getV(1));
			System.out.println("--- Y1 = "+neuronioSaida.getY(1));
			System.out.println("--- V2 = "+neuronioSaida.getV(2));
			System.out.println("--- Y2 = "+neuronioSaida.getY(2));
			System.out.println("--- V3 = "+neuronioSaida.getV(3));
			System.out.println("--- Y3 = "+neuronioSaida.getY(3));
			System.out.println("--- V4 = "+neuronioSaida.getV(4));
			System.out.println("--- Y4 = "+neuronioSaida.getY(4));
			*/
		
		}
	}
}
