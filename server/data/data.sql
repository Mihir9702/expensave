BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role)
VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role)
VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

INSERT INTO expenses (amount,description,date,user_id) VALUES (100.00,'Lunch',CURRENT_TIMESTAMP,1);
INSERT INTO expenses (amount,description,date,user_id) VALUES (200.00,'Dinner',CURRENT_TIMESTAMP,1);
INSERT INTO expenses (amount,description,date,user_id) VALUES (300.00,'Breakfast',CURRENT_TIMESTAMP,2);
INSERT INTO expenses (amount,description,date,user_id) VALUES (400.00,'Supper',CURRENT_TIMESTAMP,2);

INSERT INTO users (username, password_hash, role)
VALUES ('mihir', '$2a$10$ov06rineTJ6aGgqX4T2EFeVsnhAKyJK2ZHcrNIJIBvp/cC/bz20Du', 'ROLE_USER');

INSERT INTO expenses (amount, description, date, user_id) VALUES (65.00, 'Gym Membership', '2024-04-07', 3);
INSERT INTO expenses (amount, description, date, user_id) VALUES (20.00, 'Lunch', '2024-04-10', 3);
INSERT INTO expenses (amount, description, date, user_id) VALUES (35.00, 'Groceries', '2024-04-10', 3);
INSERT INTO expenses (amount, description, date, user_id) VALUES (5.00, 'Coffee', '2024-04-11', 3);
INSERT INTO expenses (amount, description, date, user_id) VALUES (165.00, 'Glasses', '2024-04-15', 3);
INSERT INTO expenses (amount, description, date, user_id) VALUES (10.00, 'Spaghetti', '2024-04-21', 3);
INSERT INTO expenses (amount, description, date, user_id) VALUES (20.00, 'Go Puff', '2024-04-21', 3);




COMMIT TRANSACTION;
