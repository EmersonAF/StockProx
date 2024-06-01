package br.com.estacio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.estacio.conexao.Conexao;
import br.com.estacio.modelo.Estoque;
import br.com.estacio.modelo.Produto;

public class EstoqueDAO {
	
	public void cadastrarEstoque(Estoque e, Produto p) {
		
		String sql = "INSERT INTO estoques (idprod, vencimento, quantidade, id_loja) VALUES (?,?,?,?)";
		
		PreparedStatement ps = null;
		Connection con = Conexao.getConexao();
		
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, ProdutoDAO.cadastrarProduto(p));
			ps.setString(2, e.getVencimento());
			ps.setInt(3, e.getQuantidade());
			ps.setInt(4, e.getIdLoja());
			if(ps.executeUpdate()>0) {
				System.out.println("CADASTRADO COM SUCESSO!!!");
			}
			
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			System.out.println(e1.getMessage());
		}
		
		
		
	}

}
