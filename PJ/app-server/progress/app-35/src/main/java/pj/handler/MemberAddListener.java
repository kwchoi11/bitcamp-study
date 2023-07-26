package pj.handler;

import java.util.List;
import pj.util.BreadcrumbPrompt;
import pj.vo.Member;

public class MemberAddListener extends AbstractMemberListener {

  public MemberAddListener(List<Member> list) {
    super(list);
  }

  @Override
  public void service(BreadcrumbPrompt prompt) {
    Member m = new Member();
    m.setName(prompt.inputString("선수의 이름: "));
    m.setBirthday(prompt.inputString("생년월일: "));
    m.setHeight(prompt.inputString("신장: "));
    m.setWeight(prompt.inputString("체중: "));
    m.setCareer(prompt.inputString("프로입단: "));
    m.setHand(prompt.inputString("투/타: "));
    m.setPosition(inputPosition((char) 0, prompt));

    this.list.add(m);
  }
}
