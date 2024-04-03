BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

INSERT INTO expenses (amount,description,date,user_id) VALUES (100.00,'Lunch',CURRENT_TIMESTAMP,1);
INSERT INTO expenses (amount,description,date,user_id) VALUES (200.00,'Dinner',CURRENT_TIMESTAMP,1);
INSERT INTO expenses (amount,description,date,user_id) VALUES (300.00,'Breakfast',CURRENT_TIMESTAMP,2);
INSERT INTO expenses (amount,description,date,user_id) VALUES (400.00,'Supper',CURRENT_TIMESTAMP,2);


COMMIT TRANSACTION;
