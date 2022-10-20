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

CREATE TABLE
    IF NOT EXISTS public.vendedor(
        id_vendedor serial PRIMARY KEY,
        nome varchar(60),
        data_nascimento date,
        salario numeric
    );

insert into vendedor(nome,data_nascimento,salario) values ('Carlos','2000-05-10',1000);
insert into vendedor(nome,data_nascimento,salario) values ('João','1999-06-11',2000);
insert into vendedor(nome,data_nascimento,salario) values ('Arthur','1998-02-11',3550);
insert into vendedor(nome,data_nascimento,salario) values ('Marcos','2001-02-21',4200);
insert into vendedor(nome,data_nascimento,salario) values ('Adriana','1988-01-22',1000);
insert into vendedor(nome,data_nascimento,salario) values ('Carlos','1974-11-21',2500);
insert into vendedor(nome,data_nascimento,salario) values ('Carlos','1966-08-12',1950);
insert into vendedor(nome,data_nascimento,salario) values ('Yure','1955-02-10',10000);
insert into vendedor(nome,data_nascimento,salario) values ('Ana Beatriz','1969-06-11',2300);
insert into vendedor(nome,data_nascimento,salario) values ('Liliane','1974-11-10',3200);
insert into vendedor(nome,data_nascimento,salario) values ('Liliam','2000-01-22',6500);
insert into vendedor(nome,data_nascimento,salario) values ('Mariana','2001-04-28',2500);
insert into vendedor(nome,data_nascimento,salario) values ('Maria José','1978-02-12',2200);
insert into vendedor(nome,data_nascimento,salario) values ('Carlos André','1976-12-22',2300);
insert into vendedor(nome,data_nascimento,salario) values ('Carlos Arthur','1988-08-12',3800);
insert into vendedor(nome,data_nascimento,salario) values ('Carlos Rodrigues','1989-02-12',2800);
insert into vendedor(nome,data_nascimento,salario) values ('Lucas','2001-05-10',1000);
insert into vendedor(nome,data_nascimento,salario) values ('Roni','2002-05-10',1000);
insert into vendedor(nome,data_nascimento,salario) values ('Reinaldo','2003-06-10',1000);
insert into vendedor(nome,data_nascimento,salario) values ('Silvio','2004-05-10',1000);
insert into vendedor(nome,data_nascimento,salario) values ('Sergio','2000-02-11',1000);
insert into vendedor(nome,data_nascimento,salario) values ('Silas','2000-01-10',2000);
insert into vendedor(nome,data_nascimento,salario) values ('Juarez','1988-05-10',4000);
insert into vendedor(nome,data_nascimento,salario) values ('Flávio','1978-05-10',5000);
insert into vendedor(nome,data_nascimento,salario) values ('Augusto','1977-06-10',10000);
insert into vendedor(nome,data_nascimento,salario) values ('Rômulo','1988-04-10',2900);
insert into vendedor(nome,data_nascimento,salario) values ('Osvaldo','1982-02-10',12000);
insert into vendedor(nome,data_nascimento,salario) values ('Adriana','2000-01-10',1400);
insert into vendedor(nome,data_nascimento,salario) values ('Maiara','2001-03-10',1040);
insert into vendedor(nome,data_nascimento,salario) values ('Paulo','1999-02-10',1850);
insert into vendedor(nome,data_nascimento,salario) values ('Beatriz','1976-01-10',11500);
insert into vendedor(nome,data_nascimento,salario) values ('Laura','1977-03-10',2300);
insert into vendedor(nome,data_nascimento,salario) values ('José Carlos','1974-05-10',2800);
insert into vendedor(nome,data_nascimento,salario) values ('Ronaldo','1973-01-10',4300);
insert into vendedor(nome,data_nascimento,salario) values ('Priscila','1976-02-10',5500);
insert into vendedor(nome,data_nascimento,salario) values ('Leandro','1989-02-10',6800);