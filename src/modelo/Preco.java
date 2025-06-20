package modelo;

public class Preco {
    private int id;
    private Produto produto;
    private Fornecedor fornecedor;
    private double preco;
    private int prazoEntrega;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Produto getIdProduto() {
        return produto;
    }
    public void setIdProduto(Produto produto) {
        this.produto = produto;
    }
    public Fornecedor getIdFornecedor() {
        return fornecedor;
    }
    public void setIdFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }
    public double getPreco() {
        return preco;
    }
    
    public void setPreco(double preco) {
        this.preco = preco;
    }
    public int getPrazoEntrega() {
        return prazoEntrega;
    }
    public void setPrazoEntrega(int prazoEntrega) {
        this.prazoEntrega = prazoEntrega;
    }
}
