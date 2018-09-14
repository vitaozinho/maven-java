package view;


import java.awt.Font;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import controller.EditoraJdbcDAO;
import controller.EscritorJdbcDAO;
import controller.JdbUtil;
import model.Escritor;
import model.Editora;

public class EscritorView extends JFrame {
	
	JFormattedTextField txtCPF = new JFormattedTextField();
	JLabel cpf = new JLabel("CPF: ");
	
	JTextField txtNome = new JTextField();
	JLabel nome = new JLabel("NOME DO ESCRITOR: ");
	
	JTextField txtEnd = new JTextField();
	JLabel end = new JLabel("ENDEREÇO: ");
	
	JFormattedTextField txtFK = new JFormattedTextField();
	JLabel fk = new JLabel("CNPJ EDITORA");
	
	JTextField txtDel = new JTextField();
	JLabel del = new JLabel ("EXCLUIR ESCRITOR:");
	
	
	JButton btnSalvar = new JButton("Salvar");
	JButton btnDel = new JButton("Excluir");
	
    

	public EscritorView(){
		super("Cadastro Escritor");
		
		try {
				
			MaskFormatter mcpf = new MaskFormatter("###.###.###/##");
			mcpf.setPlaceholderCharacter('0');
			mcpf.install(txtCPF);
			
			MaskFormatter mcnpj = new MaskFormatter("##.###.###/####-##");
			mcnpj.setPlaceholderCharacter('0');
			mcnpj.install(txtFK);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}

		
		Container paine = this.getContentPane();
		
		paine.add(cpf);
		paine.add(txtCPF);
		cpf.setFont(new Font("Arial", Font.PLAIN, 12));
		cpf.setBounds(10, 15, 45, 30);
		txtCPF .setBounds(150, 15, 150, 30);
		
		paine.add(nome);
		paine.add(txtNome);	
		nome.setFont(new Font("Arial", Font.PLAIN, 12));
		nome.setBounds(10, 50, 150,30 );
		txtNome.setBounds(150, 50, 150, 30);	
		
		paine.add(end);
		paine.add(txtEnd);	
		end.setFont(new Font("Arial", Font.PLAIN, 12));
		end.setBounds(10, 85, 150, 30);
		txtEnd.setBounds(150, 85, 150, 30);
		
		paine.add(fk);
		paine.add(txtFK);
		fk.setFont(new Font("Arial", Font.PLAIN, 12));
		fk.setBounds(10, 115, 150, 30);
		txtFK.setBounds(150, 115, 150, 30);
		
		paine.add(del);
		paine.add(txtDel);
		del.setFont(new Font("Arial", Font.PLAIN, 12));
		del.setBounds(350, 15 , 150, 30);
		txtDel.setBounds(350, 45, 150, 30);
	
		
		
	
		paine.add(btnSalvar);
		btnSalvar.setBounds(210, 250, 130, 30);
		btnSalvar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try {
				Connection connection = JdbUtil.getConnection();
				
				EditoraJdbcDAO editoraJdbcDao = new EditoraJdbcDAO(connection);	
				Escritor escritor = new Escritor();
				EscritorJdbcDAO escritorJdbcDao = new EscritorJdbcDAO(connection);
				
				int id = editoraJdbcDao.listarEditora(Integer.parseInt(txtFK.getText()));
				escritor.setNrCnpjEditora(id);
				escritor.setNrCPF(Integer.parseInt(txtCPF.getText()));
				escritor.setNmEscritor(txtNome.getText());
				escritor.setEndEscritor(txtEnd.getText());
				escritorJdbcDao.salvar(escritor);
				
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
					EscritorJdbcDAO escritorJdbcDao = new EscritorJdbcDAO(connection);
					
					escritorJdbcDao.deletar(Integer.parseInt(txtDel.getText()));
					
					
					
				}catch(Exception ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null,"ERRO!");
					
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
	EscritorView escritorView = new EscritorView();
}
}



