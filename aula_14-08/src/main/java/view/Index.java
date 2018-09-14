package view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import model.Editora;

public class Index extends JFrame {
	
	JButton editora = new JButton("EDITORA");
	JButton escritor = new JButton("ESCRITOR");
	JButton livro = new JButton("LIVROS");
	

	public Index() {
		super ("CADASTRO LIVRARIA");
		Container paine = this.getContentPane();
		
		paine.add(editora);
		editora.setBounds(50,40,200,40);
		editora.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				EditoraView editoraView = new EditoraView(); 
				dispose();
			}
		});
		
		paine.add(escritor);
		escritor.setBounds(50, 90, 200, 40);
		escritor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EscritorView escritorView = new EscritorView();
			}
		});
		
		paine.add(livro);
		livro.setBounds(50, 140, 200, 40);
		livro.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				LivrosView livrosView = new LivrosView();
			}
		});
	
	this.setLayout(null);
	this.setResizable(false);
	this.setVisible(true);
	this.setSize(300, 245);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	this.setLocationRelativeTo(null);
}
	public static void main(String args[]) {
		Index janelaApp = new Index();
	}
}
