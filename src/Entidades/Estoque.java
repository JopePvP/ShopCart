package Entidades;

public class Estoque {
    int id, quantidade;
    String nome_produto, categoria_produto;
    double preco_unitario;

    public Estoque(int id, int quantidade, String nome_produto, String categoria_produto, double preco_unitario) {
        this.id = id;
        this.quantidade = quantidade;
        this.nome_produto = nome_produto;
        this.categoria_produto = categoria_produto;
        this.preco_unitario = preco_unitario;
    }

    public Estoque() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getNome_produto() {
        return nome_produto;
    }

    public void setNome_produto(String nome_produto) {
        this.nome_produto = nome_produto;
    }

    public String getCategoria_produto() {
        return categoria_produto;
    }

    public void setCategoria_produto(String categoria_produto) {
        this.categoria_produto = categoria_produto;
    }

    public double getPreco_unitario() {
        return preco_unitario;
    }

    public void setPreco_unitario(double preco_unitario) {
        this.preco_unitario = preco_unitario;
    }
}
