import java.io.*;

public class Neuronio {
	
	//pesos das entradas dos neuronios w[NumerodoNeuronioeNumerodoPeso] ex: w[10] - Neuronio 1, peso da entrada 0
	private double w[] = new double [415];
	private double delta[] = new double [415];
	private double g[] = new double [415];
	private double v[] = new double [5];
	private double y[] = new double [5];
	private double x[] = new double [12];
	private double d;
	
	public void zeraV(){
		for (int i=0; i<4; i++){
			this.v[i] = 0;			
		}
	}
	
	public void setX(int posX, double value){
		this.x[posX] = value;
	}
	
	public void setW(int wNumber, double value){
		this.w[wNumber] = value;		
	}
	
	public void setD(double value){
		this.d = value;		
	}

	public double getV(int posV){
		return v[posV];
	}	

	public double getW(int posW){
		return w[posW];		
	}
	
	public double getY(int posY){
		return this.y[posY];		
	}
	
	public double getD(){
		return d;
	}
	
	public double getG(int posG){
		return g[posG];
	}
	
	public void calculaGSaida(int neuNumber, double erro){
		//Q’ (Vk) = Q(Vk) * (1 – Q(Vk) <- derivada da função de transferencia
		//1/1 + exp(-a*Vk) * (1 - (1/1 + exp(-a*Vk)))
		//y * (1 - y) * erro
		this.g[neuNumber] = this.y[neuNumber] * (1 - this.y[neuNumber]) * erro;
		
		//Tangente Hiperbolica
		//this.g[neuNumber] = 1 - (Math.tanh(this.v[neuNumber]) * Math.tanh(this.v[neuNumber])) * erro;
		
		//System.out.println("G4 = "+this.g[neuNumber]);
	}
	
	public void calculaGoculta(int neuNumber){
		//DÚVIDA ABAIXO: PRA CALCULAR O GRADIENTE DA CAMADA OCULTA, A SOMATÓRIA INCLUI OS PESOS DE TODAS ENTRADAS DO NEURONIO A DIREITA?
		//this.g[neuNumber] = this.y[neuNumber] * (1 - this.y[neuNumber]) * (this.g[4] * this.w[40] + this.g[4] * this.w[41] + this.g[4] * this.w[42] + this.g[4] * this.w[43]);
		//Tangente Hiperbolica
		//this.g[neuNumber] = 1 - Math.tan(this.v[neuNumber]) * Math.tan(this.v[neuNumber]) * (this.g[4] * this.w[40] + this.g[4] * this.w[41] + this.g[4] * this.w[42] + this.g[4] * this.w[43]);
		
		if (neuNumber == 1){
			this.g[neuNumber] = this.y[neuNumber] * (1 - this.y[neuNumber]) * (this.g[4] * this.w[41]);
			//Tangente Hiperbolica
			//this.g[neuNumber] = 1 - (Math.tanh(this.v[neuNumber]) * Math.tanh(this.v[neuNumber])) * (this.g[4] * this.w[41]);
		}
		
		else if (neuNumber == 2){
			this.g[neuNumber] = this.y[neuNumber] * (1 - this.y[neuNumber]) * (this.g[4] * this.w[42]);
			//Tangente Hiperbolica
			//this.g[neuNumber] = 1 - (Math.tanh(this.v[neuNumber]) * Math.tanh(this.v[neuNumber])) * (this.g[4] * this.w[42]);
		}
		
		else if (neuNumber == 3){
			this.g[neuNumber] = this.y[neuNumber] * (1 - this.y[neuNumber]) * (this.g[4] * this.w[43]);
			//Tangente Hiperbolica
			//this.g[neuNumber] = 1 - (Math.tanh(this.v[neuNumber]) * Math.tanh(this.v[neuNumber])) * (this.g[4] * this.w[43]);
		}
		
		//System.out.println("G"+neuNumber+" = "+this.g[neuNumber]);
		}
	
	public void calculaDelta(int neuNumber, double eta){
		//delta = g * eta * y
		
		if (neuNumber == 1){
			this.delta[10] = this.g[neuNumber] * eta * this.x[0];
			this.delta[11] = this.g[neuNumber] * eta * this.x[1];
			this.delta[12] = this.g[neuNumber] * eta * this.x[2];
			this.delta[13] = this.g[neuNumber] * eta * this.x[3];			
			this.delta[14] = this.g[neuNumber] * eta * this.x[4];
			this.delta[15] = this.g[neuNumber] * eta * this.x[5];
			this.delta[16] = this.g[neuNumber] * eta * this.x[6];
			this.delta[17] = this.g[neuNumber] * eta * this.x[7];
			this.delta[18] = this.g[neuNumber] * eta * this.x[8];
			this.delta[19] = this.g[neuNumber] * eta * this.x[9];
			this.delta[110] = this.g[neuNumber] * eta * this.x[10];
			this.delta[111] = this.g[neuNumber] * eta * this.x[11];
		}
		
		else if (neuNumber == 2){
			this.delta[20] = this.g[neuNumber] * eta * this.x[0];
			this.delta[21] = this.g[neuNumber] * eta * this.x[1];
			this.delta[22] = this.g[neuNumber] * eta * this.x[2];
			this.delta[23] = this.g[neuNumber] * eta * this.x[3];			
			this.delta[24] = this.g[neuNumber] * eta * this.x[4];
			this.delta[25] = this.g[neuNumber] * eta * this.x[5];
			this.delta[26] = this.g[neuNumber] * eta * this.x[6];
			this.delta[27] = this.g[neuNumber] * eta * this.x[7];
			this.delta[28] = this.g[neuNumber] * eta * this.x[8];
			this.delta[29] = this.g[neuNumber] * eta * this.x[9];
			this.delta[210] = this.g[neuNumber] * eta * this.x[10];
			this.delta[211] = this.g[neuNumber] * eta * this.x[11];			
		}
		
		else if (neuNumber == 3){
			this.delta[30] = this.g[neuNumber] * eta * this.x[0];
			this.delta[31] = this.g[neuNumber] * eta * this.x[1];
			this.delta[32] = this.g[neuNumber] * eta * this.x[2];
			this.delta[33] = this.g[neuNumber] * eta * this.x[3];			
			this.delta[34] = this.g[neuNumber] * eta * this.x[4];
			this.delta[35] = this.g[neuNumber] * eta * this.x[5];
			this.delta[36] = this.g[neuNumber] * eta * this.x[6];
			this.delta[37] = this.g[neuNumber] * eta * this.x[7];
			this.delta[38] = this.g[neuNumber] * eta * this.x[8];
			this.delta[39] = this.g[neuNumber] * eta * this.x[9];
			this.delta[310] = this.g[neuNumber] * eta * this.x[10];
			this.delta[311] = this.g[neuNumber] * eta * this.x[11];			
		}
			
		else if (neuNumber == 4){
			this.delta[40] = this.g[neuNumber] * eta * 0;
			this.delta[41] = this.g[neuNumber] * eta * this.y[1];
			this.delta[42] = this.g[neuNumber] * eta * this.y[2];
			this.delta[43] = this.g[neuNumber] * eta * this.y[3];
			//System.out.println("Delta40: "+this.delta[40]);
			//System.out.println("Delta41: "+this.delta[41]);
			//System.out.println("Delta42: "+this.delta[42]);
			//System.out.println("Delta43: "+this.delta[43]);
		}
		
	}
	
	public void ajusteDePesos(int neuNumber){
		//w = w + delta
		if (neuNumber == 1){
			this.w[10] = this.w[10] + this.delta[10];
			this.w[11] = this.w[11] + this.delta[11];
			this.w[12] = this.w[12] + this.delta[12];
			this.w[13] = this.w[13] + this.delta[13];			
			this.w[14] = this.w[14] + this.delta[14];
			this.w[15] = this.w[15] + this.delta[15];
			this.w[16] = this.w[16] + this.delta[16];
			this.w[17] = this.w[17] + this.delta[17];			
			this.w[18] = this.w[18] + this.delta[18];
			this.w[19] = this.w[19] + this.delta[19];
			this.w[110] = this.w[110] + this.delta[110];
			this.w[111] = this.w[111] + this.delta[111];			
		}
		
		else if (neuNumber == 2){
			this.w[20] = this.w[20] + this.delta[20];
			this.w[21] = this.w[21] + this.delta[21];
			this.w[22] = this.w[22] + this.delta[22];
			this.w[23] = this.w[23] + this.delta[23];			
			this.w[24] = this.w[24] + this.delta[24];
			this.w[25] = this.w[25] + this.delta[25];
			this.w[26] = this.w[26] + this.delta[26];
			this.w[27] = this.w[27] + this.delta[27];			
			this.w[28] = this.w[28] + this.delta[28];
			this.w[29] = this.w[29] + this.delta[29];
			this.w[210] = this.w[210] + this.delta[210];
			this.w[211] = this.w[211] + this.delta[211];
		}
		
		else if (neuNumber == 3){
			this.w[30] = this.w[30] + this.delta[30];
			this.w[31] = this.w[31] + this.delta[31];
			this.w[32] = this.w[32] + this.delta[32];
			this.w[33] = this.w[33] + this.delta[33];			
			this.w[34] = this.w[34] + this.delta[34];
			this.w[35] = this.w[35] + this.delta[35];
			this.w[36] = this.w[36] + this.delta[36];
			this.w[37] = this.w[37] + this.delta[37];			
			this.w[38] = this.w[38] + this.delta[38];
			this.w[39] = this.w[39] + this.delta[39];
			this.w[310] = this.w[310] + this.delta[310];
			this.w[311] = this.w[311] + this.delta[311];
		}
		
		else if (neuNumber == 4){
			this.w[40] = this.w[40] + this.delta[40];
			this.w[41] = this.w[41] + this.delta[41];
			this.w[42] = this.w[42] + this.delta[42];
			this.w[43] = this.w[43] + this.delta[43];
			//System.out.println("w40: "+this.w[40]);
			//System.out.println("w41: "+this.w[41]);
			//System.out.println("w42: "+this.w[42]);
			//System.out.println("w43: "+this.w[43]);
		}
		
	}
	
	public double calculaVsaida(int vNumber){		
		if (vNumber == 4){	
			this.v[vNumber] = this.w[40] * this.x[0] + this.w[41] * this.y[1] + this.w[42] * this.y[2] + this.w[43] * this.y[3] ;
			//System.out.println("V"+vNumber+" = "+this.v[vNumber]);
			//System.out.println(" "+this.w[40]+" "+this.x[0]+" "+this.w[41]+" "+this.y[1]+" "+this.w[42]+" "+this.y[2]+" "+this.w[43]+" "+this.y[3]);
		} 		
		return v[vNumber];		
	}
	
	public double calculaVoculta(int vNumber){
		
		if (vNumber == 1){	
			this.v[vNumber] = this.w[10] * this.x[0] + this.w[11] * this.x[1] + this.w[12] * this.x[2] + this.w[13] * this.x[3] + this.w[14] * this.x[4] + this.w[15] * this.x[5] + this.w[16] * this.x[6] + this.w[17] * this.x[7] + this.w[18] * this.x[8] + this.w[19] * this.x[9] + this.w[110] * this.x[10] + this.w[111] * this.x[11] ;
			//System.out.println("*** V1 = "+this.v[1]);
		} 
		
		else if (vNumber == 2){	
			this.v[vNumber] = this.w[20] * this.x[0] + this.w[21] * this.x[1] + this.w[22] * this.x[2] + this.w[23] * this.x[3] + this.w[24] * this.x[4] + this.w[25] * this.x[5] + this.w[26] * this.x[6] + this.w[27] * this.x[7] + this.w[28] * this.x[8] + this.w[29] * this.x[9] + this.w[210] * this.x[10] + this.w[211] * this.x[11] ;
			//System.out.println("*** V2 = "+this.v[2]);
		}
		
		else if (vNumber == 3){	
			this.v[vNumber] = this.w[30] * this.x[0] + this.w[31] * this.x[1] + this.w[32] * this.x[2] + this.w[33] * this.x[3] + this.w[34] * this.x[4] + this.w[35] * this.x[5] + this.w[36] * this.x[6] + this.w[37] * this.x[7] + this.w[38] * this.x[8] + this.w[39] * this.x[9] + this.w[310] * this.x[10] + this.w[311] * this.x[11] ;
			//System.out.println("*** V3 = "+this.v[3]);
		}
		
		return v[vNumber];
	}
	
	public void calculaY(int posV){
		//Função de transferência
		this.y[posV] = 1/1 + Math.exp(-1.7159*this.v[posV]);
		//Tangente Hiperbolica
		//this.y[posV] = Math.tanh(this.v[posV]);
		//System.out.println("Y"+posV+" = "+this.y[posV]);
	}
	
	public void printPesos() throws IOException {
		FileWriter fileWriter = new FileWriter("E:/GitHubRepository/RedeMLP-Vinhos/Docs/teste.csv");
		fileWriter.write("W10="+this.w[10]+";W11="+this.w[11]+"");
		fileWriter.close();
	}
	
}
