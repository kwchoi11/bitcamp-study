-- 멤버 테이블에 예제 데이터 삽입
INSERT INTO college_member (mno, dept_no, name, email, password, pic_name, tel)
VALUES
    (1, 1, '메시', 'megot@example.com', '1111', 'megot.jpg', '987-654-3210');
    (2, 1, '호날두', 'siuu@test.com', '1111', 'siuu.jpg', '123-456-7890'),
    (3, 2, '박지성', 'jipark@example.com', '1111', 'jipark.jpg', '134-256-3789');
    (4, 2, '손흥민', 'sonny@example.com', '1111', 'sonny.jpg', '684-134-8942');
    (5, 3, '이강인', 'kang@example.com', '1111', 'kang.jpg', '681-512-9823');
    (6, 3, '조규성', 'doori@example.com', '1111', 'doori.jpg', '142-821-4322');

-- 학생 테이블에 예제 데이터 삽입
INSERT INTO college_student (mno, sno, date_of_birth)
VALUES
    (1, 10001, '1995-08-15'),
    (2, 10002, '1994-06-20');

-- 교직원 테이블에 예제 데이터 삽입
INSERT INTO college_faculty (fno, type, fax)
VALUES
    (1, 'Professor', '555-1234'),
    (2, 'Administrator', '555-5678');

-- 캠퍼스 테이블에 예제 데이터 삽입
INSERT INTO college_campus (cno, campus, tel, fax, post_no, bas_addr, det_addr)
VALUES
    (1, 'Main Campus', '123-4567', '123-4568', '12345', '123 Street', 'Suite 101'),
    (2, 'West Campus', '987-6543', '987-6544', '54321', '456 Avenue', 'Room 202');

-- 학과 테이블에 예제 데이터 삽입
INSERT INTO college_department (dept_no, cno, dept_name, dept_desc, tel)
VALUES
    (1, 1, 'Computer Science', 'Study of algorithms and programming', '555-1111'),
    (2, 2, 'Biology', 'Study of living organisms', '555-2222');

-- 게시판 테이블에 예제 데이터 삽입
INSERT INTO college_board (bno, dept_no, board_name)
VALUES
    (1, 1, 'CS Bulletin Board'),
    (2, 2, 'Biology Discussion');

-- 게시글 테이블에 예제 데이터 삽입
INSERT INTO college_posting (posting_no, bno, mno, title, content, posting_datetime, view_count)
VALUES
    (1, 1, 1, 'Introduction to Algorithms', 'This is a discussion about algorithms...', '2023-08-01 10:00:00', 100),
    (2, 2, 2, 'Genetic Mutation', 'Discussing recent findings in genetics...', '2023-08-02 14:30:00', 75);

-- 첨부파일 테이블에 예제 데이터 삽입
INSERT INTO college_file (fino, posting_no, finame)
VALUES
    (1, 1, 'algorithm.pdf'),
    (2, 2, 'mutation.jpg');

-- 공지사항 테이블에 예제 데이터 삽입
INSERT INTO college_notice (nno, fno, title, content, reg_date)
VALUES
    (1, 1, 'Important Announcement', 'There will be a faculty meeting...', '2023-07-15 09:00:00'),
    (2, 2, 'Campus Cleanup Day', 'Volunteers are needed for the cleanup...', '2023-07-20 14:00:00');
