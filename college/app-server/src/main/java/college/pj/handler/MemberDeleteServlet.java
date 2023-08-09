package college.pj.handler;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import college.pj.vo.Member;


@WebServlet("/member/delete")
public class MemberDeleteServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    Member loginUser = (Member) request.getSession().getAttribute("loginUser");

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    if (loginUser.getNo() != Integer.parseInt(request.getParameter("no"))  && loginUser.getLevel() != 2) {
      out.println("<p>권한이 없습니다.</p>");
      out.println("<meta http-equiv='refresh' content='1;url=/member/list'>");
      return;
    }

    try {
      if (InitServlet.memberDao.delete(Integer.parseInt(request.getParameter("no"))) == 0) {
        throw new Exception("해당 번호의 회원이 없습니다.");
      } else {
        response.sendRedirect("/member/list");
      }
      InitServlet.sqlSessionFactory.openSession(false).commit();

    } catch (Exception e) {
      InitServlet.sqlSessionFactory.openSession(false).rollback();
      throw new RuntimeException(e);
    }
  }

}