
public class Neuronio {
	
	//pesos das entradas dos neuronios w[NumerodoNeuronioeNumerodoPeso] ex: w[10] - Neuronio 1, peso da entrada 0
	private double w[] = new double [415];
	private double delta[] = new double [415];
	private double g[] = new double [415];
	
	public double  getW(int neuNumber){
		return w[neuNumber];		
	}
	
	
	public void setW(int neuNumber){
		this.w[neuNumber] = w[neuNumber];		
	}

	public void setG(int neuNumber){
		this.g[neuNumber] = g[neuNumber];		
	}
	
	public void setDelta(int neuNumber){
		this.delta[neuNumber] = delta[neuNumber];		
	}
	
	
}
