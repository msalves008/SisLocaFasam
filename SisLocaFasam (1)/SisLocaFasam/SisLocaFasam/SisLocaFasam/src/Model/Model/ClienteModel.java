package Model;

public class ClienteModel {
	private int id;
	private String nome, cpf, rg, telefone, endereco, cep, estado, cidade;
	
	// construtor
	public ClienteModel(int id, String nome, String cpf, String rg, String telefone, String endereco, String cep,
			String estado, String cidade) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.telefone = telefone;
		this.endereco = endereco;
		this.cep = cep;
		this.estado = estado;
		this.cidade = cidade;
	}
	// construtor sem id
	public ClienteModel(String nome, String cpf, String rg, String telefone, String endereco, String cep, String estado,
			String cidade) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.telefone = telefone;
		this.endereco = endereco;
		this.cep = cep;
		this.estado = estado;
		this.cidade = cidade;
	}
	public ClienteModel() {
		
	}
	
	// gets e sets
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	// toString
	@Override
	public String toString() {
		return "ClienteModel [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", rg=" + rg + ", telefone=" + telefone
				+ ", endereco=" + endereco + ", cep=" + cep + ", estado=" + estado + ", cidade=" + cidade + "]";
	}
	
	
	
	
}
