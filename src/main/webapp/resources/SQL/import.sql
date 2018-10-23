
INSERT INTO admin_details VALUES (1);

INSERT INTO user (id, address, email, first_name, last_name, password, phone_number, role) VALUES (1, "comontest", "USER@test.pl", "testcomon", "testcomon", "pr@cEk`123", "00000", "ROLE_USER");

INSERT INTO user (id, address, email, first_name, last_name, password, phone_number, role, users_to_verify) VALUES (2, "fightertest", "FIGHTER@test.pl", "testfighter", "testfighter", "pr@cEk`123", "000001", "ROLE_USER", 1);

INSERT INTO fighter_details (id, discipline, gender, hight, team, weight, year_of_birth, user_id) VALUES (1, "MIXED_MARCIAL_ARTS", "MALE", 1.90, "TESTTEAM", 87.89, "1999-03-09", 2);

INSERT INTO user (id, address, email, first_name, last_name, password, phone_number, role, users_to_verify) VALUES (3, "menagertest", "MENAGER@test.pl", "testmenager", "testmenager", "pr@cEk`123", "000002", "ROLE_USER", 1);

INSERT INTO menager_details (id, organization_name, user_id, federations_to_verify) VALUES (1, "TEST FEDERACJA", 3, 1);

INSERT INTO user (id, address, email, first_name, last_name, password, phone_number, role) VALUES (4, "ADMIN", "ADMIN@test.pl", "admin", "admin", "pr@cEk`123", "000005", "ROLE_ADMIN");
