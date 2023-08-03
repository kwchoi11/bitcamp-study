package college.pj.handler;

import java.util.List;
import college.pj.dao.MemberDao;
import college.pj.util.ActionListener;
import college.pj.util.BreadcrumbPrompt;
import college.pj.vo.Member;

public class MemberListListener implements ActionListener {

  MemberDao memberDao;

  public MemberListListener(MemberDao memberDao) {
    this.memberDao = memberDao;
  }

  @Override
  public void service(BreadcrumbPrompt prompt) {
    prompt.println("---------------------------------------");
    prompt.println("번호, 이름, 이메일");
    prompt.println("---------------------------------------");

    List<Member> list = memberDao.findAll();
    for (Member m : list) {
      prompt.printf("%d, %s, %s\n",
          m.getNo(), m.getName(), m.getEmail());
    }
  }
}
