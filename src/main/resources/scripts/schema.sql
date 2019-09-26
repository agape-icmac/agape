CREATE TABLE public.tb_categoria_usuario (
    id_categoria_usuario bigserial NOT NULL,
    categoria_usuario varchar(20) NOT NULL,
    CONSTRAINT tb_categoria_usuario_categoria_un UNIQUE (categoria_usuario),
    CONSTRAINT tb_categoria_usuario_id_categoria_usuario_pk PRIMARY KEY (id_categoria_usuario)
);

CREATE TABLE public.tb_estado (
    id_estado bigserial NOT NULL,
    estado varchar(50) NOT NULL,
    uf varchar(2) NOT NULL,
    CONSTRAINT tb_estado_id_estado_pk PRIMARY KEY (id_estado),
    CONSTRAINT tb_estado_id_estado_un UNIQUE (id_estado)
);


CREATE TABLE public.tb_perfil_cliente (
    id_perfil_cliente bigserial NOT NULL,
    perfil_cliente varchar(20) NOT NULL,
    CONSTRAINT tb_perfil_cliente_id_perfil_pk PRIMARY KEY (id_perfil_cliente),
    CONSTRAINT tb_perfil_cliente_perfil_cliente_un UNIQUE (perfil_cliente)
);

CREATE TABLE public.tb_loja (
    id_loja bigserial NOT NULL,
    cnpj_loja int8 NOT NULL,
    nome_loja varchar(150) NOT NULL,
    telefone_loja int8 NULL,
    email_loja varchar(255) NULL,
    municipio_loja varchar(250) NULL,
    id_estado int8 NULL,
    cep_loja int8 NULL,
    endereco_loja varchar(250) NULL,
    CONSTRAINT tb_loja_cnpj_loja_un UNIQUE (cnpj_loja),
    CONSTRAINT tb_loja_id_loja_pk PRIMARY KEY (id_loja),
    CONSTRAINT tb_loja_id_estado_fk FOREIGN KEY (id_estado) REFERENCES tb_estado(id_estado) ON UPDATE CASCADE ON DELETE SET NULL
);

CREATE TABLE public.tb_usuario (
    id_usuario bigserial NOT NULL,
    cpf varchar(14) NOT NULL,
    id_categoria_usuario int8 NOT NULL,
    nome_usuario varchar(70) NOT NULL,
    email_usuario varchar(100) NOT NULL,
    cep_usuario int8 NULL,
    endereco_usuario varchar(50) NULL,
    telefone_usuario int8 NULL,
    senha_usuario varchar(50) NULL,
    id_perfil_cliente int8 NULL,
    municipio_usuario varchar NULL,
    id_estado int8 NULL,
    CONSTRAINT tb_usuario_id_usuario_pk PRIMARY KEY (id_usuario),
    CONSTRAINT tb_usuario_cpf_un UNIQUE (cpf),
    CONSTRAINT tb_usuario_id_categoria_usuario_fk FOREIGN KEY (id_categoria_usuario) REFERENCES tb_categoria_usuario(id_categoria_usuario) ON UPDATE CASCADE ON DELETE SET NULL,
    CONSTRAINT tb_usuario_id_estado_fk FOREIGN KEY (id_estado) REFERENCES tb_estado(id_estado) ON UPDATE CASCADE ON DELETE SET NULL,
    CONSTRAINT tb_usuario_id_perfil_cliente_fk FOREIGN KEY (id_perfil_cliente) REFERENCES tb_perfil_cliente(id_perfil_cliente) ON UPDATE CASCADE ON DELETE SET NULL
);

CREATE TABLE public.tb_indicacao_produto (
    id_indicacao bigserial NOT NULL,
    nome_produto varchar(50) NOT NULL,
    categoria_produto varchar(25) NOT NULL,
    valor_produto numeric(2) NOT NULL,
    url_produto varchar NOT NULL,
    id_usuario int8 NOT NULL,
    dt_indicacao date NOT NULL,
    id_loja int8 NOT NULL,
    CONSTRAINT tb_indicacao_id_indicacao_id_usuario_dt_indicacao_pk PRIMARY KEY (id_indicacao, id_usuario, dt_indicacao),
    CONSTRAINT tb_indicacao_produto_un UNIQUE (id_indicacao),
    CONSTRAINT tb_indicacao_produto_id_loja_fk FOREIGN KEY (id_loja) REFERENCES tb_loja(id_loja),
    CONSTRAINT tb_usuario_id_usuario_fk FOREIGN KEY (id_usuario) REFERENCES tb_usuario(id_usuario)
);

CREATE TABLE public.tb_log_comunicacao (
    id_log_comunicacao bigserial NOT NULL,
    id_usuario int8 NOT NULL,
    dt_comunicacao date NOT NULL,
    mensagem varchar(250) NULL,
    CONSTRAINT tb_log_comunicacao_id_log_comunicacao_un UNIQUE (id_log_comunicacao),
    CONSTRAINT tb_log_id_log_id_usuario_dt_comunicacao_pk PRIMARY KEY (id_log_comunicacao, id_usuario, dt_comunicacao),
    CONSTRAINT tb_log_id_usuario_fk FOREIGN KEY (id_usuario) REFERENCES tb_usuario(id_usuario)
);

CREATE TABLE public.tb_feedback (
    id_feedback bigserial NOT NULL,
    id_indicacao int8 NOT NULL,
    dt_feedback date NOT NULL,
    mensagem varchar(250) NOT NULL,
    CONSTRAINT tb_feedback_id_feedback_un UNIQUE (id_feedback),
    CONSTRAINT tb_feedback_id_indicacao_id_feedback_pk PRIMARY KEY (id_indicacao, id_feedback),
    CONSTRAINT tb_feedback_id_indicacao_fk FOREIGN KEY (id_indicacao) REFERENCES tb_indicacao_produto(id_indicacao)
);