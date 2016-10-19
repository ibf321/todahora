/* 
 * Obs.: password '123' = $2a$10$5R/vxO9U5x.UW5WLZIDoFu0RnD9PfSY64j486PaULXq.oUeRbXuTm
 */
INSERT INTO todahora.USER(name, photo_url, email, password, enabled)
    VALUES ('Pablo Diego', 'avatar.png','pablo', '$2a$10$5R/vxO9U5x.UW5WLZIDoFu0RnD9PfSY64j486PaULXq.oUeRbXuTm', true);
INSERT INTO todahora.USER(name, photo_url, email, password, enabled)
    VALUES ('Administrator', 'avatar.png', 'admin', '$2a$10$5R/vxO9U5x.UW5WLZIDoFu0RnD9PfSY64j486PaULXq.oUeRbXuTm', true);

INSERT INTO todahora.user_profile(TYPE) VALUES ('ROLE_ADMIN');
INSERT INTO todahora.user_profile(TYPE) VALUES ('ROLE_USER');

INSERT INTO todahora.authority (user_id, user_profile_id) VALUES (2, 1);-- admin
INSERT INTO todahora.authority (user_id, user_profile_id) VALUES (1, 2);-- pablo
