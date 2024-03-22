INSERT INTO roles (id, name) VALUES (1, 'ROLE_ADMIN');
INSERT INTO roles (id, name) VALUES (2, 'ROLE_USER');

-- password admin: password
INSERT INTO users (id, username, password, email, role_id) VALUES (1, 'admin', '$2a$12$23g44nLphtBcgY7D34KSNOPKqxJp/B47ZTw7DUdNq6JQShv8e789u', 'admin@gmail.com', 1);

-- password vero: otaku
INSERT INTO users (id, username, password, email, role_id) VALUES (2, 'vero', '$2a$12$0LJb1p0Uvmsf2gn0f1zHA.OtaymnUazW0S2uJAP1aMNMhJA25D7n2', 'verosampedro@gmail.com', 2);


INSERT INTO requests (id, applicantName, requestDate, requestTopic, requestDescription) VALUES (default, 'Verónica', '2024-03-22', 'La imagen de este anime no carga ', 'Al entrar en la vista detalle de este anime no me carga la portada ' );

INSERT INTO requests (id, applicantName, requestDate, requestTopic, requestDescription) VALUES (default, 'Borja', '2024-03-17', 'No me gusta esta página ', 'Vero me cae mal y no me gusta su proyecto personal ' );
