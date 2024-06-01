package br.com.estacio.stockproxfinal;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

import br.com.estacio.conexao.Conexao;

public class EstoqueREL {

    public static void main(String[] args) {
        Connection connection = Conexao.getConexao();

        if (connection != null) {
            try (Statement statement = connection.createStatement()) {
                String query = "SELECT ID, IDPROD, VENCIMENTO, QUANTIDADE, ID_LOJA FROM Estoques ";
                ResultSet resultSet = statement.executeQuery(query);

                while (resultSet.next()) {
                    int id = resultSet.getInt("ID");
                    int idProd = resultSet.getInt("IDPROD");
                    String vencimento = resultSet.getString("VENCIMENTO");
                    int quantidade = resultSet.getInt("QUANTIDADE");
                    int idLoja = resultSet.getInt("ID_LOJA");

                    System.out.println(id + "," + idProd + "," + vencimento + "," + quantidade + "," + idLoja);
                }


            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("Falha ao conectar ao banco de dados.");
        }
    }
}