create database EstudioCinema;

create table EstudioCinema.usuarios (
  id BIGINT NOT NULL AUTO_INCREMENT,
  login VARCHAR(255),
  senha VARCHAR(255),
  status VARCHAR(255),
  tipo VARCHAR(255),
  primary key (id));
  
create table EstudioCinema.estudioCinema (
  id BIGINT NOT NULL AUTO_INCREMENT,
  idF BIGINT NOT NULL,
  idD BIGINT NOT NULL,
  idR BIGINT NOT NULL,
  nome VARCHAR(255),
  dataCriacao VARCHAR(255),
  primary key (id));

create table EstudioCinema.diretores (
  id BIGINT NOT NULL AUTO_INCREMENT,
  idF BIGINT NOT NULL,
  nome VARCHAR(255),
  formacao VARCHAR(255),
  qtdFilmes VARCHAR(255),
  primary key (id));

create table EstudioCinema.roteiristas (
  id BIGINT NOT NULL AUTO_INCREMENT,
  idF BIGINT NOT NULL,
  nome VARCHAR(255),
  formacao VARCHAR(255),
  qtdFilmes VARCHAR(255),
  primary key (id));

create table EstudioCinema.filmes (
  id BIGINT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(255),
  genero VARCHAR(255),
  tramaPrincipal VARCHAR(255),
  anoLanc VARCHAR(255),
  descri VARCHAR(255),
  primary key (id));

create table EstudioCinema.diretorFilme (
  id BIGINT NOT NULL AUTO_INCREMENT,
  idD BIGINT NOT NULL,
  idF BIGINT NOT NULL,
  cinematografia VARCHAR(255),
  primary key (id));

create table EstudioCinema.roteiristaFilme (
  id BIGINT NOT NULL AUTO_INCREMENT,
  idR BIGINT NOT NULL,
  idF BIGINT NOT NULL,
  tituloRoteiro VARCHAR(255),
  primary key (id));

INSERT INTO `EstudioCinema`.`usuarios` (`login`, `senha`, `status`, `tipo`) VALUES ('yas', '123456', 'ATIVO', 'ADM');

INSERT INTO `EstudioCinema`.`usuarios` (`login`, `senha`, `status`, `tipo`) VALUES ('oi', '12', 'ATIVO', 'VISITANTE');

ALTER TABLE EstudioCinema.estudioCinema ADD CONSTRAINT FK_FIL_CIN_ID FOREIGN KEY (IDF) REFERENCES EstudioCinema.FILMES (ID);
ALTER TABLE EstudioCinema.estudioCinema ADD CONSTRAINT FK_DIR_CIN_ID FOREIGN KEY (IDD) REFERENCES EstudioCinema.DIRETORES (ID);  

ALTER TABLE EstudioCinema.estudioCinema ADD CONSTRAINT FK_ROT_CIN_ID FOREIGN KEY (IDR) REFERENCES EstudioCinema.ROTEIRISTAS (ID);

ALTER TABLE EstudioCinema.diretores ADD CONSTRAINT FK_FIL_DIR_ID FOREIGN KEY (IDF) REFERENCES EstudioCinema.FILMES (ID);

ALTER TABLE EstudioCinema.roteiristas ADD CONSTRAINT FK_FIL_ROT_ID FOREIGN KEY (IDF) REFERENCES EstudioCinema.FILMES (ID);

ALTER TABLE EstudioCinema.diretorFilme ADD CONSTRAINT FK_DIR_FILM_ID FOREIGN KEY (IDD) REFERENCES EstudioCinema.DIRETORES (ID);  
ALTER TABLE EstudioCinema.diretorFilme  ADD CONSTRAINT FK_FILM_DIR_ID FOREIGN KEY (IDF) REFERENCES EstudioCinema.FILMES (ID);  

ALTER TABLE EstudioCinema.roteiristaFilme ADD CONSTRAINT FK_ROT_FILM_ID FOREIGN KEY (IDR) REFERENCES EstudioCinema.ROTEIRISTAS (ID);  
ALTER TABLE EstudioCinema.roteiristaFilme ADD CONSTRAINT FK_FILM_ROT_ID FOREIGN KEY (IDF) REFERENCES EstudioCinema.FILMES (ID);
