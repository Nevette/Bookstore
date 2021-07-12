CREATE SEQUENCE app_user_id_seq;
CREATE TABLE app_user(
    id integer NOT NULL DEFAULT nextval('app_user_id_seq'::regclass),
    name text NOT NULL,
    email text NOT NULL,
    creation_date timestamp with time zone NOT NULL,
    password text NOT NULL,
    CONSTRAINT app_user_pkey PRIMARY KEY (id)
);
CREATE TABLE app_book(
    isbn integer NOT NULL,
    title text NOT NULL,
    author text NOT NULL,
    release_year integer NOT NULL,
    price double precision NOT NULL,
    CONSTRAINT app_isbn_pkey PRIMARY KEY (isbn)
);