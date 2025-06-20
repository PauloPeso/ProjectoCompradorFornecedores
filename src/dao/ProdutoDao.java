/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Produto;

/**
 *
 * @author Gross Weight
 */
public class ProdutoDao {
    // método salvar(CREAT)
    public void salvar(Produto p) throws SQLException{
    String sql = "INSERT INTO produtos (nome, unidade) VALUES (?, ?)";
    
    try(Connection conn = DaoConnect.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)){
        
        stmt.setString(1, p.getNome());
        stmt.setInt(2,p.getQtd());
        stmt.executeUpdate();
       
    } catch (SQLException f ){
        f.printStackTrace();
    }
        
    }
    
    //método listar (READ)
    public List <Produto> listar() throws SQLException{
        List<Produto> lista = new ArrayList<>();
        String sql = "SELECT * FROM produtos";
        
        try(Connection conn = DaoConnect.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()){
            
            while(rs.next()){
                Produto p = new Produto();
                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setQtd(rs.getInt("unidade"));
                lista.add(p);
            }
            
        }
        return lista;
    } 
    //Atualizar (UPDATE)
    public void atualizar(Produto p) throws SQLException {
        String sql = "UPDATE produtos SET nome = ?, unidade = ? WHERE id = ?";

        try (Connection conn = DaoConnect.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, p.getNome());
            stmt.setInt(2, p.getQtd());
            stmt.setInt(3, p.getId());
            stmt.executeUpdate();
        }
    }
    
    //Apagar (DELETE)
     public void excluir(int id) throws SQLException {
        String sql = "DELETE FROM produtos WHERE id = ?";

        try (Connection conn = DaoConnect.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
     
     // READ - buscar por nome
public Produto buscarPorNome(String nome) throws SQLException {
    String sql = "SELECT * FROM produtos WHERE nome = ?";
    Produto p = null;

    try (Connection conn = DaoConnect.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, nome);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            p = new Produto();
            p.setId(rs.getInt("id"));
            p.setNome(rs.getString("nome"));
            p.setQtd(rs.getInt("unidade"));
        }
    }
    return p;
}

public boolean produtoExiste(String nome) throws SQLException {
    String sql = "SELECT 1 FROM produtos WHERE nome = ? LIMIT 1";

    try (Connection conn = DaoConnect.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, nome);
        ResultSet rs = stmt.executeQuery();

        return rs.next(); // se encontrar, retorna true
    }
}

}
