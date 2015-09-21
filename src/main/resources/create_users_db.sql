CREATE TABLE users (
  id INTEGER PRIMARY KEY AUTO_INCREMENT,
  login VARCHAR(250) NOT NULL,
  password VARCHAR(30) NOT NULL,
  locked INTEGER,
  expired INTEGER,
  enabled INTEGER
);

CREATE TABLE confirmations (
  id INTEGER PRIMARY KEY AUTO_INCREMENT,
  user_id INTEGER NOT NULL,
  confirmation_code VARCHAR(30) NOT NULL
);

INSERT INTO users VALUES (null, "admin", "123", 0, 0, 1);
INSERT INTO users VALUES (null, "user", "123", 0, 0, 1);
