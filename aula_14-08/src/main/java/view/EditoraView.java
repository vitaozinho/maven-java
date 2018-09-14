package view;

import java.awt.Container;
import java.awt.Font;
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
	
	JTextField txtDel = new JTextField();
	JLabel del = new JLabel ("DELETAR EDITORA");
	
	
	JButton btnSalvar = new JButton("Salvar");
	JButton btnDel = new JButton("Deletar");
	
    

	public EditoraView(){
		super("Cadastro Editora");
		
		Container paine = this.getContentPane();
		
		paine.add(cnpj);
		paine.add(txtCNPJ);	
		cnpj.setFont(new Font("Arial", Font.PLAIN, 12));
		cnpj.setBounds(10, 15, 150, 30);
		txtCNPJ.setBounds(150, 15, 170, 30);
		
		paine.add(nome);
		paine.add(txtNome);	
		nome.setFont(new Font("Arial", Font.PLAIN, 12));
		nome.setBounds(10, 50, 150, 30);
		txtNome.setBounds(150, 50, 170, 30);	
		
		paine.add(end);
		paine.add(txtEnd);	
		end.setFont(new Font("Arial", Font.PLAIN, 12));
		end.setBounds(10, 85, 150, 30);
		txtEnd.setBounds(150, 85, 170, 30);
		
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
		paine.add(btnDel);
		btnDel.setBounds(350, 250, 130, 30);
		btnDel.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					Connection connection = JdbUtil.getConnection();
					EditoraJdbcDAO editoraJdbcDao = new EditoraJdbcDAO(connection);
					
					editoraJdbcDao.deletar(Integer.parseInt(txtCNPJ.getText()));
					
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
	EditoraView editoraView = new EditoraView();
}
}


