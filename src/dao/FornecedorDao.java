package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Fornecedor;
import modelo.Produto;

public class FornecedorDao {
    public void salvar(Fornecedor f) {
        String sql = "INSERT INTO fornecedores (nome, nif, condicoes_pagamento) VALUES (?, ?, ?)";
        try (Connection conn = DaoConnect.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, f.getNome());
            stmt.setString(2, f.getNIF());
            stmt.setString(3, f.getEmail());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    } 
    //listar fornecedores
    public List<Fornecedor> listar() {
        List<Fornecedor> lista = new ArrayList<>();
        String sql = "SELECT * FROM fornecedores";

        try (Connection conn = DaoConnect.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Fornecedor f = new Fornecedor();
                f.setId(rs.getInt("id"));
                f.setNome(rs.getString("nome"));
                f.setNIF(rs.getString("NIF"));
                f.setEmail(rs.getString("condicoes_pagamento"));
                lista.add(f);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    } 
    
    //delete fornecedor
    public void excluir(int id) {
        String sql = "DELETE FROM fornecedores WHERE id=?";
        try (Connection conn = DaoConnect.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //atualizar fornecedor
     public void atualizar(Fornecedor f) {
        String sql = "UPDATE fornecedores SET nome=?, nif=?, condicoes_pagamento=? WHERE id=?";
        try (Connection conn = DaoConnect.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, f.getNome());
            stmt.setString(2, f.getNIF());
            stmt.setString(3, f.getEmail());
            stmt.setInt(4, f.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //verificar se fornecedor existe
    public boolean VerificaNIF(String nif){
        String Sql = "SELECT * FROM fornecedores WHERE nif=?";
        try {
            Connection conn = DaoConnect.getConnection();
            PreparedStatement stmt =conn.prepareStatement(Sql);
            stmt.setString(1, Sql);
            ResultSet rs = stmt.executeQuery();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return false;
        }
        return true;

    }

    //buscar fornecedor
    public Fornecedor BuscarFornecedor(String nome) throws SQLException{
        String sql = "SELECT * FROM fornecedores WHERE nome=? ";

        Fornecedor fc = null;
        try {
            Connection conexao = DaoConnect.getConnection();
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet result = stmt.executeQuery();
            if (result.next()) {
                fc = new Fornecedor();
                fc.setId(result.getInt("id"));
                fc.setNome(result.getString("nome"));
                fc.setEmail(result.getString("email"));
                
            }
           
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();

        }
        return fc;
        

    }
    
    
    
    
}
