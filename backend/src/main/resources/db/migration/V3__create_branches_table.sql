CREATE TABLE branches
(
    id UUID NOT NULL,
    created_at         TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    updated_at         TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    name               VARCHAR(1024) NOT NULL,
    commune_id UUID NOT NULL,
    additional_address VARCHAR(1024) NOT NULL,
    CONSTRAINT pk_branches PRIMARY KEY (id)
);

ALTER TABLE branches
    ADD CONSTRAINT uc_branches_name UNIQUE (name);

ALTER TABLE branches
    ADD CONSTRAINT FK_BRANCHES_ON_COMMUNE FOREIGN KEY (commune_id) REFERENCES communes (id) ON DELETE RESTRICT;