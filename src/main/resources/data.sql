INSERT INTO roles (id, name) VALUES (1, 'ROLE_ADMIN');
INSERT INTO roles (id, name) VALUES (2, 'ROLE_USER');

INSERT INTO users (id, username, password, email, role_id) VALUES (1, 'admin', '$2a$12$23g44nLphtBcgY7D34KSNOPKqxJp/B47ZTw7DUdNq6JQShv8e789u', 'admin@gmail.com', 1);

INSERT INTO users (id, username, password, email, role_id) VALUES (2, 'vero', '$2a$12$0LJb1p0Uvmsf2gn0f1zHA.OtaymnUazW0S2uJAP1aMNMhJA25D7n2', 'verosampedro@gmail.com', 2);

INSERT INTO requests (id, user_id, applicant_name, request_date, request_topic, request_description) VALUES (default, 1, 'Verónica', '2024-03-22', 'La imagen de este anime no carga ', 'Al entrar en la vista detalle de este anime no me carga la portada ' );

INSERT INTO requests (id, user_id, applicant_name, request_date, request_topic, request_description) VALUES (default, 2, 'Borja', '2024-03-22', 'La imagen de Vero no carga en el figma', 'Al entrar en el figma no se ve lo que solicité ' );