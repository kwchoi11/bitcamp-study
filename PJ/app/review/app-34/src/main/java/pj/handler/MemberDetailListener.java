package pj.handler;

import java.util.List;
import pj.util.BreadcrumbPrompt;
import pj.vo.Member;

public class MemberDetailListener extends AbstractMemberListener {

  public MemberDetailListener(List<Member> list) {
    super(list);
  }

  @Override
  public void service(BreadcrumbPrompt prompt) {
    int memberNo = prompt.inputInt("번호: ");

    Member m = this.findBy(memberNo);
    if (m == null) {
      System.out.println("해당 번호의 회원이 없습니다!");
      return;
    }

    System.out.printf("이름: %s\n", m.getName());
    System.out.printf("생년월일: %s\n", m.getBirthday());
    System.out.printf("신장: %s\n", m.getHeight());
    System.out.printf("체중: %s\n", m.getWeight());
    System.out.printf("프로입단: %s\n", m.getCareer());
    System.out.printf("투/타: %s\n", m.getHand());
    System.out.printf("성별: %s\n", toPositionString(m.getPosition()));
  }
}
