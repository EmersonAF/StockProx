package br.com.estacio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.estacio.conexao.Conexao;
import br.com.estacio.modelo.Loja;

public class LojaDAO {
	
	public void cadastrarLoja (Loja loja) {
		
		String sql = "INSERT INTO LOJAS (NOME) VALUES (?)";
				
		PreparedStatement ps = null;
		Connection con = Conexao.getConexao();
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, loja.getNome());
			if(ps.executeUpdate()>0) {
				System.out.println("CADASTRADA COM SUCESSO!!!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	public void alterarLoja(String nome, int id) {
		
		String sql = "UPDATE produtos SET nome = ? WHERE id = ?";
		
		PreparedStatement ps = null;
		Connection con = Conexao.getConexao();
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, nome);
			ps.setInt(2, id);
			if(ps.executeUpdate()>0) {
				System.out.println("ALTERADA COM SUCESSO!!!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	public void excluirLoja(int id) {
		String sql = "DELETE FROM produtos WHERE id = ?";
		
		PreparedStatement ps = null;
		Connection con = Conexao.getConexao();
		
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			if(ps.executeUpdate() > 0) {
				System.out.println("EXCLUÍDA COM SUCESSO!!!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			try {
				if(ps != null) ps.close();
				if(con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}