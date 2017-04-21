import java.net.*;
import java.io.*;
import java.util.ArrayList;


public class Vinhos {
	public double FixedAcidity;
	public double VolatileAcidity;
	public double CitricAcid;
	public double ResidualSugar;
	public double Chlorides;
	public double FreeSulfurDioxide;
	public double TotalSulfurDioxide;
	public double Density;
	public double Ph;
	public double Sulphates;
	public double getPh() {
		return Ph;
	}
	public void setPh(double ph) {
		Ph = ph;
	}
	public double Alcohol;
	public double Quality;
	public double getFixedAcidity() {
		return FixedAcidity;
	}
	public void setFixedAcidity(double fixedAcidity) {
		FixedAcidity = fixedAcidity;
	}
	public double getVolatileAcidity() {
		return VolatileAcidity;
	}
	public void setVolatileAcidity(double volatileAcidity) {
		VolatileAcidity = volatileAcidity;
	}
	public double getCitricAcid() {
		return CitricAcid;
	}
	public void setCitricAcid(double citricAcid) {
		CitricAcid = citricAcid;
	}
	public double getResidualSugar() {
		return ResidualSugar;
	}
	public void setResidualSugar(double residualSugar) {
		ResidualSugar = residualSugar;
	}
	public double getChlorides() {
		return Chlorides;
	}
	public void setChlorides(double chlorides) {
		Chlorides = chlorides;
	}
	public double getFreeSulfurDioxide() {
		return FreeSulfurDioxide;
	}
	public void setFreeSulfurDioxide(double freeSulfurDioxide) {
		FreeSulfurDioxide = freeSulfurDioxide;
	}
	public double getTotalSulfurDioxide() {
		return TotalSulfurDioxide;
	}
	public void setTotalSulfurDioxide(double totalSulfurDioxide) {
		TotalSulfurDioxide = totalSulfurDioxide;
	}
	public double getDensity() {
		return Density;
	}
	public void setDensity(double density) {
		Density = density;
	}
	public double getSulphates() {
		return Sulphates;
	}
	public void setSulphates(double sulphates) {
		Sulphates = sulphates;
	}
	public double getAlcohol() {
		return Alcohol;
	}
	public void setAlcohol(double alcohol) {
		Alcohol = alcohol;
	}
	public double getQuality() {
		return Quality;
	}
	public void setQuality(double quality) {
		Quality = quality;
	}
    @Override
    public String toString(){
    	return "fixed acidity " +FixedAcidity+ ",volatile acidity " +VolatileAcidity+ ",citric acid " +CitricAcid+ 
        ",residual sugar " +ResidualSugar+ ",chlorides " +Chlorides+ ",free sulfur dioxide " +FreeSulfurDioxide+ 
        ",total sulfur dioxide " +TotalSulfurDioxide+ ",density " +Density+ ",pH " +Ph+ ",sulphates " +Sulphates+
        ",alcohol " +Alcohol+ ",quality " +Quality;
    }
    
    public void importCSV(){
    	String csvFile = "E:/GitHubRepository/RedeMLP-Vinhos/Docs/winequality-red.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ";";
        

        try {

            br = new BufferedReader(new FileReader(csvFile));
            ArrayList lista = new ArrayList();
            while ((line = br.readLine()) != null) {
            	String[] linha = line.split(cvsSplitBy);
            	Vinhos vinho = new Vinhos();
            	vinho.setFixedAcidity(Double.parseDouble(linha[0]));
            	vinho.setVolatileAcidity(Double.parseDouble(linha[1]));
            	vinho.setCitricAcid(Double.parseDouble(linha[2]));
            	vinho.setResidualSugar(Double.parseDouble(linha[3]));
            	vinho.setChlorides(Double.parseDouble(linha[4]));
            	vinho.setFreeSulfurDioxide(Double.parseDouble(linha[5]));
            	vinho.setTotalSulfurDioxide(Double.parseDouble(linha[6]));
            	vinho.setDensity(Double.parseDouble(linha[7]));
            	vinho.setPh(Double.parseDouble(linha[8]));
            	vinho.setSulphates(Double.parseDouble(linha[9]));
            	vinho.setAlcohol(Double.parseDouble(linha[10]));
            	vinho.setQuality(Double.parseDouble(linha[11]));
            	lista.add(vinho);
            	
            }            
            for(int i=0; i < lista.size(); i++){
            	System.out.println(lista.get(i));
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
    }
}
