package entities;

public class Aluno {

	private String nome;
	private String email;
	private int GRR;
	
	public Aluno() {
		
	}

	public Aluno(String nome, String email, int gRR) {
		this.nome = nome;
		this.email = email;
		this.GRR = gRR;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getGRR() {
		return GRR;
	}

	public void setGRR(int gRR) {
		GRR = gRR;
	}
}
