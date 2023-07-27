package pj.dao;

import java.util.List;
import pj.vo.Member;

public interface MemberDao {
  void insert(Member member);
  List<Member> list();
  Member findBy(Member member);
  int update(Member member);
  int delete(int no);
}
