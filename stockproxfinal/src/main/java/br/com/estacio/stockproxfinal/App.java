package br.com.estacio.stockproxfinal;

import br.com.estacio.dao.ProdutoDAO;
import br.com.estacio.modelo.Produto;
import br.com.estacio.view.TelaPrincipal;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ProdutoDAO pdao = new ProdutoDAO();
        pdao.excluirProduto(3);
        
    	TelaPrincipal tela = new TelaPrincipal();
    	tela.setVisible(true);
        
        
    }
}
