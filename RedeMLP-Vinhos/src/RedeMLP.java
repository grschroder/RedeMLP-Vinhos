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
		//String arquivo = "E:/GitHubRepository/RedeMLP-Vinhos/Docs/winequality-white.csv";
		//Chama a classe para importar os vinhos e adicionar na lista de objetos
		ArrayList<Vinho> vinhos;		
		ImportData csv = new ImportData();
		
		vinhos = csv.ImportData(terminocampo,terminolinha,arquivo);
		// Se quiser printar os objetos na tela, basta descomentar as 3 linhas abaixo		
        
				// Normalizar as entradas para estarem entre 0 e 1.
		// entradas que devem ser normalizadas: fixed acidity, residual sugar, free sulfur dioxide, total sulfur dioxide, pH, sulphates, alcohol
		//densidade vem bugada no excel e no libreoffice
		// a saï¿½da do programa ï¿½ a quality
		
		//na propagaï¿½ï¿½o, o v saï¿½ do neuronio, a partir dele ï¿½ calculado o y atravï¿½s da funï¿½ï¿½o de ativaï¿½ï¿½o Q
		
		JSONObject jsonObject = new JSONObject();
		JSONArray jsonArray = new JSONArray();
		
		Neuronio neuronioSaida = new Neuronio();
		int repeat = 0;
		int epocas = 0, i;
		double y; 
		double erroGeral;
		double eta = 1.0d; 
		int entradasTreinamento;
		double erroMedio=0;
		int qtdCertos=0;
		double erro[] = new double[vinhos.size()];
		
		//Treinamento com 80% das entradas
		entradasTreinamento = (vinhos.size()*80)/100;
		System.out.println("Entradas treinamento "+entradasTreinamento);
		
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
			
			//Verifica se todas as entradas são menor que 1
			if(vinhos.get(repeat).FixedAcidity > 1 || vinhos.get(repeat).VolatileAcidity > 1 || vinhos.get(repeat).CitricAcid > 1 || vinhos.get(repeat).ResidualSugar > 1 || vinhos.get(repeat).Chlorides > 1 || vinhos.get(repeat).FreeSulfurDioxide > 1 || vinhos.get(repeat).TotalSulfurDioxide > 1 || vinhos.get(repeat).Density > 1 || vinhos.get(repeat).Ph > 1 || vinhos.get(repeat).Sulphates > 1 || vinhos.get(repeat).Alcohol > 1 || vinhos.get(repeat).Quality > 1){
        		System.out.println("TEM ALGO ERRADO!!");
        		System.out.println("FixedAcidity: "+vinhos.get(repeat).FixedAcidity);
        		System.out.println("VolatileAcidity: "+vinhos.get(repeat).VolatileAcidity);
        		System.out.println("CitricAcid: "+vinhos.get(repeat).CitricAcid);
        		System.out.println("ResidualSugar: "+vinhos.get(repeat).ResidualSugar);
        		System.out.println("Chlorides: "+vinhos.get(repeat).Chlorides);
        		System.out.println("SulfurDioxide: "+vinhos.get(repeat).FreeSulfurDioxide);
        		System.out.println("TotalSulfurDioxide: "+vinhos.get(repeat).TotalSulfurDioxide);
        		System.out.println("Density: "+vinhos.get(repeat).Density);
        		System.out.println("Ph: "+vinhos.get(repeat).Ph);
        		System.out.println("Sulphates: "+vinhos.get(repeat).Sulphates);
        		System.out.println("Alcohol: "+vinhos.get(repeat).Alcohol);
        		System.out.println("Quality: "+vinhos.get(repeat).Quality);
        		break;
        	}
        	
			neuronioSaida.calculaVoculta(1);
			neuronioSaida.calculaVoculta(2);
			neuronioSaida.calculaVoculta(3);
			
			neuronioSaida.calculaY(1);
			neuronioSaida.calculaY(2);
			neuronioSaida.calculaY(3);
			
			neuronioSaida.calculaVsaida(4);
			neuronioSaida.calculaY(4);
			
			erro[repeat] = neuronioSaida.getD() - neuronioSaida.getY(4);
			
			if(erro[repeat] != 0){
				//System.out.println("--------------------------");
				//System.out.println("---- Erro: "+ erro);
				//System.out.println("---- ErroFormat: "+ erroFormat.format(erro));
				neuronioSaida.calculaGSaida(4, erro[repeat]);
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
			else if (erro[repeat] == 0){
				qtdCertos++;
				
				/*System.out.println("	W10	: 	"	+	neuronioSaida.getW(10));
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
				
				jsonArray.add(neuronioSaida.getW(10));
				jsonArray.add(neuronioSaida.getW(11));
				jsonArray.add(neuronioSaida.getW(12));
				jsonArray.add(neuronioSaida.getW(13));
				jsonArray.add(neuronioSaida.getW(14));
				jsonArray.add(neuronioSaida.getW(15));
				jsonArray.add(neuronioSaida.getW(16));
				jsonArray.add(neuronioSaida.getW(17));
				jsonArray.add(neuronioSaida.getW(18));
				jsonArray.add(neuronioSaida.getW(19));
				jsonArray.add(neuronioSaida.getW(110));
				jsonArray.add(neuronioSaida.getW(111));
				jsonObject.put("Weights", jsonArray);
				
				FileWriter fileWriter = new FileWriter("E:/GitHubRepository/RedeMLP-Vinhos/Docs/sample.json");
				fileWriter.write(jsonObject.toJSONString());
	            fileWriter.close();
				//break;*/
			}
			//Final da Época
			if (entradasTreinamento == repeat){
				for (int iterator=0; iterator < entradasTreinamento ; iterator++){
					if (iterator == 0){
						erroMedio = erro[iterator];
						erro[iterator]=0;
					}
					else{
						erroMedio = erroMedio + erro[iterator];
						erro[iterator]=0;
					}
				}
				erroMedio = Math.pow(erroMedio, 2)/entradasTreinamento;
				System.out.println("Erro medio quadrado E: "+erroMedio);
				epocas++;
				System.out.println("Epocas: "+epocas);
				System.out.println("Quantidade que deu certo: "+qtdCertos);				
				if (erroMedio < 100){
					break;
				}
				repeat=0;
				erroMedio=0;
				qtdCertos=0;
				//break;
			}
			//System.out.println("Entradas treinamento "+entradasTreinamento);
			//System.out.println("Repeat "+repeat);
			
			repeat++;
		}
	}
}
