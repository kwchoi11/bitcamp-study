package college.pj.handler;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import college.pj.vo.Member;

@WebServlet("/member/update")
public class MemberUpdateServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    Member loginUser = (Member) request.getSession().getAttribute("loginUser");

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    // 로그인 사용자가 관리자가 아니고 로그인 사용자의 번호와 변경하려는 회원 번호가 같지 않을 때
    // 변경 작업을 할 수 없다.
    if (loginUser.getNo() != Integer.parseInt(request.getParameter("no"))  && loginUser.getLevel() != 2) {
      out.println("<p>권한이 없습니다.</p>");
      out.println("<meta http-equiv='refresh' content='1;url=/member/list'>");
      return;
    }

    Member member = new Member();
    member.setNo(Integer.parseInt(request.getParameter("no")));
    member.setName(request.getParameter("name"));
    member.setEmail(request.getParameter("email"));
    member.setPassword(request.getParameter("password"));
    member.setGender(request.getParameter("gender").charAt(0));

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<meta http-equiv='refresh' content='1;url=/member/list'>");
    out.println("<title>회원</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>회원 변경</h1>");

    try {
      if (InitServlet.memberDao.update(member) == 0) {
        out.println("<p>회원이 없습니다.</p>");
      } else {
        InitServlet.sqlSessionFactory.openSession(false).commit();
        out.println("<p>변경했습니다!</p>");
      }
    } catch (Exception e) {
      InitServlet.sqlSessionFactory.openSession(false).rollback();
      out.println("<p>변경 실패입니다!</p>");
      e.printStackTrace();
    }

    out.println("</body>");
    out.println("</html>");
  }
}
