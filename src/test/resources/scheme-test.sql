CREATE TABLE users (
  username     VARCHAR_IGNORECASE(50) NOT NULL PRIMARY KEY,
  password     VARCHAR(100)           NOT NULL,
  enabled      BOOLEAN                NOT NULL,
  email        VARCHAR_IGNORECASE(50) NOT NULL,
  dateregister DATE                   NOT NULL
);
CREATE TABLE userdetails (
  username    VARCHAR_IGNORECASE(50) NOT NULL PRIMARY KEY,
  firstname   VARCHAR(50),
  lastname    VARCHAR(50),
  dateofbirth DATE,
  CONSTRAINT fk_userdetails_user FOREIGN KEY (username) REFERENCES users (username)
);
CREATE SEQUENCE role_id
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE;
CREATE TABLE roles (
  id        INTEGER GENERATED BY DEFAULT AS SEQUENCE role_id PRIMARY KEY,
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
CREATE SEQUENCE group_id
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE;
CREATE TABLE GROUPS(
  id INTEGER GENERATED BY DEFAULT AS SEQUENCE group_id PRIMARY KEY,
  name VARCHAR(50) NOT NULL,
  description VARCHAR (200)
);
CREATE SEQUENCE usergrouprole_id
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE;
CREATE TABLE USERGROUPROLE(
  id INTEGER GENERATED BY DEFAULT AS SEQUENCE usergrouprole_id PRIMARY KEY NOT NULL,
  username VARCHAR_IGNORECASE(50) NOT NULL,
  groupid INTEGER NOT NULL,
  datefrom DATE NOT NULL,
  dateto DATE NOT NULL,
  grouprole VARCHAR(20),
  CONSTRAINT fk_usergrouprole_users FOREIGN KEY (username) REFERENCES users (username),
  CONSTRAINT fk_usergrouprole_groups FOREIGN KEY (groupid) REFERENCES groups (id)
);
INSERT INTO roles (role_name) VALUES ('ROLE_USER');
INSERT INTO roles (role_name) VALUES ('ROLE_ADMIN');
INSERT INTO users VALUES ('user1', 'user1', TRUE, 'test@t.t', '2010-01-01');
INSERT INTO userroles VALUES ('user1', 1);
INSERT INTO userdetails VALUES ('user1', 'firstname', 'lastname', '1998-01-01');
INSERT INTO GROUPS (name, description) VALUES ('TestGroup1', 'This is TestGroup1');
INSERT INTO USERGROUPROLE(username, groupid, datefrom, dateto, grouprole) VALUES ('user1', 1, '2010-01-01', '2099-01-01', 'TREASURER');