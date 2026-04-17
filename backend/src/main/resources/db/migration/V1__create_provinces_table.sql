CREATE TABLE provinces
(
    id UUID NOT NULL,
    name VARCHAR(127) NOT NULL,
    CONSTRAINT pk_provinces PRIMARY KEY (id)
);

ALTER TABLE provinces
    ADD CONSTRAINT uc_provinces_name UNIQUE (name);