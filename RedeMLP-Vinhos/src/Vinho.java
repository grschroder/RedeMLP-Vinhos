import java.net.*;
import java.io.*;
import java.util.ArrayList;


public class Vinho {
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
}
    
    