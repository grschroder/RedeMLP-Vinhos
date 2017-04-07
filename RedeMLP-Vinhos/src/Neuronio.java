
public class Neuronio {
	
	//pesos das entradas dos neuronios w[NumerodoNeuronioeNumerodoPeso] ex: w[10] - Neuronio 1, peso da entrada 0
	private double w[] = new double [415];
	private double delta[] = new double [415];
	private double g[] = new double [415];
	private double v[] = new double [4];
	
	
	public double  getW(int neuNumber){
		return w[neuNumber];		
	}
	
	
	public void setW(int neuNumber, double value){
		this.w[neuNumber] = value;		
	}

	public void calculaG(int neuNumber, double value){
		this.g[neuNumber] = value;		
	}
	
	public void calculaDelta(int neuNumber, double value){
		this.delta[neuNumber] = value;		
	}
	
	public double calculaVsaida(int neuNumber, double y[]){
		double v=0;
		
		
		return v;
	}
	
	public double calculaVoculta(int vNumber, int wNumber, double x){
		this.v[vNumber] = this.w[wNumber] * x + this.v[vNumber];

		return v[vNumber];
	}
	
	public double calculaY(){
		double y=0;
		return y;		
	}
	
	
	
}
