DROP TABLE IF EXISTS "articles";

CREATE TABLE "articles" (
    "id" text NOT NULL,
    "title" text,
    "body" text,
    "author_id" bigint,
    CONSTRAINT "articles_pkey" PRIMARY KEY ("id")
);