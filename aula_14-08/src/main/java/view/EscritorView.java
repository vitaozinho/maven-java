package view;



import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import controller.EscritorJdbcDAO;
import controller.JdbUtil;
import model.Escritor;

public class EscritorView extends JFrame {
	
	JTextField txtCPF = new JTextField();
	JLabel cpf = new JLabel("CPF: ");
	
	JTextField txtNome = new JTextField();
	JLabel nome = new JLabel("NOME DO ESCRITOR: ");
	
	JTextField txtEnd = new JTextField();
	JLabel end = new JLabel("ENDEREÇO: ");
	
	JTextField txtFK = new JTextField();
	JLabel fk = new JLabel("CNPJ EDITORA");
	
	JButton btnSalvar = new JButton("Salvar");

	
    

	public EscritorView(){
		super("Cadastro Escritor");
		
		Container paine = this.getContentPane();
		
		paine.add(cpf);
		paine.add(txtCPF);	
		cpf.setBounds(10, 15, 45, 30);
		txtCPF .setBounds(90, 15, 225, 30);
		
		paine.add(nome);
		paine.add(txtNome);	
		nome.setBounds(10, 50, 70, 30);
		txtNome.setBounds(90, 50, 225, 30);	
		
		paine.add(end);
		paine.add(txtEnd);	
		end.setBounds(10, 85, 70, 30);
		txtEnd.setBounds(90, 85, 225, 30);
		
		paine.add(fk);
		paine.add(txtFK);
		fk.setBounds(10, 115, 70, 30);
		txtFK.setBounds(90, 115, 225, 30);
	
		
		
	
		paine.add(btnSalvar);
		btnSalvar.setBounds(250, 250, 130, 30);
		btnSalvar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try {
				Escritor escritor = new Escritor();
				escritor.setNrCPF(Integer.parseInt(txtCPF.getText()));
				escritor.setNmEscritor(txtNome.getText());
				escritor.setEndEscritor(txtEnd.getText());
				escritor.setNrCnpjEditora(Integer.parseInt(txtFK.getText()));
			
				Connection connection = JdbUtil.getConnection();
				EscritorJdbcDAO escritorJdbcDao = new EscritorJdbcDAO(connection);
				
				escritorJdbcDao.salvar(escritor);
				
				}catch(Exception ex) {
					ex.printStackTrace();
				}
			}
		
		
	});
	
	this.setLayout(null);
	this.setVisible(true);
	this.setSize(600, 330);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
}
public static void main( String[] args )
{
	EscritorView escritorView = new EscritorView();
}
}



