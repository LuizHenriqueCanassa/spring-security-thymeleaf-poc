--senha-admin
INSERT INTO users
(id, username, password, created_at)
VALUES
    (nextval('users_id_seq'), 'admin', '$2a$12$iK8zxa40qF7iACKfoMlcnu/6/biu8qbuu1x4AhpaLKIaAFoXEIGw6', current_timestamp);

INSERT INTO roles
(id, name, created_at)
VALUES
    (nextval('roles_id_seq'), 'ROLE_ADMIN', current_timestamp);

INSERT INTO roles
(id, name, created_at)
VALUES
    (nextval('roles_id_seq'), 'ROLE_USER', current_timestamp);

INSERT INTO users_roles
(user_id, role_id)
VALUES
    (1, 1);