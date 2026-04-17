CREATE TABLE departments
(
    id UUID NOT NULL,
    created_at  TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    updated_at  TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    code        VARCHAR(64)   NOT NULL,
    name        VARCHAR(1024) NOT NULL,
    description VARCHAR(4096) NOT NULL,
    CONSTRAINT pk_departments PRIMARY KEY (id)
);

ALTER TABLE departments
    ADD CONSTRAINT uc_departments_code UNIQUE (code);