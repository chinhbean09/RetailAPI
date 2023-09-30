-- Create table users
CREATE TABLE users (
                       username VARCHAR(50) NOT NULL PRIMARY KEY,
                       password VARCHAR(500) NOT NULL,
                       enabled BIT NOT NULL
);

-- Create table authorities
CREATE TABLE authorities (
                             username VARCHAR(50) NOT NULL,
                             authority VARCHAR(50) NOT NULL,
                             CONSTRAINT fk_authorities_users FOREIGN KEY (username) REFERENCES users (username)
);

-- Create unique index on authorities
CREATE UNIQUE INDEX ix_auth_username ON authorities (username, authority);

-- Create table customer
CREATE TABLE customer (
                          id INT IDENTITY(1,1) PRIMARY KEY,
                          username VARCHAR(50) NOT NULL,
                          password VARCHAR(500) NOT NULL,
                          role VARCHAR(50) NOT NULL
);
INSERT INTO customer (id, username, password, role)
VALUES (1, 'chinhdo1', 'chinhdo', 'user');
