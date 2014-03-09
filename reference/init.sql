/* Database 선택 */
-- use mysql;

/* Database 생성 */
--CREATE DATABASE anajo;
CREATE DATABASE anajo CHARACTER SET utf8 COLLATE utf8_general_ci;

/* 사용자 생성 */
--INSERT INTO user (host, user, password) VALUES('%', 'anajo', PASSWORD('whdksk36'));
CREATE USER 'anajo' IDENTIFIED BY 'whdksk36';

/* 사용자 Database 권한 부여*/
GRANT ALL on anajo.* TO anajo@'%';

/* 설정 반영 */
flush privileges;

/* 사용자 외부접속 허용 */
--GRANT ALL PRIVILEGES ON anajo.* TO 'anajo'@'%' IDENTIFIED BY 'whdksk36' WITH GRANT OPTION;
--GRANT ALL PRIVILEGES ON anajo.* TO 'anajo'@'localhost' IDENTIFIED BY 'whdksk36' WITH GRANT OPTION;

/* 설정 반영 */
--flush privileges;

/* 사용자 등록 확인 */
--SELECT host, user, password FROM user;

/* 사용자 스키마 생성 */
CREATE TABLE member (
	member_id CHAR(32) NOT NULL COMMENT '사용자 ID',
	email VARCHAR(50) NOT NULL COMMENT 'Email 주소 ex) jodoyoung36@gmail.com',
	name VARCHAR(50) NOT NULL COMMENT '사용자명',
	password VARCHAR(50) NOT NULL COMMENT '로그인 비밀번호',
	enabled SMALLINT DEFAULT 1 NOT NULL COMMENT '활성화 상태',
	reg_date TIMESTAMP NOT NULL DEFAULT now() COMMENT '등록일자',
	PRIMARY KEY (member_id),
	UNIQUE (email)
);

/* 권한 스키마 생성 */
CREATE TABLE role (
	role_id CHAR(32) NOT NULL COMMENT '권한 ID',
	role_name VARCHAR(50) NOT NULL COMMENT '권한명',
	description VARCHAR(100) COMMENT '권한 설명',
	PRIMARY KEY (role_id),
	UNIQUE (role_name)
);

/* 사용자별 권한 스키마 생성 */
CREATE TABLE member_role (
	member_id CHAR(32) NOT NULL COMMENT '사용자 ID see) member table',
	role_id CHAR(32) NOT NULL COMMENT '권한 ID see) role table',
	PRIMARY KEY (member_id, role_id)
);

/* 메뉴 스키마 생성 */
CREATE TABLE menu (
	menu_id CHAR(32) NOT NULL COMMENT '메뉴 ID',
	title VARCHAR(50) NOT NULL COMMENT '메뉴명',
	link VARCHAR(100) NOT NULL COMMENT '메뉴 링크 주소',
	visible SMALLINT DEFAULT 1 NOT NULL COMMENT '화면 노출 상태',
	parent CHAR(32) COMMENT '상위 메뉴 ID',
	PRIMARY KEY (menu_id)
);

/* 메뉴별 권한 스키마 생성 */
CREATE TABLE menu_role (
	menu_id CHAR(32) NOT NULL COMMENT '메뉴 ID see) menu table',
	role_id CHAR(32) NOT NULL COMMENT '권한 ID see) role table',
	PRIMARY KEY (menu_id, role_id)
);

/* 게시판 스키마 생성 */
CREATE TABLE article (
 	article_id CHAR(32) NOT NULL COMMENT '게시물 ID',
 	category VARCHAR(50) NOT NULL COMMENT '게시물 분류',
	title VARCHAR(50) DEFAULT NULL COMMENT '제목',
	content VARCHAR(2000) DEFAULT NULL COMMENT '본문(html)',
	reg_date TIMESTAMP NOT NULL DEFAULT now() COMMENT '작성일',
	PRIMARY KEY  (article_id)
);