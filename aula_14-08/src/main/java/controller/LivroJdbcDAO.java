package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	public void deletar(int idSelect) throws SQLException {
		String sql = "delete from tb_livros where id='"+idSelect+"'";		
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
}
	
}