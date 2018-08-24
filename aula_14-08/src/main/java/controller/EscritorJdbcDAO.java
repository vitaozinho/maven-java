package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Escritor;

public class EscritorJdbcDAO {
	
	private Connection conn;

	public EscritorJdbcDAO(Connection conn){
		this.conn = conn;
	}
	
	public void salvar(Escritor c) throws SQLException {
		String sql = "insert into tb_escritor (nrCPF, nmEscritor,endEscritor,nrCnpjEditora) values ('"+c.getNrCPF()+"','"+c.getNmEscritor()+"','"+c.getEndEscritor()+"','"+c.getNrCnpjEditora()+"')";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
}
	public void deletar(int idSelect) throws SQLException {
		String sql = "delete from tb_escritor where id='"+idSelect+"'";		
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
}

}
