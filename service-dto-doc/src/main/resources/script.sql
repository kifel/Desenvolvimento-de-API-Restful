CREATE TABLE IF NOT EXISTS public.usuario(id_usuario SERIAL PRIMARY KEY,
nome VARCHAR(60), email VARCHAR(60), senha VARCHAR(255));

CREATE TABLE IF NOT EXISTS public.perfil(id_perfil SERIAL PRIMARY KEY, nome VARCHAR(30));

CREATE TABLE IF NOT EXISTS public.usuario_perfil(id_usuario INT REFERENCES public.usuario(id_usuario),
id_perfil INT REFERENCES public.perfil(id_perfil), data_criacao DATE, CONSTRAINT pk_usuario_perfil PRIMARY KEY (id_usuario, id_perfil));