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

import controller.EditoraJdbcDAO;
import controller.JdbUtil;
import model.Editora;

public class EditoraView extends JFrame {
	
	JTextField txtCNPJ = new JTextField();
	JLabel cnpj = new JLabel("CNPJ: ");
	
	JTextField txtNome = new JTextField();
	JLabel nome = new JLabel("NOME DA EDITORA: ");
	
	JTextField txtEnd = new JTextField();
	JLabel end = new JLabel("ENDEREÇO: ");
	
	JButton btnSalvar = new JButton("Salvar");

	
    

	public EditoraView(){
		super("Cadastro Editora");
		
		Container paine = this.getContentPane();
		
		paine.add(cnpj);
		paine.add(txtCNPJ);	
		cnpj.setBounds(10, 15, 45, 30);
		txtCNPJ.setBounds(90, 15, 225, 30);
		
		paine.add(nome);
		paine.add(txtNome);	
		nome.setBounds(10, 50, 70, 30);
		txtNome.setBounds(90, 50, 225, 30);	
		
		paine.add(end);
		paine.add(txtEnd);	
		end.setBounds(10, 85, 70, 30);
		txtEnd.setBounds(90, 85, 225, 30);
		
	
		
		
	
		paine.add(btnSalvar);
		btnSalvar.setBounds(250, 250, 130, 30);
		btnSalvar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try {
				Editora editora= new Editora();
				editora.setNrCNPJ(Integer.parseInt(txtCNPJ.getText()));
				editora.setNmEditora(txtNome.getText());
				editora.setEndEditora(txtEnd.getText());
			
				Connection connection = JdbUtil.getConnection();
				EditoraJdbcDAO editoraJdbcDao = new EditoraJdbcDAO(connection);
				
				editoraJdbcDao.salvar(editora);
				
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
	EditoraView editoraView = new EditoraView();
}
}


