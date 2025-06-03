CREATE TABLE mission (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255),
    duracao INT NOT NULL
);
CREATE TABLE cadastro_usuario(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255),
    email VARCHAR(255),
    idade INT,
    missoes_id BIGINT,
    CONSTRAINT qualquer_nome FOREIGN KEY (missoes_id) REFERENCES mission(id)
)