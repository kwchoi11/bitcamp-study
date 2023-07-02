package pj.handler;

import java.util.List;
import pj.util.BreadcrumbPrompt;
import pj.vo.Member;

public class MemberUpdateListener extends AbstractMemberListener {

  public MemberUpdateListener(List<Member> list) {
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

    m.setName(prompt.inputString("이름(%s): ", m.getName()));
    m.setBirthday(prompt.inputString("생년월일(%s): ", m.getBirthday()));
    m.setHeight(prompt.inputString("신장(%s): ", m.getHeight()));
    m.setWeight(prompt.inputString("체중(%s): ", m.getWeight()));
    m.setCareer(prompt.inputString("프로입단(%s): ", m.getCareer()));
    m.setHand(prompt.inputString("투/타(%s): ", m.getHand()));
    m.setPosition(inputPosition(m.getPosition(), prompt));
  }

}
