package Dao;
import Entidades.Estoque;
import db.DbException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EstoqueDao {
    private Connection conn;
    public EstoqueDao(Connection conn) {
        this.conn = conn;
    }
    public void insert(Estoque obj) {
        PreparedStatement st = null;
        try{
            String nome[] = {"Batman o cavaleiro das trevas", "Sherek 2", "Breakin bad completo dublado",
                    "Linkin Park hybrid theory", "Metallica Master of puppets", "The boys"};
            String categorias[] = {"DvD", "DvD", "Serie", "CD", "CD", "Serie"};
            double preco[] = {25.00, 50.00, 100.00, 50.00, 70.00, 15.00};
            int quantidade[] = {10, 15, 1, 3, 5, 70};
            int rowsaffect = 0;
            for (int i = 0; i < nome.length; i++) {
                st = conn.prepareStatement("INSERT INTO estoque (nome_produto, categoria_produto, preco_unitario, quantidade_disponivel) VALUES (?,?,?,?)");
                st.setString (1,nome[i]);
                st.setString (2,categorias[i]);
                st.setDouble (3,preco[i]);
                st.setInt (4,quantidade[i]);
                rowsaffect += st.executeUpdate();
            }
            if (rowsaffect > 0) {
                System.out.println("registro realizado!");
            }
        }
catch (SQLException e) {throw new DbException(e.getMessage());}
    }
}
