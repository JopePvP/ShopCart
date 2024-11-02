import java.sql.Connection;
import java.sql.Connection;

import Dao.EstoqueDao;
import Entidades.Estoque;
import db.DB;

public class Main {
    public static void main(String[] args) {
        Connection conn = DB.getConnection();
        System.out.println("Conectado com sucesso!");

        EstoqueDao estoqueDao = new EstoqueDao(conn);
        Estoque es = new Estoque();  // Crie um objeto Estoque conforme necessário
        estoqueDao.insert(es);

        DB.closeConnection();
    }
}
