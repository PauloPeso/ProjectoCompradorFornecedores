/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

/**
 *
 * @author Gross Weight
 */
import dao.FornecedorDao;
import modelo.Fornecedor;
import java.util.List;

public class FornecedorController {
    private FornecedorDao dao = new FornecedorDao();

    public void atualizarFornecedor(Fornecedor f) throws Exception {
        dao.atualizar(f);
    }

    public List<Fornecedor> listarFornecedores() throws Exception {
        return dao.listar();
    }

    
}
