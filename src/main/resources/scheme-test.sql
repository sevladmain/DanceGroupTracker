CREATE TABLE users (
  username     VARCHAR_IGNORECASE(50) NOT NULL PRIMARY KEY,
  password     VARCHAR_IGNORECASE(50) NOT NULL,
  enabled      BOOLEAN                NOT NULL,
  email        VARCHAR_IGNORECASE(50) NOT NULL,
  dateregister DATE                   NOT NULL
);

CREATE TABLE roles (
  id        INTEGER                NOT NULL PRIMARY KEY,
  role_name VARCHAR_IGNORECASE(50) NOT NULL
);

CREATE TABLE userroles (
  username VARCHAR_IGNORECASE(50) NOT NULL,
  role_id  INTEGER                NOT NULL,
  CONSTRAINT fk_authorities_users FOREIGN KEY (username) REFERENCES users (username),
  CONSTRAINT fk_authorities_roles FOREIGN KEY (role_id) REFERENCES roles (id)
);
CREATE UNIQUE INDEX ix_auth_username
  ON userroles (username, role_id);

INSERT INTO roles VALUES (1, 'ROLE_USER');