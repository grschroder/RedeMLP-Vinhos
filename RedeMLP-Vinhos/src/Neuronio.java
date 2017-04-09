
public class Neuronio {
	
	//pesos das entradas dos neuronios w[NumerodoNeuronioeNumerodoPeso] ex: w[10] - Neuronio 1, peso da entrada 0
	private double w[] = new double [415];
	private double delta[] = new double [415];
	private double g[] = new double [415];
	private double v[] = new double [5];
	private double y[] = new double [5];
	
	public void zeraV(){
		for (int i=0; i<4; i++){
			this.v[i] = 0;			
		}
	}
	
	public double getV(int posV){
		return v[posV];
	}
	
	public double  getW(int neuNumber){
		return w[neuNumber];		
	}
	
	public double getY(int posY){
		return this.y[posY];		
	}
	
	public void setW(int wNumber, double value){
		this.w[wNumber] = value;		
	}

	public void calculaG(int neuNumber, double value){
		this.g[neuNumber] = value;		
	}
	
	public void calculaDelta(int neuNumber, double value){
		this.delta[neuNumber] = value;		
	}
	
	public double calculaVsaida(int vNumber, int wNumber, int posY){
		this.v[vNumber] = this.w[wNumber] * y[posY] + this.v[vNumber];
		return v[vNumber];
	}
	
	public double calculaVoculta(int vNumber, int wNumber, double x){
		this.v[vNumber] = this.w[wNumber] * x + this.v[vNumber];
		return v[vNumber];
	}
	
	public void calculaY(int posV){
		y[posV] = Math.exp(1.7159*this.v[posV]);		
	}
	
	
	
}
