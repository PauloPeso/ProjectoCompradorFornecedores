package dao;
import modelo.Preco;
import modelo.Fornecedor;
import modelo.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class DefinirPrecoDao {
    
    public  void salvarPreco(Preco p) throws SQLException{
        String sql = "INSERT INTO precos (produto_id, fornecedor_id, preco, prazo_entrega) VALUES (?, ?, ?,?)";
        try (Connection conn = DaoConnect.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1,p.getIdProduto().getId());
            stmt.setInt(2,p.getIdFornecedor().getId());
            stmt.setDouble(3,p.getPreco());
            stmt.setInt(4,p.getPrazoEntrega());

            stmt.executeUpdate();
           
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
     
    
    public List<Preco> listar() throws SQLException {
        String sql = "SELECT p.id, p.preco, p.prazo_entrega, " +
                    "pr.id as produto_id, pr.nome as produto_nome, " +
                    "f.id as fornecedor_id, f.nome as fornecedor_nome, f.nif, f.condicoes_pagamento " +
                    "FROM preco p " +
                    "INNER JOIN produto pr ON p.id_produto = pr.id " +
                    "INNER JOIN fornecedor f ON p.id_fornecedor = f.id";
        
        List<Preco> precos = new ArrayList<>();
        
        try (Connection conn = DaoConnect.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                Preco preco = new Preco();
                preco.setId(rs.getInt("id"));
                preco.setPreco(rs.getDouble("preco"));
                preco.setPrazoEntrega(rs.getInt("prazo_entrega"));
                
                // Criar objeto Produto
                Produto produto = new Produto();
                produto.setId(rs.getInt("produto_id"));
                produto.setNome(rs.getString("produto_nome"));
                preco.setIdProduto(produto);
                
                // Criar objeto Fornecedor
                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setId(rs.getInt("fornecedor_id"));
                fornecedor.setNome(rs.getString("fornecedor_nome"));
                fornecedor.setNIF(rs.getString("nif"));
                fornecedor.setEmail(rs.getString("email"));
                preco.setIdFornecedor(fornecedor);
                
                precos.add(preco);
            }
        }
        return precos;
    }


    
}
