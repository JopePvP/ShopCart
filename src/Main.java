import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Dao.EstoqueDao;
import Entidades.Estoque;
import Entidades.CarrinhoItem;
import db.DB;

public class Main {
    public static void main(String[] args) {
        Connection conn = DB.getConnection();
        EstoqueDao estoqueDao = new EstoqueDao(conn);

        estoqueDao.populateEstoque();

        System.out.println("\nProdutos disponíveis no estoque:");
        List<Estoque> todosProdutos = estoqueDao.findAll();
        for (Estoque produto : todosProdutos) {
            System.out.println("ID: " + produto.getId() +
                    ", Nome: " + produto.getNome_produto() +
                    ", Categoria: " + produto.getCategoria_produto() +
                    ", Preço: " + produto.getPreco_unitario() +
                    ", Quantidade: " + produto.getQuantidade());
        }

        List<CarrinhoItem> carrinho = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String continuar;
        double totalCarrinho = 0;

        do {
            System.out.print("\nDigite o ID do produto que você deseja adicionar ao carrinho: ");
            int idParaBuscar = scanner.nextInt();

            Estoque itemEncontrado = estoqueDao.findById(idParaBuscar);

            if (itemEncontrado != null) {
                System.out.println("Produto encontrado: " + itemEncontrado.getNome_produto());
                System.out.print("Digite a quantidade desejada: ");
                int quantidade = scanner.nextInt();

                if (quantidade > itemEncontrado.getQuantidade()) {
                    System.out.println("Quantidade indisponível. Estoque atual: " + itemEncontrado.getQuantidade());
                } else {

                    CarrinhoItem carrinhoItem = new CarrinhoItem(itemEncontrado, quantidade);
                    carrinho.add(carrinhoItem);
                    System.out.println("Item adicionado ao carrinho.");

                    estoqueDao.insertIntoProdutos(itemEncontrado, quantidade);

                    int novaQuantidade = itemEncontrado.getQuantidade() - quantidade;
                    estoqueDao.updateEstoque(itemEncontrado.getId(), novaQuantidade);
                    System.out.println("Estoque atualizado. Quantidade restante de " + itemEncontrado.getNome_produto() + ": " + novaQuantidade);

                    totalCarrinho += carrinhoItem.getPrecoTotal();
                }
            } else {
                System.out.println("Nenhum produto encontrado com o ID: " + idParaBuscar);
            }

            System.out.print("Deseja adicionar mais itens ao carrinho? (s/n): ");
            continuar = scanner.next();
        } while (continuar.equalsIgnoreCase("s"));

        System.out.println("\nItens no carrinho:");
        for (CarrinhoItem item : carrinho) {
            double precoTotal = item.getPrecoTotal();
            System.out.println("Produto: " + item.getProduto().getNome_produto() +
                    ", Quantidade: " + item.getQuantidade() +
                    ", Preço unitário: " + item.getProduto().getPreco_unitario() +
                    ", Preço total: " + precoTotal);
        }

        System.out.println("\nTotal do carrinho: " + totalCarrinho);

        scanner.close();
        DB.closeConnection();
    }
}
