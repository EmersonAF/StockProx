package br.com.estacio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.estacio.conexao.Conexao;
import br.com.estacio.modelo.Estoque;
import br.com.estacio.modelo.Produto;

public class ProdutoDAO {
	
	public static int cadastrarProduto(Produto produto) {
		
		int codigo = 0;
		
		String sql = "INSERT INTO PRODUTOS (NOME) VALUES (?)";
		String sql2 =  "SELECT LAST_INSERT_ID()";
				
		PreparedStatement ps = null;
		Connection con = Conexao.getConexao();
		
		try {
			ps = con.prepareStatement(sql);
			PreparedStatement ps2 = con.prepareStatement(sql2);
			ps.setString(1, produto.getNome());
			if(ps.executeUpdate()>0) {
				System.out.println("CADASTRADO COM SUCESSO!!!");
			}
			
			ResultSet rs = ps2.executeQuery(sql2);
			while(rs.next()) {
				codigo = rs.getInt(1);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return codigo;
	}
	
	public void alterarProduto(String nome, int id) {
		
		String sql = "UPDATE produtos SET nome = ? WHERE id = ?";
		
		PreparedStatement ps = null;
		Connection con = Conexao.getConexao();
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, nome);
			ps.setInt(2, id);
			if(ps.executeUpdate()>0) {
				System.out.println("ALTERADO COM SUCESSO!!!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	public void excluirProduto(int id) {
		String sql = "DELETE FROM produtos WHERE id = ?";
		
		PreparedStatement ps = null;
		Connection con = Conexao.getConexao();
		
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			if(ps.executeUpdate() > 0) {
				System.out.println("EXCLUÍDO COM SUCESSO!!!");
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
