package pj.handler;

import java.util.Iterator;
import java.util.List;
import pj.util.BreadcrumbPrompt;
import pj.vo.Member;

public class MemberListListener extends AbstractMemberListener {

  public MemberListListener(List<Member> list) {
    super(list);
  }

  @Override
  public void service(BreadcrumbPrompt prompt) {
    System.out.println("---------------------------------------------------------");
    System.out.println("번호, 이름, 생년월일, 신장, 체중, 프로입단, 투/타, 포지션");
    System.out.println("---------------------------------------------------------");

    // 목록에서 데이터를 대신 꺼내주는 객체를 얻는다.
    Iterator<Member> iterator = list.iterator();
    while (iterator.hasNext()) {
      Member m = iterator.next();
      System.out.printf("%d, %s, %s, %s ,%s, %s, %s, %s\n", m.getNo(), m.getName(), m.getBirthday(),
          m.getHeight(), m.getWeight(), m.getCareer(), m.getHand(),
          toPositionString(m.getPosition()));
    }
  }

}
