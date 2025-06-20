/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Gross Weight
 */
public class Oferta {
    private int id;
    private Produto produto;
    private Fornecedor fornecedor;
    private double preco;
    private int prazoDias;

    public Oferta(int id, Produto produto, Fornecedor fornecedor, double preco, int prazoDias) {
        this.id = id;
        this.produto = produto;
        this.fornecedor = fornecedor;
        this.preco = preco;
        this.prazoDias = prazoDias;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getPrazoDias() {
        return prazoDias;
    }

    public void setPrazoDias(int prazoDias) {
        this.prazoDias = prazoDias;
    }
    
    
    
}
