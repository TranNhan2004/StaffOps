CREATE TABLE communes
(
    id UUID NOT NULL,
    name VARCHAR(127) NOT NULL,
    province_id UUID NOT NULL,
    CONSTRAINT pk_communes PRIMARY KEY (id)
);

ALTER TABLE communes
    ADD CONSTRAINT uc_communes_name UNIQUE (name);

ALTER TABLE communes
    ADD CONSTRAINT FK_COMMUNES_ON_PROVINCE FOREIGN KEY (province_id) REFERENCES provinces (id) ON DELETE RESTRICT;