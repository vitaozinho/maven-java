package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Editora;
import model.Escritor;
import model.Livro;

public class LivroJdbcDAO {
	
	private Connection conn;

	public LivroJdbcDAO(Connection conn){
		this.conn = conn;
	}
	
	public void salvar(Livro c) throws SQLException {
		String sql = "insert into tb_livros (cdLivro,nmLivro,nrPag,nrCnpjEditora, nrCpfEscritor ) values ('"+c.getCdLivro()+"','"+c.getNmLivro()+"','"+c.getNrPag()+"','"+c.getNrCnpjEditora()+"','"+c.getNrCpfEscritor()+"')";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
}
	public void deletar(int cdSelect) throws SQLException {
		String sql = "delete from tb_livros where cdLivro='"+cdSelect+"'";		
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
}
	
	
	
}
