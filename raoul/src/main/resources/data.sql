INSERT INTO Client (id, first_name, last_name, email, phone_number, current_balance) VALUES (1, 'Raoul', 'Kasparian', 'raoul.kasparian@test.com', '0303030303030', 2250);
INSERT INTO Client (id, first_name, last_name, email, phone_number, current_balance) VALUES (2, 'TEST', 'TEST', 'test.test@test.com', '0202020202020', 3000.15);

INSERT INTO Operation_type (id, name) VALUES (1, 'DEPOSIT');
INSERT INTO Operation_type (id, name) VALUES (2, 'WITHDRAWAL');
INSERT INTO Operation_type (id, name) VALUES (3, 'CHECKING');

INSERT INTO Operation (operation_type, operation_date, amount, client) VALUES (1, '2022-01-01', 3000, 1);
INSERT INTO Operation (operation_type, operation_date, amount, client) VALUES (2, '2022-02-01', 750, 1);
INSERT INTO Operation (operation_type, operation_date, amount, client) VALUES (1, '2022-02-02', 3000.15, 2);