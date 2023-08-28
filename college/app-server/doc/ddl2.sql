-- 학생
DROP TABLE IF EXISTS college_student RESTRICT;

-- 교직원
DROP TABLE IF EXISTS college_faculty RESTRICT;

-- 캠퍼스
DROP TABLE IF EXISTS college_campus RESTRICT;

-- 학과
DROP TABLE IF EXISTS college_department RESTRICT;

-- 게시글
DROP TABLE IF EXISTS college_post RESTRICT;

-- 첨부파일
DROP TABLE IF EXISTS college_file RESTRICT;

-- 공지사항
DROP TABLE IF EXISTS college_notice RESTRICT;

-- 멤버
DROP TABLE IF EXISTS college_member RESTRICT;

-- 게시판
DROP TABLE IF EXISTS college_board RESTRICT;

-- 학생
CREATE TABLE college_student (
  mno           INTEGER     NOT NULL COMMENT '멤버번호', -- 멤버번호
  sno           INTEGER     NOT NULL COMMENT '학번', -- 학번
  date_of_birth VARCHAR(15) NOT NULL COMMENT '생년월일' -- 생년월일
)
COMMENT '학생';

-- 학생
ALTER TABLE college_student
  ADD CONSTRAINT PK_college_student -- 학생 기본키
  PRIMARY KEY (
  mno -- 멤버번호
  );

-- 학생 유니크 인덱스
CREATE UNIQUE INDEX UIX_college_student
  ON college_student ( -- 학생
  );

-- 학생 유니크 인덱스2
CREATE UNIQUE INDEX UIX_college_student2
  ON college_student ( -- 학생
  );

-- 학생 유니크 인덱스3
CREATE UNIQUE INDEX UIX_college_student3
  ON college_student ( -- 학생
  );

-- 교직원
CREATE TABLE college_faculty (
  fno  INTEGER     NOT NULL COMMENT '교직원번호', -- 교직원번호
  type VARCHAR(50) NOT NULL COMMENT '유형', -- 유형
  fax  VARCHAR(30) NULL     COMMENT '팩스' -- 팩스
)
COMMENT '교직원';

-- 교직원
ALTER TABLE college_faculty
  ADD CONSTRAINT PK_college_faculty -- 교직원 기본키
  PRIMARY KEY (
  fno -- 교직원번호
  );

-- 캠퍼스
CREATE TABLE college_campus (
  cno      INTEGER      NOT NULL COMMENT '캠퍼스번호', -- 캠퍼스번호
  campus   VARCHAR(50)  NOT NULL COMMENT '캠퍼스', -- 캠퍼스
  tel      VARCHAR(30)  NOT NULL COMMENT '대표번호', -- 대표번호
  fax      VARCHAR(30)  NOT NULL COMMENT '대표팩스', -- 대표팩스
  post_no  VARCHAR(10)  NOT NULL COMMENT '우편번호', -- 우편번호
  bas_addr VARCHAR(255) NOT NULL COMMENT '기본주소', -- 기본주소
  det_addr VARCHAR(255) NOT NULL COMMENT '상세주소' -- 상세주소
)
COMMENT '캠퍼스';

-- 캠퍼스
ALTER TABLE college_campus
  ADD CONSTRAINT PK_college_campus -- 캠퍼스 기본키
  PRIMARY KEY (
  cno -- 캠퍼스번호
  );

-- 캠퍼스 유니크 인덱스
CREATE UNIQUE INDEX UIX_college_campus
  ON college_campus ( -- 캠퍼스
    campus ASC -- 캠퍼스
  );

-- 학과
CREATE TABLE college_department (
  dept_no   INTEGER     NOT NULL COMMENT '학과 번호', -- 학과 번호
  cno       INTEGER     NOT NULL COMMENT '캠퍼스번호', -- 캠퍼스번호
  dept_name VARCHAR(50) NOT NULL COMMENT '학과명', -- 학과명
  dept_desc MEDIUMTEXT  NULL     COMMENT '학과설명', -- 학과설명
  tel       VARCHAR(30) NOT NULL COMMENT '전화' -- 전화
)
COMMENT '학과';

-- 학과
ALTER TABLE college_department
  ADD CONSTRAINT PK_college_department -- 학과 기본키
  PRIMARY KEY (
  dept_no -- 학과 번호
  );

-- 게시글
CREATE TABLE college_posting (
  posting_no       INTEGER     NOT NULL COMMENT '게시글번호', -- 게시글번호
  bno              INTEGER     NOT NULL COMMENT '게시판번호', -- 게시판번호
  mno              INTEGER     NOT NULL COMMENT '멤버번호', -- 멤버번호
  title            VARCHAR(50) NOT NULL COMMENT '제목', -- 제목
  content          MEDIUMTEXT  NOT NULL COMMENT '내용', -- 내용
  posting_datetime DATETIME    NOT NULL COMMENT '작성일시', -- 작성일시
  view_count       INTEGER     NOT NULL COMMENT '조회수' -- 조회수
)
COMMENT '게시글';

-- 게시글
ALTER TABLE college_post
  ADD CONSTRAINT PK_college_post -- 게시글 기본키
  PRIMARY KEY (
  posting_no -- 게시글번호
  );

-- 첨부파일
CREATE TABLE college_file (
  fino       INTEGER      NOT NULL COMMENT '첨부파일번호', -- 첨부파일번호
  posting_no INTEGER      NOT NULL COMMENT '게시글번호', -- 게시글번호
  finame     VARCHAR(255) NOT NULL COMMENT '파일명' -- 파일명
)
COMMENT '첨부파일';

-- 첨부파일
ALTER TABLE college_file
  ADD CONSTRAINT PK_college_file -- 첨부파일 기본키
  PRIMARY KEY (
  fino -- 첨부파일번호
  );

-- 공지사항
CREATE TABLE college_notice (
  nno      INTEGER     NOT NULL COMMENT '공지사항번호', -- 공지사항번호
  fno      INTEGER     NOT NULL COMMENT '교직원번호', -- 교직원번호
  title    VARCHAR(50) NOT NULL COMMENT '제목', -- 제목
  content  MEDIUMTEXT  NOT NULL COMMENT '내용', -- 내용
  reg_date DATETIME    NOT NULL COMMENT '등록일시' -- 등록일시
)
COMMENT '공지사항';

-- 공지사항
ALTER TABLE college_notice
  ADD CONSTRAINT PK_college_notice -- 공지사항 기본키
  PRIMARY KEY (
  nno -- 공지사항번호
  );

-- 멤버
CREATE TABLE college_member (
  mno      INTEGER      NOT NULL COMMENT '멤버번호', -- 멤버번호
  dept_no  INTEGER      NOT NULL COMMENT '학과 번호', -- 학과 번호
  name     VARCHAR(50)  NOT NULL COMMENT '이름', -- 이름
  email    VARCHAR(40)  NOT NULL COMMENT '이메일', -- 이메일
  password VARCHAR(15)  NOT NULL COMMENT '비밀번호', -- 비밀번호
  pic_name VARCHAR(255) NOT NULL COMMENT '사진파일명', -- 사진파일명
  tel      VARCHAR(30)  NULL     COMMENT '전화번호' -- 전화번호
)
COMMENT '멤버';

-- 멤버
ALTER TABLE college_member
  ADD CONSTRAINT PK_college_member -- 멤버 기본키
  PRIMARY KEY (
  mno -- 멤버번호
  );

-- 게시판
CREATE TABLE college_board (
  bno        INTEGER     NOT NULL COMMENT '게시판번호', -- 게시판번호
  dept_no    INTEGER     NOT NULL COMMENT '학과 번호', -- 학과 번호
  board_name VARCHAR(50) NOT NULL COMMENT '게시판명' -- 게시판명
)
COMMENT '게시판';

-- 게시판
ALTER TABLE college_board
  ADD CONSTRAINT PK_college_board -- 게시판 기본키
  PRIMARY KEY (
  bno -- 게시판번호
  );

-- 학생
ALTER TABLE college_student
  ADD CONSTRAINT FK_college_member_TO_college_student -- 멤버 -> 학생
  FOREIGN KEY (
  mno -- 멤버번호
  )
  REFERENCES college_member ( -- 멤버
  mno -- 멤버번호
  );

-- 교직원
ALTER TABLE college_faculty
  ADD CONSTRAINT FK_college_member_TO_college_faculty -- 멤버 -> 교직원
  FOREIGN KEY (
  fno -- 교직원번호
  )
  REFERENCES college_member ( -- 멤버
  mno -- 멤버번호
  );

-- 학과
ALTER TABLE college_department
  ADD CONSTRAINT FK_college_campus_TO_college_department -- 캠퍼스 -> 학과
  FOREIGN KEY (
  cno -- 캠퍼스번호
  )
  REFERENCES college_campus ( -- 캠퍼스
  cno -- 캠퍼스번호
  );

-- 게시글
ALTER TABLE college_post
  ADD CONSTRAINT FK_college_member_TO_college_post -- 멤버 -> 게시글
  FOREIGN KEY (
  mno -- 멤버번호
  )
  REFERENCES college_member ( -- 멤버
  mno -- 멤버번호
  );

-- 게시글
ALTER TABLE college_post
  ADD CONSTRAINT FK_college_board_TO_college_post -- 게시판 -> 게시글
  FOREIGN KEY (
  bno -- 게시판번호
  )
  REFERENCES college_board ( -- 게시판
  bno -- 게시판번호
  );

-- 첨부파일
ALTER TABLE college_file
  ADD CONSTRAINT FK_college_post_TO_college_file -- 게시글 -> 첨부파일
  FOREIGN KEY (
  posting_no -- 게시글번호
  )
  REFERENCES college_post ( -- 게시글
  posting_no -- 게시글번호
  );

-- 공지사항
ALTER TABLE college_notice
  ADD CONSTRAINT FK_college_faculty_TO_college_notice -- 교직원 -> 공지사항
  FOREIGN KEY (
  fno -- 교직원번호
  )
  REFERENCES college_faculty ( -- 교직원
  fno -- 교직원번호
  );

-- 멤버
ALTER TABLE college_member
  ADD CONSTRAINT FK_college_department_TO_college_member -- 학과 -> 멤버
  FOREIGN KEY (
  dept_no -- 학과 번호
  )
  REFERENCES college_department ( -- 학과
  dept_no -- 학과 번호
  );

-- 게시판
ALTER TABLE college_board
  ADD CONSTRAINT FK_college_department_TO_college_board -- 학과 -> 게시판
  FOREIGN KEY (
  dept_no -- 학과 번호
  )
  REFERENCES college_department ( -- 학과
  dept_no -- 학과 번호
  );