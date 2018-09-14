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
	public void deletar(int cnpjSelect) throws SQLException {
		String sql = "delete from tb_editora where nrCNPJ ='"+cnpjSelect+"'";		
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
	}
	
	public void alterar(Editora c) {
		String sql = "update tb_editora set nrCNPJ='"+c.getNrCNPJ()+"',nmEditora='"+c.getNmEditora()+"',endEditora='"+c.getEndEditora()+"';";
		System.out.println(sql);
		PreparedStatement prepareStatement;
		try {
			prepareStatement = this.conn.prepareStatement(sql);
			prepareStatement.executeUpdate();
            prepareStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	public int listarEditora(Integer i) {
		String sql = "select * from tb_editora where nrCNPJ = " + i + ";";
		System.out.println(sql);
		int id = 0;
		List<Editora> editora = new ArrayList<Editora>();
		try {
			PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
			ResultSet rs = prepareStatement.executeQuery();
			while (rs.next()) {
				id = rs.getInt("nrCNPJ");
			}
			prepareStatement.close();
		}catch (SQLException e) {
			e.printStackTrace();
			
		}
		return id;
	}	

}
