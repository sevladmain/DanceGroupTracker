create table users(
      username varchar_ignorecase(50) not null primary key,
      password varchar_ignorecase(50) not null,
      enabled boolean not null,
      dateregister DATE not null);

create table roles (
      id INTEGER not null primary key,
      role_name varchar_ignorecase(50) not null);

  create table roles (
      username varchar_ignorecase(50) not null,
      role_id INTEGER not null,
      constraint fk_authorities_users foreign key(username) references users(username),
      constraint fk_authorities_roles foreign key(role_id) references roles(id));
      create unique index ix_auth_username on roles (username,role_id);
