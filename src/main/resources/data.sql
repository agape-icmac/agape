--###  SCRIPT DE CARGA DO SCHEMA meu_banco ###
------------------------------------------------------------------------------
/*===============================================================*/
/* dbms name:      postgresql 9.x                                */
/* created on:     17/09/2019                                    */
/* author:         RENATA                                        */
/*===============================================================*/
-- set statement_timeout = 0;
-- set client_encoding = 'utf8';
-- set standard_conforming_strings = on;
-- set check_function_bodies = false;
-- set client_min_messages = warning;
-- set default_tablespace = '';
-- set default_with_oids = false;
--
-- set search_path = meu_banco, public, pg_catalog;

-- BEGIN transaction;

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- Table: tb_cargo_discipulo

INSERT INTO tb_cargo_discipulo(
             str_descricao_cargo)

    VALUES ('Pastoral'),
	       ('Tesoureiro'),
		   ('Líder de ministerio');

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- Table: tb_estado_civil

	INSERT INTO tb_estado_civil(str_descricao_estciv)

    VALUES ('Solteiro (a)'),
	       ('Casado (a)'),
		   ('Separado (a)'),
		   ('Divorciado (a)'),
		   ('Viúvo (a)');

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- Table: tb_ministerio

	INSERT INTO tb_ministerio (str_descricao_mins)

    VALUES ('Baby'),
           ('Pré adolecente'),
           ('Jovens'),
           ('Mulheres'),
           ('Homens'),
           ('Casais'),
           ('Diaconia'),
           ('Tesouraria'),
           ('Ornamentação'),
           ('Dança'),
           ('Louvor'),
           ('Secretária'),
           ('Intercessão');

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- Table: tb_pais

	INSERT INTO tb_pais (str_nome_pais)

	VALUES  ('NÃO INFORMADO'),
			('BRASILEIRO'),
			('NATURALIZADO BRASILEIRO'),
			('ARGENTINO'),
			('BOLIVIANO'),
			('CHILENO'),
			('PARAGUAIO'),
			('URUGUAIO'),
			('ALEMAO'),
			('BELGA'),
			('BRITANICO'),
			('CANADENSE'),
			('ESPANHOL'),
			('NORTE-AMERICANO (EUA)'),
			('FRANCES'),
			('SUICO'),
			('ITALIANO'),
			('JAPONES'),
			('CHINES'),
			('COREANO'),
			('PORTUGUES'),
			('OUTROS LATINO-AMERICANOS'),
			('OUTROS ASIATICOS'),
			('OUTROS');

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- Table: tb_nivel_escolaridade

	INSERT INTO tb_nivel_escolaridade (str_descricao_nivesc)

    VALUES ('NÃO INFORMADO'),
           ('Analfabeto'),
           ('Alfatetizado sem cursos regulares'),
           ('Ensino fundamental incompleto (1 a 4 - incompleto)'),
           ('Ensino fundamental incompleto (1 a 4 - completo'),
           ('Ensino fundamental incompleto (5 a 8 - incompleto'),
           ('Ensino fundamental incompleto (5 a 8 - completo'),
           ('Ensino medio incompleto'),
           ('Ensino medio completo'),
	       ('Ensino superior incompleto'),
	       ('Graduação - Ensino superior completo'),
	       ('Especializacao'),
	       ('Mestrado'),
	       ('Doutorado'),
	       ('Pos-Doutorado'),
	       ('Doutorado Incompleto');

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- Table: tb_nacionalidade

	INSERT INTO tb_nacionalidade (str_descricao_nacion, cod_pais)

    VALUES 	('NÃO INFORMADA',1),
		    ('BRASILEIRO' ,2),
		    ('BRASILEIRO NATURALIZADO',3),
		    ('OUTROS', 24);

INSERT INTO tb_batismo(
            cod_batismo, dat_batismo, str_local_batismo, str_nome_igreja_batismo)

    VALUES 	(1,'2018-01-01','Santa Maria' ,'Igreja de Cristo Rocha Eterna'),
		        (2,'2019-02-02','Santa Maria' ,'igreja de Cristo Missão por amor a Cristo'),
		        (3,'2019-03-03','Gama' ,'Igreja de Cristo Novo Tempo'),
		        (4,'2019-04-04','Guara','Casa da Benção' );

INSERT INTO tb_curso(
            cod_curso, str_nome_curso, str_dsc_curso)

    VALUES      (1,'Escola de aguias' ,'Curso para otimizar o desempenho dos lideres'),
                        (2,'Escola de Lideres' ,'Formação de lideres igreja ICMAC'),
                        (3,'Escola da transformação' ,'Escola para transformação pessoal e ministerial');

INSERT INTO tb_despesa(
            cod_despesa, num_valor_despesa, dat_despesa, str_descricao_despesa,
            cod_ministerio)
    VALUES  (1,2000,'2019-03-04','Aluguel',8),
			(2,2000,'2019-04-04','Aluguel',8),
			(3,20,'2019-04-04','lanche para ministerio jovens',3),
			(4,30,'2019-04-10','Aluguel',1);

-- ROLLBACK transaction;