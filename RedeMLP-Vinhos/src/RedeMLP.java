import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.*;
import java.net.*;
import java.util.ArrayList;


public class RedeMLP {

	public static void main(String[] args) throws IOException {
		String terminolinha = "";
		String terminocampo = ";";		
		//String arquivo = "C:/Users/crist/Google Drive/Estudo/Faculdade/IA_II/RedeMLP-Vinhos/RedeMLP-Vinhos/src/winequality-red.csv";
		String arquivo = "E:/GitHubRepository/RedeMLP-Vinhos/Docs/winequality-red.csv";
		//Chama a classe para importar os vinhos e adicionar na lista de objetos
		ArrayList<Vinho> vinhos;		
		ImportData csv = new ImportData();
		
		vinhos = csv.ImportData(terminocampo,terminolinha,arquivo);
		// Se quiser printar os objetos na tela, basta descomentar as 3 linhas abaixo		
        
				// Normalizar as entradas para estarem entre 0 e 1.
		// entradas que devem ser normalizadas: fixed acidity, residual sugar, free sulfur dioxide, total sulfur dioxide, pH, sulphates, alcohol
		//densidade vem bugada no excel e no libreoffice
		// a sa�da do programa � a quality
		
		//na propaga��o, o v sa� do neuronio, a partir dele � calculado o y atrav�s da fun��o de ativa��o Q
		
		
		Neuronio neuronioSaida = new Neuronio();
		int repeat = 1;
		int epocas = 0, i;
		double y;
		double erro; 
		double erroGeral;
		double eta = 0.3d; 
		
		
		//System.out.println("--- TREINAMENTO");
		neuronioSaida.zeraV();
		
		// Pesos das entradas padroes //
		neuronioSaida.setW(10, 1);
		neuronioSaida.setW(20, 1);
		neuronioSaida.setW(30, 1);
		neuronioSaida.setW(40, 1);
		// -- //				            			
		while(true){
			neuronioSaida.setX(1, vinhos.get(repeat).FixedAcidity);
			neuronioSaida.setX(2, vinhos.get(repeat).VolatileAcidity);
			neuronioSaida.setX(4, vinhos.get(repeat).CitricAcid);
			neuronioSaida.setX(4, vinhos.get(repeat).ResidualSugar);
			neuronioSaida.setX(5, vinhos.get(repeat).Chlorides);
			neuronioSaida.setX(6, vinhos.get(repeat).FreeSulfurDioxide);
			neuronioSaida.setX(7, vinhos.get(repeat).TotalSulfurDioxide);
			neuronioSaida.setX(7, vinhos.get(repeat).Density);
			neuronioSaida.setX(8, vinhos.get(repeat).Ph);
			neuronioSaida.setX(10, vinhos.get(repeat).Sulphates);
			neuronioSaida.setX(11, vinhos.get(repeat).Alcohol);
			neuronioSaida.setD(vinhos.get(repeat).Quality);		

			
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

				System.out.println("Vezes: "+repeat);
				

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
				System.out.println("	W110	: 	"	+	neuronioSaida.getW(	110	))	;	
				System.out.println("	W111	: 	"	+	neuronioSaida.getW(	111	))	;	
				
				//break;
			}
		}
	}
}
