package entities;

public class Nodo {
	
	private Aluno aluno;
	private Nodo esq;
	private Nodo dir;
	
	public Nodo() {
		
	}

	public Nodo(Aluno aluno, Nodo esq, Nodo dir) {
		this.aluno = aluno;
		this.esq = esq;
		this.dir = dir;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setElem(Aluno aluno) {
		this.aluno = aluno;
	}

	public Nodo getEsq() {
		return esq;
	}

	public void setEsq(Nodo esq) {
		this.esq = esq;
	}

	public Nodo getDir() {
		return dir;
	}

	public void setDir(Nodo dir) {
		this.dir = dir;
	}
}
