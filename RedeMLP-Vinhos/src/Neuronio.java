
public class Neuronio {
	
	//pesos das entradas dos neuronios w[NumerodoNeuronioeNumerodoPeso] ex: w[10] - Neuronio 1, peso da entrada 0
	private double w[] = new double [415];
	private double delta[] = new double [415];
	private double g[] = new double [415];
	
	public double  getW(int neuNumber){
		return w[neuNumber];		
	}
	
	
	public void setW(int neuNumber, double value){
		this.w[neuNumber] = value;		
	}

	public void setG(int neuNumber, double value){
		this.g[neuNumber] = value;		
	}
	
	public void setDelta(int neuNumber, double value){
		this.delta[neuNumber] = value;		
	}
	
	
}
