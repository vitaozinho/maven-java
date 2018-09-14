package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Editora;
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
	public void deletar(int cpfSelect) throws SQLException {
		String sql = "delete from tb_escritor where nrCPF='"+cpfSelect+"'";		
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
}
	
	public int listarEscritor(Integer i) {
		String sql = "select * from tb_escritor where nrCPF= " + i + ";";
		System.out.println(sql);
		int cd = 0;
		List<Escritor> escritor = new ArrayList<Escritor>();
		try {
			PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
			ResultSet rs = prepareStatement.executeQuery();
			while (rs.next()) {
				cd = rs.getInt("nrCPF");
			}
			prepareStatement.close();
		}catch (SQLException e) {
			e.printStackTrace();
			
		}
		return cd;
	}	
	
}
