CREATE DATABASE shopcart;
USE shopcart;

CREATE TABLE produtos (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome_produto VARCHAR(30) NOT NULL,
    categoria_produto VARCHAR(50),
    valor FLOAT(10),
    quantidade INT NOT NULL,
    valor_total FLOAT(10) AS (quantidade * valor) STORED
);

CREATE TABLE estoque (
    id_estoque INT PRIMARY KEY AUTO_INCREMENT,
    nome_produto VARCHAR(30) NOT NULL,
    categoria_produto VARCHAR(50),
    preco_unitario FLOAT(10),
    quantidade_disponivel INT
);


SELECT * FROM estoque;
SELECT * FROM produtos;