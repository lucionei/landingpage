CREATE DATABASE cursobetha
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Portuguese_Brazil.1252'
    LC_CTYPE = 'Portuguese_Brazil.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;


CREATE TABLE public.contatos
(
    id_contato integer NOT NULL,
    nome character varying(200) COLLATE pg_catalog."default" NOT NULL,
    email character varying(200) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT contatos_pkey PRIMARY KEY (id_contato)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.contatos
    OWNER to postgres;

CREATE SEQUENCE public.seq_contatos
    INCREMENT 1
    START 15
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.seq_contatos
    OWNER TO postgres;