CREATE TABLE logins (
  id INTEGER PRIMARY KEY AUTO_INCREMENT,
  login VARCHAR(250) NOT NULL UNIQUE,
  password VARCHAR(30) NOT NULL,
  locked INTEGER NOT NULL,
  expired INTEGER NOT NULL,
  enabled INTEGER NOT NULL
);

CREATE TABLE Confirmation (
  id INTEGER PRIMARY KEY AUTO_INCREMENT,
  user_id INTEGER NOT NULL,
  confirmation_code VARCHAR(30) NOT NULL
);

INSERT INTO logins (login, password, locked, expired, enabled) VALUES ('admin', '123', 0, 0, 1);
INSERT INTO logins (login, password, locked, expired, enabled) VALUES ('user', '456', 0, 0, 1);
