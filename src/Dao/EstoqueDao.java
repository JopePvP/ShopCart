package Dao;

import Entidades.Estoque;
import db.DbException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EstoqueDao {
    private Connection conn;

    public EstoqueDao(Connection conn) {
        this.conn = conn;
    }

    public void insert(Estoque produto) {
        try {
            PreparedStatement st = conn.prepareStatement(
                    "INSERT INTO estoque (nome_produto, categoria_produto, preco_unitario, quantidade_disponivel) VALUES (?, ?, ?, ?)");
            st.setString(1, produto.getNome_produto());
            st.setString(2, produto.getCategoria_produto());
            st.setDouble(3, produto.getPreco_unitario());
            st.setInt(4, produto.getQuantidade());
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    public void populateEstoque() {
        Estoque[] produtos = new Estoque[] {
                new Estoque(0, 10, "Devil may cry", "Jogos", 29.99),
                new Estoque(0, 20, "The witcher 3", "Jogos", 19.99),
                new Estoque(0, 15, "Breaking bad", "Series", 39.99),
                new Estoque(0, 30, "The boys", "Series", 49.99),
                new Estoque(0, 25, "A mumia", "Filmes", 59.99),
                new Estoque(0, 5, "A floresta", "Filmes", 9.99)
        };

        for (Estoque produto : produtos) {
            insert(produto);
        }
    }
    public void insertIntoProdutos(Estoque produto, int quantidade) {
        try {
            PreparedStatement st = conn.prepareStatement(
                    "INSERT INTO produtos (nome_produto, categoria_produto, valor, quantidade) VALUES (?, ?, ?, ?)");
            st.setString(1, produto.getNome_produto());
            st.setString(2, produto.getCategoria_produto());
            st.setDouble(3, produto.getPreco_unitario());
            st.setInt(4, quantidade);
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    // Método para atualizar o estoque após adicionar ao carrinho
    public void updateEstoque(int id, int novaQuantidade) {
        try {
            PreparedStatement st = conn.prepareStatement(
                    "UPDATE estoque SET quantidade_disponivel = ? WHERE id_estoque = ?");
            st.setInt(1, novaQuantidade);
            st.setInt(2, id);
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    public List<Estoque> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;
        List<Estoque> lista = new ArrayList<>();
        try {
            st = conn.prepareStatement("SELECT * FROM estoque");
            rs = st.executeQuery();

            while (rs.next()) {
                Estoque estoque = new Estoque();
                estoque.setId(rs.getInt("id_estoque"));
                estoque.setNome_produto(rs.getString("nome_produto"));
                estoque.setCategoria_produto(rs.getString("categoria_produto"));
                estoque.setPreco_unitario(rs.getDouble("preco_unitario"));
                estoque.setQuantidade(rs.getInt("quantidade_disponivel"));
                lista.add(estoque);
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (st != null) st.close();
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
        return lista;
    }

    public void deleteAll() {

    }

    public void update(Estoque obj) {

    }

    public Estoque findById(int id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement("SELECT * FROM estoque WHERE id_estoque = ?");
            st.setInt(1, id);
            rs = st.executeQuery();
            if (rs.next()) {
                Estoque estoque = new Estoque();
                estoque.setId(rs.getInt("id_estoque"));
                estoque.setNome_produto(rs.getString("nome_produto"));
                estoque.setCategoria_produto(rs.getString("categoria_produto"));
                estoque.setPreco_unitario(rs.getDouble("preco_unitario"));
                estoque.setQuantidade(rs.getInt("quantidade_disponivel"));
                return estoque;
            }
            return null;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (st != null) st.close();
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }
}
