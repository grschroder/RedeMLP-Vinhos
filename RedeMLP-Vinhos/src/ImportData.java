import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class ImportData {
	String separadorCampo;
	String separadorLinha;
	String arquivo;
	
	public ArrayList<Vinho> ImportWine(String separadorCampo, String separadorLinha, String arquivo) throws IOException {		
		BufferedReader br = null;
		try{
            br = new BufferedReader(new FileReader(arquivo));
			ArrayList<Vinho> lista = new ArrayList<Vinho>();
			 Boolean primeiraVez = false;
			 if(arquivo.contains("red")){
				 //System.out.println("VINHO RED!!!!!!!!!");
	            while ((separadorLinha = br.readLine()) != null) {
	            	if(!primeiraVez){
	            		primeiraVez = true;            		
	            	}else{
	            		String[] linha = separadorLinha.split(separadorCampo);
	            		Vinho vinho = new Vinho();
	            		vinho.setFixedAcidity(Double.parseDouble(linha[0])/15.9);
	            		vinho.setVolatileAcidity(Double.parseDouble(linha[1])/1.58);
	            		vinho.setCitricAcid(Double.parseDouble(linha[2]));
	            		vinho.setResidualSugar(Double.parseDouble(linha[3])/15.5);
	            		vinho.setChlorides(Double.parseDouble(linha[4]));
	            		vinho.setFreeSulfurDioxide(Double.parseDouble(linha[5])/72);
	            		vinho.setTotalSulfurDioxide(Double.parseDouble(linha[6])/289);
	            		vinho.setDensity(Double.parseDouble(linha[7])/1.00369);
	            		vinho.setPh(Double.parseDouble(linha[8])/4.01);
	            		vinho.setSulphates(Double.parseDouble(linha[9])/2);
	            		vinho.setAlcohol(Double.parseDouble(linha[10])/14.9);
	            		vinho.setQuality(Double.parseDouble(linha[11])/8);
	            		lista.add(vinho);     
	            	}
	            }
			return lista;
			}
			 else if(arquivo.contains("white")){ //if(arquivo.contains("white")){
				 //System.out.println("VINHO WHITE!!!!!!!!!");
				 while ((separadorLinha = br.readLine()) != null) {
		            	if(!primeiraVez){
		            		primeiraVez = true;            		
		            	}else{
		            		String[] linha = separadorLinha.split(separadorCampo);
		            		Vinho vinho = new Vinho();
		            		vinho.setFixedAcidity(Double.parseDouble(linha[0])/14.2);
		            		vinho.setVolatileAcidity(Double.parseDouble(linha[1])/1.1);
		            		vinho.setCitricAcid(Double.parseDouble(linha[2])/1.66);
		            		vinho.setResidualSugar(Double.parseDouble(linha[3])/65.8);
		            		vinho.setChlorides(Double.parseDouble(linha[4]));
		            		vinho.setFreeSulfurDioxide(Double.parseDouble(linha[5])/289);
		            		vinho.setTotalSulfurDioxide(Double.parseDouble(linha[6])/366.5);
		            		vinho.setDensity(Double.parseDouble(linha[7])/1.03898);
		            		vinho.setPh(Double.parseDouble(linha[8])/3.82);
		            		vinho.setSulphates(Double.parseDouble(linha[9])/1.08);
		            		vinho.setAlcohol(Double.parseDouble(linha[10])/14.2);
		            		vinho.setQuality(Double.parseDouble(linha[11])/9);
		            		lista.add(vinho);     
		            	}
		            }
				return lista;
			 }
			 else{ //if(arquivo.contains("white")){
				 //System.out.println("VINHO WHITE!!!!!!!!!");
				 while ((separadorLinha = br.readLine()) != null) {
		            	if(!primeiraVez){
		            		primeiraVez = true;            		
		            	}else{
		            		String[] linha = separadorLinha.split(separadorCampo);
		            		Vinho vinho = new Vinho();
		            		vinho.setFixedAcidity(Double.parseDouble(linha[0])/15.9);
		            		vinho.setVolatileAcidity(Double.parseDouble(linha[1])/1.58);
		            		vinho.setCitricAcid(Double.parseDouble(linha[2])/1.66);
		            		vinho.setResidualSugar(Double.parseDouble(linha[3])/65.8);
		            		vinho.setChlorides(Double.parseDouble(linha[4]));
		            		vinho.setFreeSulfurDioxide(Double.parseDouble(linha[5])/289);
		            		vinho.setTotalSulfurDioxide(Double.parseDouble(linha[6])/440);
		            		vinho.setDensity(Double.parseDouble(linha[7])/1.03898);
		            		vinho.setPh(Double.parseDouble(linha[8])/4.01);
		            		vinho.setSulphates(Double.parseDouble(linha[9])/2);
		            		vinho.setAlcohol(Double.parseDouble(linha[10])/14.2);
		            		vinho.setQuality(Double.parseDouble(linha[11])/9);
		            		lista.add(vinho);     
		            	}
		            }
				return lista;
			 }
		} finally{
			if (br != null) {
                try {
                    br.close();                      
                } catch (IOException e) {
                    e.printStackTrace();
                }
			}	
		}
	} // Término da função de import vinhos
	
	public void ImportWeights(String separadorCampo, String separadorLinha, String arquivo, Neuronio neu) throws IOException{
		BufferedReader br = null;
		try{
            br = new BufferedReader(new FileReader(arquivo));
			 Boolean primeiraVez = false;
			// if(arquivo.contains("red")){
				 //System.out.println("VINHO RED!!!!!!!!!");
	            while ((separadorLinha = br.readLine()) != null) {
	            	if(!primeiraVez){
	            		primeiraVez = true;            		
	            	}
	            	else {
	            		String[] linha = separadorLinha.split(separadorCampo);
	            		//Neuronio neu  = new Neuronio();	            		
	            		neu.setW(10, Double.parseDouble(linha[0]));
	            		neu.setW(11, Double.parseDouble(linha[1]));
	            		neu.setW(12, Double.parseDouble(linha[2]));
	            		neu.setW(13, Double.parseDouble(linha[3]));
	            		neu.setW(14, Double.parseDouble(linha[4]));
	            		neu.setW(15, Double.parseDouble(linha[5]));
	            		neu.setW(16, Double.parseDouble(linha[6]));
	            		neu.setW(17, Double.parseDouble(linha[7]));
	            		neu.setW(18, Double.parseDouble(linha[8]));
	            		neu.setW(19, Double.parseDouble(linha[9]));
	            		neu.setW(110, Double.parseDouble(linha[10]));
	            		neu.setW(111, Double.parseDouble(linha[11]));
	            		neu.setW(20, Double.parseDouble(linha[12]));
	            		neu.setW(21, Double.parseDouble(linha[13]));
	            		neu.setW(22, Double.parseDouble(linha[14]));
	            		neu.setW(23, Double.parseDouble(linha[15]));
	            		neu.setW(24, Double.parseDouble(linha[16]));
	            		neu.setW(25, Double.parseDouble(linha[17]));
	            		neu.setW(26, Double.parseDouble(linha[18]));
	            		neu.setW(27, Double.parseDouble(linha[19]));
	            		neu.setW(28, Double.parseDouble(linha[20]));
	            		neu.setW(29, Double.parseDouble(linha[21]));
	            		neu.setW(210, Double.parseDouble(linha[22]));
	            		neu.setW(211, Double.parseDouble(linha[23]));
	            		neu.setW(30, Double.parseDouble(linha[24]));
	            		neu.setW(31, Double.parseDouble(linha[25]));
	            		neu.setW(32, Double.parseDouble(linha[26]));
	            		neu.setW(33, Double.parseDouble(linha[27]));
	            		neu.setW(34, Double.parseDouble(linha[28]));
	            		neu.setW(35, Double.parseDouble(linha[29]));
	            		neu.setW(36, Double.parseDouble(linha[30]));
	            		neu.setW(37, Double.parseDouble(linha[31]));
	            		neu.setW(38, Double.parseDouble(linha[32]));
	            		neu.setW(39, Double.parseDouble(linha[33]));
	            		neu.setW(310, Double.parseDouble(linha[34]));
	            		neu.setW(311, Double.parseDouble(linha[35]));
	            		neu.setW(40, Double.parseDouble(linha[36]));
	            		neu.setW(41, Double.parseDouble(linha[37]));
	            		neu.setW(42, Double.parseDouble(linha[38]));
	            		neu.setW(43, Double.parseDouble(linha[39]));	            			            		
	            	}
	            } // fecha while
	            
	      // } // fecha if
		} // fecha try
	            finally{
	    			if (br != null) {
	                    try {
	                        br.close();                      
	                    } catch (IOException e) {
	                        e.printStackTrace();
	                    }
	    			}	
	    		}
	} // fecha classe
	
}