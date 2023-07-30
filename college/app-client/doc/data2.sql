-- college_member 테이블 예제 데이터
insert into college_member(member_no, name, email, password, gender) 
  values(1, 'Manager', 'manager@test.com', sha1('1111'), 'W');
insert into college_member(member_no, name, email, password, gender) 
  values(2, 'bbb', 'bbb@test.com', sha1('1111'), 'M');
insert into college_member(member_no, name, email, password, gender) 
  values(3, 'ccc', 'ccc@test.com', sha1('1111'), 'W');
insert into college_member(member_no, name, email, password, gender) 
  values(4, 'ddd', 'ddd@test.com', sha1('1111'), 'M');
insert into college_member(member_no, name, email, password, gender) 
  values(5, 'eee', 'eee@test.com', sha1('1111'), 'W');
insert into college_member(member_no, name, email, password, gender) 
  values(6, 'fff', 'fff@test.com', sha1('1111'), 'M');

-- college_board 테이블 예제 데이터
insert into college_board(board_no, title, content, writer, password, category)
  values(1, '[필독] 공지사항 1', '내용', 1, sha1('1111'), 1);
insert into college_board(board_no, title, content, writer, password, category)
  values(2, '[필독] 공지사상 2', '내용', 1, sha1('1111'), 1);
insert into college_board(board_no, title, content, writer, password, category)
  values(3, '해킹동아리 모집', '내용', 2, sha1('1111'), 2);
insert into college_board(board_no, title, content, writer, password, category)
  values(4, '학부연구생 및 대학원생 모집', '내용', 1, sha1('1111'), 2);
insert into college_board(board_no, title, content, writer, password, category)
  values(5, '축구동아리 모집', '내용', 4, sha1('1111'), 2);
insert into college_board(board_no, title, content, writer, password, category)
  values(6, '멘토링 프로그램 멘토 모집', '내용', 1, sha1('1111'), 2);
insert into college_board(board_no, title, content, writer, password, category)
  values(7, 'ㅇㅇ공모전 팀원 모집', '내용', 3, sha1('1111'), 2);
insert into college_board(board_no, title, content, writer, password, category)
  values(8, '같이 밥 먹어줄 사람,,', '내용', 5, sha1('1111'), 3);
insert into college_board(board_no, title, content, writer, password, category)
  values(9, '할맥에서 시원하게 맥주ㄱ?', '내용', 6, sha1('1111'), 3);
insert into college_board(board_no, title, content, writer, password, category)
  values(10, '[양식] 자퇴원서', '내용', 1, sha1('1111'), 4);
insert into college_board(board_no, title, content, writer, password, category)
  values(11, '[양식] 졸업논문 및 실기발표 심사신청서', '내용', 1, sha1('1111'), 4);
insert into college_board(board_no, title, content, writer, password, category)
  values(12, '[양식] 졸업논문 및 실기발표 지도교수 승인/변경 신청서', '내용', 1, sha1('1111'), 4);