package br.com.estacio.stockproxfinal;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import br.com.estacio.conexao.Conexao;

public class LojaREL {

    public static void main(String[] args) {
        Connection connection = Conexao.getConexao();

        if (connection != null) {
        	try (Statement statement = connection.createStatement()) {
                String query = "SELECT ID, Nome FROM lojas";
                ResultSet resultSet = statement.executeQuery(query);

                while (resultSet.next()) {
                    int id = resultSet.getInt("ID");
                    String nome = resultSet.getString("Nome");
                    System.out.println(id + "," + nome);
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
