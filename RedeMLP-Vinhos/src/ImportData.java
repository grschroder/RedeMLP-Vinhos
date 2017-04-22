import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class ImportData {
	String separadorCampo;
	String separadorLinha;
	String arquivo;
	
	public ArrayList<Vinho> ImportData(String separadorCampo, String separadorLinha, String arquivo) throws IOException {		
		BufferedReader br = null;
		try{
            br = new BufferedReader(new FileReader(arquivo));
			ArrayList<Vinho> lista = new ArrayList<Vinho>();
			 Boolean primeiraVez = false;
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
		} finally{
			if (br != null) {
                try {
                    br.close();                      
                } catch (IOException e) {
                    e.printStackTrace();
                }
			}	
		}	
	}
}