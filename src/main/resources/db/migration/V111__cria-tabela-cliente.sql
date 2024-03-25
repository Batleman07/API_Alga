USE awpag;
CREATE TABLE cliente(
	id BIGINT not NULL AUTO_INCREMENT,
	nome VARCHAR(60) NOT NULL,
	email VARCHAR(255) NOT NULL,
	telefone varchar(20) NOT null,
	PRIMARY KEY (id)
);
ALTER TABLE cliente ADD constraint uk_cliente UNIQUE(email);