DROP TABLE IF EXISTS "users";
DROP SEQUENCE IF EXISTS users_id_seq;
CREATE SEQUENCE users_id_seq INCREMENT 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1;

CREATE TABLE "users" (
                           "id" bigint DEFAULT nextval('users_id_seq') NOT NULL,
                           "userName" text,
                           "email" text,
                           "age" integer,
                           CONSTRAINT "users_pkey" PRIMARY KEY ("id")
);
INSERT INTO "users" ("email", "userName", "age")
VALUES ('user0@email.com', 'Abigail Rose', 80);