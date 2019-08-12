DROP TABLE IF EXISTS food;

CREATE TABLE food (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
);

INSERT INTO food (name) VALUES
  ('Goiabada'),
  ('Feijoada'),
  ('Cu de peixe');