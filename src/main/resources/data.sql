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

-- ROLLBACK transaction;