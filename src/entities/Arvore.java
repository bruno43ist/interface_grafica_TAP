package entities;

public class Arvore {
	
	private Nodo raiz;
	
	public Arvore() {
		this.raiz = null;
	}
	
	public Nodo getRaiz() {
		return raiz;
	}

	public void setRaiz(Nodo raiz) {
		this.raiz = raiz;
	}

	public void insere(Aluno aluno) {
		if(this.raiz == null) {
			this.raiz = new Nodo(aluno, null, null);
		} else {
			raiz = insereR(aluno, this.raiz);
		}
	}
	
	private Nodo insereR(Aluno aluno, Nodo p) {
		if(p == null) {
			p = new Nodo(aluno, null, null);
			return p;
		} else {
			//SE GRR DO ALUNO É MAIOR DO QUE O DO NÓ ATUAL -> VAI PRA SUBÁRVORE DA DIREITA
			if(p.getAluno().getGRR() < aluno.getGRR()) {
				p.setDir(insereR(aluno,p.getDir()));
			//SE GRR DO ALUNO É MENOR DO QUE O DO NÓ ATUAL -> VAI PRA SUBÁRVORE DA ESQUERDA
			} else if(p.getAluno().getGRR() > aluno.getGRR()) {
				p.setEsq(insereR(aluno, p.getEsq()));
			}
		}
		return p;
	}
	
	//RETORNA TAMANHO DA ÁRVORE(CONTANDO A RAIZ)
	public int tamanho(Nodo p) {
		if(p == null) {
			return 1;
		}
		return(tamanho(p.getEsq()) + tamanho(p.getDir()));
	}
	
	//RETORNA TRUE SE A ÁRVORE ESTIVER VAZIA ELSE FALSE
	public boolean vazia(Nodo p) {
		if(p == null) {
			return true;
		}
		return false;
	}
	
	//IMPRIME A ARVORE EM STDOUT
	public void imprimeA(Nodo p) {
		if(p == null) {
			return;
		}
		System.out.println("\n");
		imprimeA(p.getEsq());
		System.out.print(p.getAluno().getNome() + " ");
		System.out.print(p.getAluno().getEmail()+ " ");
		System.out.print(p.getAluno().getGRR() + "\n");
		imprimeA(p.getDir());
		System.out.println("\n");
	}
}
