package Model;

public class Veiculo {
		
		private int id;
		private String marca, modelo, cor, potencia, placa, combustivel, situacao,  ano;
		
		//Construtor
		public Veiculo(int id, String ano, String marca, String modelo, String cor, String potencia, String placa,
				String combustivel, String situacao) {
			super();
			this.id = id;
			this.ano = ano;
			this.marca = marca;
			this.modelo = modelo;
			this.cor = cor;
			this.potencia = potencia;
			this.placa = placa;
			this.combustivel = combustivel;
			this.situacao = situacao;
		}
		
		// construtor sem ID
		public Veiculo(String ano, String marca, String modelo, String cor, String potencia, String placa,
				String combustivel, String situacao) {
			super();
			this.ano = ano;
			this.marca = marca;
			this.modelo = modelo;
			this.cor = cor;
			this.potencia = potencia;
			this.placa = placa;
			this.combustivel = combustivel;
			this.situacao = situacao;
		}
		
		public Veiculo() {
			
		}


		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getAno() {
			return ano;
		}

		public void setAno(String ano) {
			this.ano = ano;
		}

		public String getMarca() {
			return marca;
		}

		public void setMarca(String marca) {
			this.marca = marca;
		}

		public String getModelo() {
			return modelo;
		}

		public void setModelo(String modelo) {
			this.modelo = modelo;
		}

		public String getCor() {
			return cor;
		}

		public void setCor(String cor) {
			this.cor = cor;
		}

		public String getPotencia() {
			return potencia;
		}

		public void setPotencia(String potencia) {
			this.potencia = potencia;
		}

		public String getPlaca() {
			return placa;
		}

		public void setPlaca(String placa) {
			this.placa = placa;
		}

		public String getCombustivel() {
			return combustivel;
		}

		public void setCombustivel(String combustivel) {
			this.combustivel = combustivel;
		}

		public String getSituacao() {
			return situacao;
		}

		public void setSituacao(String situacao) {
			this.situacao = situacao;
		}

		//ToString
		@Override
		public String toString() {
			return "Veiculo [id=" + id + ", ano=" + ano + ", marca=" + marca + ", modelo=" + modelo + ", cor=" + cor
					+ ", potencia=" + potencia + ", placa=" + placa + ", combustivel=" + combustivel + ", situacao="
					+ situacao + "]";
		}
		
		
		
	
		

		
}
