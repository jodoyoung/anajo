/* Database 선택 */
-- use mysql;

/* Database 생성 */
--CREATE DATABASE anajo;
CREATE DATABASE anajo WITH OWNER = anajo

/* 사용자 생성 */
--INSERT INTO user (host, user, password) VALUES('%', 'anajo', PASSWORD('whdksk36'));
CREATE USER anajo WITH password 'whdksk36';

/* 설정 반영 */
--flush privileges;

/* 사용자 외부접속 허용 */
--GRANT ALL PRIVILEGES ON anajo.* TO 'anajo'@'%' IDENTIFIED BY 'whdksk36' WITH GRANT OPTION;
--GRANT ALL PRIVILEGES ON anajo.* TO 'anajo'@'localhost' IDENTIFIED BY 'whdksk36' WITH GRANT OPTION;

/* 설정 반영 */
--flush privileges;

/* 사용자 등록 확인 */
--SELECT host, user, password FROM user;

/* 사용자 스키마 생성 */
CREATE TABLE member (
	member_id CHAR(32) NOT NULL,
	email VARCHAR(50) NOT NULL,
	name VARCHAR(50) NOT NULL,
	password VARCHAR(50) NOT NULL,
	enabled SMALLINT DEFAULT 1 NOT NULL,
	reg_date TIMESTAMP NOT NULL DEFAULT now(),
	PRIMARY KEY (member_id),
	UNIQUE (email)
);

/* 권한 스키마 생성 */
CREATE TABLE role (
	role_id CHAR(32) NOT NULL,
	role_name VARCHAR(50) NOT NULL,
	description VARCHAR(100),
	PRIMARY KEY (role_id),
	UNIQUE (role_name)
);

/* 사용자별 권한 스키마 생성 */
CREATE TABLE member_role (
	member_id CHAR(32) NOT NULL,
	role_id CHAR(32) NOT NULL,
	PRIMARY KEY (member_id, role_id)
);

/* 메뉴 스키마 생성 */
CREATE TABLE menu (
	menu_id CHAR(32) NOT NULL,
	title VARCHAR(50) NOT NULL,
	link VARCHAR(100) NOT NULL,
	parent CHAR(32),
	PRIMARY KEY (menu_id)
);

/* 메뉴별 권한 스키마 생성 */
CREATE TABLE menu_role (
	menu_id CHAR(32) NOT NULL,
	role_id CHAR(32) NOT NULL,
	PRIMARY KEY (menu_id, role_id)
);

/* 게시판 스키마 생성 */
CREATE TABLE article (
 	article_id CHAR(32) NOT NULL,
 	category VARCHAR(50) NOT NULL,
	title VARCHAR(50) DEFAULT NULL,
	content VARCHAR(2000) DEFAULT NULL,
	reg_date TIMESTAMP NOT NULL DEFAULT now(),
	PRIMARY KEY  (article_id)
);