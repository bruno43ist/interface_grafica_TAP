package application;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import entities.Aluno;
import entities.Arvore;
import entities.Nodo;

public class CadastraAluno extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	private Arvore arvore = new Arvore();
	private JButton ins, arq;
	private JLabel name, eemail, ggrr, statusBar;
	private JTextField nome, email, grr;
	
	public CadastraAluno() {
		
		ins = new JButton("INSERIR");
		arq = new JButton("IMPRIMIR ARQUIVO");
		ins.addActionListener(this);
		arq.addActionListener(this);
		name = new JLabel("Digite o nome: ");
		eemail = new JLabel("Digite o email: ");
		ggrr = new JLabel("Digite o GRR: ");
		nome = new JTextField(" ");
		email = new JTextField(" ");
		grr = new JTextField(" ");
		statusBar = new JLabel();
		this.getContentPane().setLayout(new FlowLayout());
		this.getContentPane().add(name);
		nome.setColumns(15);
		this.getContentPane().add(nome);
		this.getContentPane().add(eemail);
		email.setColumns(15);
		this.getContentPane().add(email);
		this.getContentPane().add(ggrr);
		grr.setColumns(15);
		this.getContentPane().add(grr);
		this.getContentPane().add(ins);
		this.getContentPane().add(arq);
		this.getContentPane().add(statusBar, BorderLayout.SOUTH);
		this.setLocation(200, 200);
		this.setSize(950, 100);
	}
	
	public void actionPerformed(ActionEvent e) {
		//SE O BOTÃO INSERIR FOI PRESSIONADO
		if(e.getSource() == ins) {
			//LÊ OS JTextField E CRIA UM NOVO ALUNO
			Aluno aluno = new Aluno(nome.getText(), email.getText(), Integer.parseInt(grr.getText()));
			//INSERE ESSE ALUNO NA ÁRVORE
			arvore.insere(aluno);
			System.out.println("Aluno inserido com sucesso!");
			//LIMPA OS CAMPOS DE ESCRITA DE DADOS
			nome.setText(" ");
			email.setText(" ");
			grr.setText(" ");
			//IMPRIME INSERIR NA JANELA
			statusBar.setText("INSERIU!");
		//SE O BOTÃO IMPRIMIR ARQUIVO FOI PRESSIONADO
		} else if(e.getSource() == arq) {
			//DELETA O ARQUIVO SE ELE JÁ EXISTIR
			File file = new File("/Users/brunofarias/Desktop/TAP/lab_11_09/alunos.txt");
			file.delete();
			//ESCREVE OS ALUNOS EM ORDEM DE GRR NO ARQUIVO
			escreveArquivo(arvore.getRaiz());
			//IMPRIME A ÁRVORE NO CONSOLE
			arvore.imprimeA(arvore.getRaiz());
			//TERMINA A EXECUÇÃO DO PROGRAMA
			System.exit(0);	
		}
	}
	
	//PERCORRE A ARVORE EM ORDEM E IMPRIME CADA NOME NO ARQUIVO
	public void escreveArquivo(Nodo p) {
		if(p == null) {//BASE DA RECURSÃO
			return;
		}
		//PERCORRE SUBÁRVORE DA ESQUERDA
		escreveArquivo(p.getEsq());
		String path = "/Users/brunofarias/Desktop/TAP/lab_11_09/alunos.txt";
		try(BufferedWriter br = new BufferedWriter(new FileWriter(path,true))){
			//ESCREVE NO ARQUIVO
			br.write(p.getAluno().getNome() + " ");
			br.write(p.getAluno().getEmail() + " ");
			br.write(p.getAluno().getGRR() + "\n");
		} catch(IOException e) {//EXCEÇÕES
			System.out.println("Erro! " + e.getMessage());
		}
		//PERCORRE A SUBÁRVORE DA DIREITA
		escreveArquivo(p.getDir());
	}

	public static void main(String[] args) {
		
		//DECLARA UMA NOVA JANELA(FRAME)
		JFrame janela = new CadastraAluno();
		//SETA A JANELA COMO VISÍVEL
		janela.setVisible(true);
		WindowListener x = new WindowAdapter() {
			
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		};
		janela.addWindowListener(x);
	}
}
