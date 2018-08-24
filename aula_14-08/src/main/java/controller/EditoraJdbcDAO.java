package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Editora;

public class EditoraJdbcDAO {
	
	private Connection conn;

	public EditoraJdbcDAO(Connection conn){
		this.conn = conn;
	}
	
	public void salvar(Editora c) throws SQLException {
		String sql = "insert into tb_editora (nrCNPJ,nmEditora,endEditora) values ('"+c.getNrCNPJ()+"','"+c.getNmEditora()+"','"+c.getEndEditora()+"')";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
}
	public void deletar(int idSelect) throws SQLException {
		String sql = "delete from tb_editora where id='"+idSelect+"'";		
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
	}

}
