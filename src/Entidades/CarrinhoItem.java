package Entidades;

public class CarrinhoItem {

        private Estoque produto;
        private int quantidade;

        public CarrinhoItem(Estoque produto, int quantidade) {
            this.produto = produto;
            this.quantidade = quantidade;
        }

        public Estoque getProduto() {
            return produto;
        }

        public int getQuantidade() {
            return quantidade;
        }

        public double getPrecoTotal() {
            return produto.getPreco_unitario() * quantidade;
        }
    }
