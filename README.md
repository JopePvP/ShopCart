Carrinho de Compras
Este projeto implementa um sistema de carrinho de compras em Java com um banco de dados MySQL para armazenar produtos e itens no carrinho. 
Funcionalidades: 
Adicionar e remover produtos do carrinho. Exibir o valor total do carrinho com base na quantidade e preço dos itens. Atualizar automaticamente o estoque após as compras. 
Requisitos: 
Servidor MySQL. Kit de Desenvolvimento Java (JDK) 8 ou superior. Dependências Java para JDBC. 
Passos para Configuração e Execução:
Clone o Repositório Configure o Banco de Dados MySQL Abra o arquivo ShoppingCartQuery.sql e execute-o no MySQL.
Configuração da Conexão com o Banco de Dados java Copiar código: 
public static final String url = "jdbc:mysql://localhost:3306/shopcart"; 
public static final String user = "seu_usuario";
public static final String password = "sua_senha";

