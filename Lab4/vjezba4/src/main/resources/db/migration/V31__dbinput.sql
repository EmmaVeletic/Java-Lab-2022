INSERT INTO adress (id, street, city, postcode)
VALUES (5, 'Šoltanska 20', 'Split', '21000');
INSERT INTO client (id, first_name, last_name, adress_id)
VALUES (20, 'Emma', 'Emmic', 5);
INSERT INTO device (id, name, client_id)
VALUES (16, 'brojilo665', 20);
INSERT INTO data (id, date, time, value, device_id)
VALUES (55, '21.02.2022.', '11:00', 65, 16);