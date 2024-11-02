import java.sql.Connection;
<<<<<<< HEAD
import java.sql.Connection;

import Dao.EstoqueDao;
import Entidades.Estoque;
=======
>>>>>>> 86654ca82090a0ebcd28a1a624be9a2a437da4e5
import db.DB;

public class Main {
    public static void main(String[] args) {
        Connection conn = DB.getConnection();
<<<<<<< HEAD
        System.out.println("Conectado com sucesso!");

        EstoqueDao estoqueDao = new EstoqueDao(conn);
        Estoque es = new Estoque();  // Crie um objeto Estoque conforme necessário
        estoqueDao.insert(es);

        DB.closeConnection();
    }
}
=======
        System.out.print("Conectado");
        DB.closeConnection();

    }
    }
>>>>>>> 86654ca82090a0ebcd28a1a624be9a2a437da4e5
