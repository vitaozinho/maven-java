package view;



import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import controller.LivroJdbcDAO;
import controller.EditoraJdbcDAO;
import controller.EscritorJdbcDAO;
import controller.JdbUtil;
import model.Escritor;
import model.Livro;

public class LivrosView extends JFrame {
	
	JTextField txtNOME = new JTextField();
	JLabel nome = new JLabel("NOME DO LIVRO: ");
	
	JTextField txtPag = new JTextField();
	JLabel pag = new JLabel("NÚMERO DE PÁGINAS: ");
	
	JFormattedTextField txtEditora = new JFormattedTextField();
	JLabel editora = new JLabel("CNPJ DA EDITORA: ");
	
	JFormattedTextField txtCPF = new JFormattedTextField();
	JLabel cpf = new JLabel("CPF ESCRITOR:");
	
	JTextField txtDel = new JTextField();
	JLabel del = new JLabel ("DELETAR LIVRO");
	
	
	JButton btnSalvar = new JButton("Salvar");
	JButton btnDel = new JButton("Deletar");
	
	
    

	public LivrosView(){
		super("Cadastro Livros");
		
		try {
			
			MaskFormatter mcpf = new MaskFormatter("###.###.###/##");
			mcpf.setPlaceholderCharacter('0');
			mcpf.install(txtCPF);
			
			MaskFormatter mcnpj = new MaskFormatter("##.###.###/####-##");
			mcnpj.setPlaceholderCharacter('0');
			mcnpj.install(txtEditora);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		Container paine = this.getContentPane();
		
		paine.add(nome);
		paine.add(txtNOME);	
		nome.setFont(new Font("Arial", Font.PLAIN, 12));
		nome.setBounds(10, 15, 150, 30);
		txtNOME .setBounds(150, 15, 170, 30);
		
		paine.add(pag);
		paine.add(txtPag);	
		pag.setFont(new Font("Arial", Font.PLAIN, 12));
		pag.setBounds(10, 50, 150, 30);
		txtPag.setBounds(150, 50, 170, 30);	
		
		paine.add(editora);
		paine.add(txtEditora);	
		editora.setFont(new Font("Arial", Font.PLAIN, 12));
		editora.setBounds(10, 85, 150, 30);
		txtEditora.setBounds(150, 85, 170, 30);
		
		paine.add(cpf);
		paine.add(txtCPF);
		cpf.setFont(new Font("Arial", Font.PLAIN, 12));
		cpf.setBounds(10, 115, 150, 30);
		txtCPF.setBounds(150, 115, 170, 30);
	
		paine.add(del);
		paine.add(txtDel);
		del.setFont(new Font("Arial", Font.PLAIN, 12));
		del.setBounds(350, 5 , 150, 30);
		txtDel.setBounds(350, 35, 150, 30);
		
		
	
		paine.add(btnSalvar);
		btnSalvar.setBounds(210, 250, 130, 30);
		btnSalvar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try {
					Connection connection = JdbUtil.getConnection();
					
				EditoraJdbcDAO editoraJdbcDao = new EditoraJdbcDAO(connection);	
				Escritor escritor = new Escritor();
				EscritorJdbcDAO escritorJdbcDao = new EscritorJdbcDAO(connection);
				LivroJdbcDAO livroJdbcDao = new LivroJdbcDAO(connection);
				
				int id = editoraJdbcDao.listarEditora(Integer.parseInt(txtEditora.getText()));
				int cd = escritorJdbcDao.listarEscritor(Integer.parseInt(txtCPF.getText()));	
					
					
				Livro livro = new Livro();
				livro.setNrCnpjEditora(id);
				livro.setNrCpfEscritor(cd);
				livro.setNmLivro(txtNOME.getText());
				livro.setNrPag(Integer.parseInt(txtPag.getText()));
				livro.setNrCnpjEditora(Integer.parseInt(txtEditora.getText()));
				livro.setNrCpfEscritor(Integer.parseInt(txtCPF.getText()));
			
				
				
				livroJdbcDao.salvar(livro);
				
				}catch(Exception ex) {
					ex.printStackTrace();
				}
			}
		
		
	});
		paine.add(btnDel);
		btnDel.setBounds(350, 250, 130, 30);
		btnDel.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					Connection connection = JdbUtil.getConnection();
					LivroJdbcDAO livroJdbcDao = new LivroJdbcDAO(connection);
					
					livroJdbcDao.deletar(Integer.parseInt(txtDel.getText()));
					
				}catch(Exception ex) {
					ex.printStackTrace();
				}
			}
		});
	
	this.setLayout(null);
	this.setVisible(true);
	this.setSize(600, 330);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	this.setLocationRelativeTo(null);
}
public static void main( String[] args )
{
	LivrosView livrosView = new LivrosView();
}
}



