/* SHOW DATABASES */
SELECT datname FROM pg_database;

/* SHOW TABLES */
SELECT table_name FROM information_schema.tables WHERE table_schema = '스키마이름';

/* SHOW COLUMNS */
SELECT column_name FROM information_schema.columns WHERE table_name = '테이블이름';

/* 멤버 추가 */
INSERT INTO member (member_id, email, name, password, reg_date)
VALUES ('52251adbb28246d1b0d0758c1bf11e14', 'jodoyoung36@gmail.com', '조도영', 'Ta83ZXHVYBNFc+qENUgqqQ==', NOW());

/* 권한 추가 */
INSERT INTO role (role_id, role_name, description) VALUES ('6425c055a29c420fa438da47e977d923', 'ROLE_USER', '일반사용자');
INSERT INTO role (role_id, role_name, description) VALUES ('928987af25cf485880746d11e6efbbb8', 'ROLE_ADMIN', '관리자');

/* 멤버 권한 부여 */
INSERT INTO member_role (member_id, role_id) VALUES ('52251adbb28246d1b0d0758c1bf11e14', '6425c055a29c420fa438da47e977d923');
INSERT INTO member_role (member_id, role_id) VALUES ('52251adbb28246d1b0d0758c1bf11e14', '928987af25cf485880746d11e6efbbb8');

/* 메뉴 추가*/
INSERT INTO menu (menu_id, title, link) VALUES ('main', '메인', '/');
INSERT INTO menu (menu_id, title, link, parent) VALUES ('4464b9946023455ea0fb2c09b3f3654a', '권한', '/admin/role', 'main');
INSERT INTO menu (menu_id, title, link, parent) VALUES ('14428717410b481796e7c2fb3fa3b181', '메뉴', '/admin/menu', 'main');

/* 메뉴 권한 추가 */
INSERT INTO menu_role (menu_id, role_id) VALUES ('4464b9946023455ea0fb2c09b3f3654a', '928987af25cf485880746d11e6efbbb8');
INSERT INTO menu_role (menu_id, role_id) VALUES ('14428717410b481796e7c2fb3fa3b181', '928987af25cf485880746d11e6efbbb8');