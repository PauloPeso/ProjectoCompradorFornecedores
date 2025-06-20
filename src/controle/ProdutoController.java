/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

//import dao.ProdutoDao;

import dao.ProdutoDao;
import java.util.List;
import modelo.Produto;


/**
 *
 * @author Gross Weight
 */
public class ProdutoController {
   // private ProdutoDao dao = new ProdutoDao;
    private  ProdutoDao dao = new  ProdutoDao();
    
    public void atualizarProduto(Produto p) throws Exception {
        dao.atualizar(p);
        
    }
    
    public List<Produto> listarFornecedores() throws Exception {
        return dao.listar();
    }
    
}
