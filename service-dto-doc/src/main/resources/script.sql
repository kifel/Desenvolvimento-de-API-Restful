CREATE TABLE
    IF NOT EXISTS public.usuario(
        id_usuario SERIAL PRIMARY KEY,
        nome VARCHAR(60),
        email VARCHAR(60),
        senha VARCHAR(255)
    )
CREATE TABLE
    IF NOT EXISTS public.perfil(
        id_perfil SERIAL PRIMARY KEY,
        nome VARCHAR(30)
    )
CREATE TABLE
    IF NOT EXISTS public.usuario_perfil(
        id_usuario INT REFERENCES public.usuario(id_usuario),
        id_perfil INT REFERENCES public.perfil(id_perfil),
        data_criacao DATE,
        CONSTRAINT pk_usuario_perfil PRIMARY KEY (id_usuario, id_perfil)
    )
CREATE TABLE
    IF NOT EXISTS public.endereco(
        id_endereco serial PRIMARY KEY,
        cep varchar(10),
        logradouro varchar(50),
        complemento varchar(30),
        bairro varchar(40),
        localidade varchar(40),
        uf varchar(2),
        ibge int
    )
ALTER TABLE usuario
ADD COLUMN id_endereco bigint,
ADD
    CONSTRAINT fk_id_endereco FOREIGN KEY (id_endereco) REFERENCES endereco(id_endereco)
CREATE TABLE
    IF NOT EXISTS public.foto(
        id_foto serial PRIMARY KEY,
        dados oid,
        tipo varchar(100),
        nome varchar(50),
        id_usuario bigint,
        FOREIGN KEY (id_usuario) REFERENCES usuario (id_usuario)
    );