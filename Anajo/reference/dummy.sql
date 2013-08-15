/* SHOW DATABASES */
SELECT datname FROM pg_database;

/* SHOW TABLES */
SELECT table_name FROM information_schema.tables WHERE table_schema = '스키마이름';

/* SHOW COLUMNS */
SELECT column_name FROM information_schema.columns WHERE table_name = '테이블이름';

/* 멤버 추가 */
INSERT INTO member (member_id, email, password, reg_date)
VALUES ('52251adbb28246d1b0d0758c1bf11e14', 'jodoyoung36@gmail.com', '14a257d63c5a29be7a26ceeb53f8bcc1', NOW());

/* 권한 추가 */
INSERT INTO role (role_id, role_name) VALUES ('6425c055a29c420fa438da47e977d923', 'ROLE_USER', '일반사용자');
INSERT INTO role (role_id, role_name) VALUES ('928987af25cf485880746d11e6efbbb8', 'ROLE_ADMIN', '관리자');

/* 멤버 권한 부여 */
INSERT INTO member_role (member_id, role_id) VALUES ('52251adbb28246d1b0d0758c1bf11e14', '6425c055a29c420fa438da47e977d923');
INSERT INTO member_role (member_id, role_id) VALUES ('52251adbb28246d1b0d0758c1bf11e14', '928987af25cf485880746d11e6efbbb8');

/* 메뉴 추가*/
INSERT INTO menu (menu_id, title, link) VALUES ('4464b9946023455ea0fb2c09b3f3654a', '권한', '/role');

/* 메뉴 권한 추가 */
INSERT INTO menu_role (menu_id, role_id) VALUES ('4464b9946023455ea0fb2c09b3f3654a', '928987af25cf485880746d11e6efbbb8');