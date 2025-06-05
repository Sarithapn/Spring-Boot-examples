CREATE TABLE users (
    username VARCHAR(50) NOT NULL PRIMARY KEY,
    password VARCHAR(100) NOT NULL,
    enabled BOOLEAN NOT NULL
);

CREATE TABLE authorities (
    username VARCHAR(50) NOT NULL,
    authority VARCHAR(50) NOT NULL,
    CONSTRAINT fk_authorities_users FOREIGN KEY(username) REFERENCES users(username)
);

CREATE UNIQUE INDEX ix_auth_username ON authorities (username, authority);

INSERT INTO users (username, password, enabled) VALUES
  ('user', 'pass', true),
  ('admin', 'pass', true);

INSERT INTO authorities (username, authority) VALUES
  ('user', 'ROLE_USER'),
  ('admin', 'ROLE_ADMIN');

  CREATE TABLE jpausers (
     id BIGINT NOT NULL  PRIMARY KEY,
      username VARCHAR(50) NOT NULL,
      password VARCHAR(100) NOT NULL,
      enabled BOOLEAN NOT NULL,
      role VARCHAR(100) NOT NULL
  );
 INSERT INTO jpausers (id, username, password, enabled, role) VALUES
   (1, 'user', 'pass', true, 'ROLE_USER'),
   (2, 'admin', 'pass', true, 'ROLE_ADMIN');