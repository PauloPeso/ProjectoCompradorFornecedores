package controle;

import java.util.List;

import dao.DefinirPrecoDao;
import dao.FornecedorDao;
import dao.ProdutoDao;
import modelo.Fornecedor;
import modelo.Preco;
import modelo.Produto;

public class DefinirPrecoController {
    private DefinirPrecoDao precoDao = new DefinirPrecoDao();
    private FornecedorDao fornecedorDao = new FornecedorDao();
    private ProdutoDao produtoDao = new ProdutoDao();
    public void salvarPreco(Preco preco) throws Exception {
        precoDao.salvarPreco(preco);
    }

      public List<Preco> listarPrecos() throws Exception {
        return precoDao.listar();
    }
    
    public List<Fornecedor> listarFornecedores() throws Exception {
        return fornecedorDao.listar();
    }
    
    public List<Produto> listarProdutos() throws Exception {
        return produtoDao.listar();
    }
}
